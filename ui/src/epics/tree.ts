import { RootEpic, RootState } from '@store'
import { catchError, concat, concatWith, EMPTY, expand, filter, from, last, map, mergeMap, Observable, of, race, switchMap } from 'rxjs'
import { DataItem, utils, WidgetFieldBase } from '@cxbox-ui/core'
import { actions } from '@actions'
import { isAnyOf } from '@reduxjs/toolkit'
import { buildBcUrl } from '@utils/buildBcUrl'
import { selectBcFilters } from '@selectors/selectors'
import { getUniqueValues, pick, treeActions } from '@slices/tree'
import { FilterType } from '@interfaces/filters'
import { FIELDS } from '@constants'
import { isDefined } from '@utils/isDefined'
import { buildBcFetchContext, getBcFetchSideEffects } from './data/bcFetchDataEpic'
import { DEFAULT_PAGE, MAIN_DEFAULT_PAGINATION_TYPE, PaginationMode } from '@constants/pagination'
import { isDataItemMatchedByFilters } from '@utils/filterMatch'
import { getTreeFieldKeys } from '@utils/tree'
import { isTreeWidget } from '@constants/widget'
import { AppWidgetMeta, CustomWidgetTypes } from '@interfaces/widget'
import {
    TREE_PATH_RESTORE_MAX_REQUESTS_AFTER_FILTRATION,
    TREE_PATH_RESTORE_MAX_REQUESTS_BEFORE_FILTRATION,
    TREE_SHOW_MORE_AUTO_FETCH_ENABLED,
    TREE_SHOW_MORE_AUTO_FETCH_MAX_REQUESTS,
    TREE_SEARCH_MODES
} from '@constants/tree'
import { Lookup } from '@utils/Lookup'
import { getWidgetPaginationType } from '@features/pagination/utils/common'
import { getTreePaginationControlsState } from '@components/widgets/Table/tree/utils/getTreePaginationControlsState'
import { AnyAction } from 'redux'
import { cancelRequestActionTypes, cancelRequestEpic } from '@utils/cancelRequestEpic'

interface PageResponse {
    data: DataItem[]
    hasNext?: boolean
}

interface FetchPagesUntilDataChangesOptions {
    fetchPage: (page: number) => Observable<PageResponse>
    initialPage: number
    knownIds: Set<string>
    paginationType: PaginationMode
    limit: number
    defaultLimit: number
    total?: number
    enabled: boolean
    requestLimit?: number
}

const fetchPagesUntilDataChanges = ({
    fetchPage,
    initialPage,
    knownIds,
    paginationType,
    limit,
    defaultLimit,
    total,
    enabled,
    requestLimit: requestedLimit
}: FetchPagesUntilDataChangesOptions) => {
    const requestLimit = enabled ? Math.max(1, requestedLimit ?? TREE_SHOW_MORE_AUTO_FETCH_MAX_REQUESTS) : 1

    const requestPage = (page: number, accumulatedData: DataItem[] = [], requestCount = 1) =>
        fetchPage(page).pipe(
            map(response => ({
                ...response,
                accumulatedData: [...accumulatedData, ...response.data],
                page,
                requestCount,
                dataChanged: response.data.some(item => !knownIds.has(String(item[FIELDS.TECHNICAL.ID])))
            }))
        )

    return requestPage(initialPage).pipe(
        expand(pageState => {
            const paginationState = getTreePaginationControlsState({
                type: paginationType,
                page: pageState.page,
                limit,
                defaultLimit,
                loadedCount: pageState.data.length,
                hasNext: pageState.hasNext,
                total
            })
            const canFetchNextPage = paginationState.visible && !paginationState.nextDisabled

            if (pageState.dataChanged || !canFetchNextPage || pageState.requestCount >= requestLimit) {
                return EMPTY
            }

            return requestPage(pageState.page + 1, pageState.accumulatedData, pageState.requestCount + 1)
        }),
        last()
    )
}

const getPaginationType = (state: RootState, widget?: AppWidgetMeta) =>
    widget ? state.screen.alternativePagination[widget.name] ?? getWidgetPaginationType(widget) : MAIN_DEFAULT_PAGINATION_TYPE

const getAssocTreeSelectedNodeIds = (state: RootState, sourceAction: AnyAction, widget?: AppWidgetMeta): string[] => {
    if (!actions.showViewPopup.match(sourceAction) || widget?.type !== CustomWidgetTypes.AssocTreePopup) {
        return []
    }

    const { calleeBCName, associateFieldKey } = sourceAction.payload
    if (!calleeBCName || !associateFieldKey) {
        return []
    }

    const calleeBc = state.screen.bo.bc[calleeBCName]
    const cursor = calleeBc?.cursor as string | undefined
    const pendingData = cursor ? state.view.pendingDataChanges?.[calleeBCName]?.[cursor] : undefined
    const calleeData = cursor ? state.data[calleeBc.name]?.find(record => record.id === cursor) : undefined
    const values = pendingData?.[associateFieldKey] !== undefined ? pendingData[associateFieldKey] : calleeData?.[associateFieldKey]

    if (!Array.isArray(values)) {
        return []
    }

    return getUniqueValues(
        values
            .map(value => (value && typeof value === 'object' ? value.id : value))
            .filter(isDefined)
            .map(String)
    )
}

export const initTreeEpic: RootEpic = (action$, state$, { api }) =>
    action$.pipe(
        filter(actions.selectView.match),
        mergeMap(action => {
            const state = state$.value
            const widgets = state.view.widgets as AppWidgetMeta[] | undefined
            const treeWidgets = widgets?.filter(isTreeWidget)

            if (!treeWidgets || treeWidgets.length === 0) {
                return EMPTY
            }

            const treeBcNames = getUniqueValues(treeWidgets.map(w => w.bcName).filter(Boolean))

            const initActions = treeBcNames.flatMap(bcName => {
                const treeWidget = treeWidgets.find(widget => widget.bcName === bcName)
                const treeFieldKeys = getTreeFieldKeys(treeWidget)

                return [
                    treeActions.initTree({
                        bcName,
                        nodeState: pick(state.screen.bo.bc[bcName], ['loading', 'page', 'hasNext']),
                        searchMode: Lookup.has(TREE_SEARCH_MODES, treeWidget?.options?.tree?.searchMode)
                            ? treeWidget?.options?.tree?.searchMode
                            : undefined,
                        ...treeFieldKeys
                    })
                ]
            })

            return from(initActions)
        })
    )

interface TreePathRestoreState {
    data: DataItem[]
    restoredNodeIds: string[]
    nextIds: string[]
    requestCount: number
}

type EpicApi = Parameters<RootEpic>[2]['api']

interface RestoreTreePathsOptions {
    api: EpicApi
    state: RootState
    bcName: string
    initialData?: DataItem[]
    requestedIds?: string[]
    maxRequests: number
}

const normalizeMaxRestoreRequests = (value: number) => (Number.isFinite(value) ? Math.max(0, Math.floor(value)) : 0)

const restoreTreePaths = ({ api, state, bcName, initialData = [], requestedIds = [], maxRequests }: RestoreTreePathsOptions) => {
    const bc = state.screen.bo.bc[bcName]
    const widget = (state.view.widgets as AppWidgetMeta[]).find(item => item.bcName === bcName && isTreeWidget(item))

    if (!bc || !widget) {
        return EMPTY
    }

    const bcUrl = buildBcUrl(bcName, false, state) ?? ''
    const { parentFieldKey } = getTreeFieldKeys(widget)
    const limit = widget.limit || bc.limit || requestedIds.length || initialData.length
    const cachedNodes = state.tree[bcName]?.nodes ?? {}

    const resolveAncestors = (
        accumulatedData: DataItem[],
        restoredNodeIds: string[],
        seedIds: string[],
        requestCount: number
    ): TreePathRestoreState => {
        const dataById = new Map(accumulatedData.map(item => [String(item[FIELDS.TECHNICAL.ID]), item]))
        const restoredIds = new Set(restoredNodeIds)
        const missingIds = new Set<string>()
        const visitedIds = new Set<string>()
        const queue = [...seedIds]

        while (queue.length > 0) {
            const nodeId = queue.shift()!
            if (visitedIds.has(nodeId)) {
                continue
            }
            visitedIds.add(nodeId)

            let node = dataById.get(nodeId)
            if (!node && cachedNodes[nodeId]) {
                node = cachedNodes[nodeId]
                dataById.set(nodeId, node)
                restoredIds.add(nodeId)
            }
            if (!node) {
                missingIds.add(nodeId)
                continue
            }

            const parentId = node[parentFieldKey]
            if (!isDefined(parentId)) {
                continue
            }

            const normalizedParentId = String(parentId)
            if (dataById.has(normalizedParentId) || cachedNodes[normalizedParentId]) {
                queue.push(normalizedParentId)
            } else {
                missingIds.add(normalizedParentId)
            }
        }

        return {
            data: [...dataById.values()],
            restoredNodeIds: [...restoredIds],
            nextIds: [...missingIds],
            requestCount
        }
    }

    const fetchNodesByIds = (ids: string[], restoreState: TreePathRestoreState) =>
        api
            .fetchBcData(state.screen.screenName, bcUrl, {
                _page: DEFAULT_PAGE,
                _limit: Math.max(limit, ids.length),
                [`${FIELDS.TECHNICAL.ID}.${FilterType.equalsOneOf}`]: JSON.stringify(ids)
            })
            .pipe(
                map(response => {
                    const dataById = new Map<string, DataItem>()

                    restoreState.data.forEach(item => dataById.set(String(item[FIELDS.TECHNICAL.ID]), item))
                    response.data.forEach(item => dataById.set(String(item[FIELDS.TECHNICAL.ID]), item))
                    const responseIds = response.data.map(item => String(item[FIELDS.TECHNICAL.ID]))

                    return resolveAncestors(
                        [...dataById.values()],
                        getUniqueValues([...restoreState.restoredNodeIds, ...responseIds]),
                        responseIds,
                        restoreState.requestCount + 1
                    )
                })
            )

    const uniqueRequestedIds = [...new Set(requestedIds.map(String))]
    const initialSeedIds = uniqueRequestedIds.length ? uniqueRequestedIds : initialData.map(item => String(item[FIELDS.TECHNICAL.ID]))
    const initialRestoreState: TreePathRestoreState =
        maxRequests > 0
            ? resolveAncestors(initialData, [], initialSeedIds, 0)
            : { data: initialData, restoredNodeIds: [], nextIds: [], requestCount: 0 }

    return of(initialRestoreState).pipe(
        expand(restoreState => {
            if (restoreState.requestCount >= maxRequests || restoreState.nextIds.length === 0) {
                return EMPTY
            }

            return fetchNodesByIds(restoreState.nextIds, restoreState)
        })
    )
}

/**
 * Responsible for synchronizing tree data with the data slice
 * @param action$
 * @param state$
 * @param api
 */
const syncTreeNodesToBcDataEpic: RootEpic = (action$, state$, { api }) =>
    action$.pipe(
        filter(
            isAnyOf(
                treeActions.fetchChildNodeDataSuccess,
                treeActions.restoreNodePathsSuccess,
                treeActions.clearFilter,
                treeActions.removeNode
            )
        ),
        switchMap(action => {
            const { bcName } = action.payload
            const state = state$.value
            const nodes = state.tree[bcName]?.nodes
            const data = nodes ? Object.values(nodes) : []

            return concat(of(actions.updateBcData({ bcName, data })))
        })
    )

export const fetchTreeChildNodesEpic: RootEpic = (action$, state$, { api, utils: internalUtils }) =>
    action$.pipe(
        filter(treeActions.fetchChildNodeData.match),
        mergeMap(action => {
            const { bcName, parentId } = action.payload
            const state = state$.value
            const treeState = state.tree[bcName]
            const widget = (state.view.widgets as AppWidgetMeta[]).find(item => item.bcName === bcName && isTreeWidget(item))
            const { parentFieldKey } = getTreeFieldKeys(widget)
            const nodeState = treeState?.nodesState[String(parentId)]
            const parentFilter = {
                fieldName: parentFieldKey,
                type: parentId === null ? FilterType.specified : FilterType.equals,
                value: parentId === null ? false : parentId
            }
            const fetchContext = buildBcFetchContext(state, bcName, {
                widgetName: widget?.name,
                page: nodeState?.page ?? DEFAULT_PAGE,
                limit: action.payload.limit,
                filters: [parentFilter]
            })

            if (!fetchContext) {
                return of(treeActions.fetchChildNodeDataFail({ bcName, parentId }))
            }

            const canceler = api.createCanceler()
            const treeFetchFailAction = treeActions.fetchChildNodeDataFail({ bcName, parentId })
            const bcFetchFail = action.payload.bcDataRequestAction
                ? of(actions.bcFetchDataFail({ bcName, bcUrl: fetchContext.bcUrl }))
                : EMPTY
            const cancelFlow = cancelRequestEpic(action$, cancelRequestActionTypes, canceler.cancel, treeFetchFailAction).pipe(
                concatWith(bcFetchFail)
            )
            const cancelByParentBc = cancelRequestEpic(
                action$,
                [actions.bcSelectRecord],
                canceler.cancel,
                treeFetchFailAction,
                filteredAction => {
                    return fetchContext.bc.parentName === filteredAction.payload.bcName
                }
            ).pipe(concatWith(bcFetchFail))

            const currentFilters = selectBcFilters(state, bcName) || []
            const userFilters = currentFilters?.filter(filter => filter.fieldName !== parentFieldKey)
            const hasUserFilters = userFilters.length > 0
            const localSideEffects = {
                applyFilter:
                    hasUserFilters && !treeState?.filterActive && widget?.bcName
                        ? of(treeActions.applyFilter({ bcName: widget.bcName }))
                        : EMPTY
            }

            const normalFlow = fetchPagesUntilDataChanges({
                fetchPage: page =>
                    api.fetchBcData(
                        state.screen.screenName,
                        fetchContext.bcUrl,
                        { ...fetchContext.fetchParams, _page: page },
                        canceler.cancelToken
                    ),
                initialPage: fetchContext.page,
                knownIds: new Set((treeState?.childIdsByParent[String(parentId)] ?? []).map(String)),
                paginationType: getPaginationType(state, widget),
                limit: fetchContext.limit,
                defaultLimit: fetchContext.bc.defaultLimit ?? fetchContext.limit,
                total: nodeState?.count,
                enabled: TREE_SHOW_MORE_AUTO_FETCH_ENABLED && action.payload.fetchUntilDataChanges === true,
                requestLimit: action.payload.maxRequests
            }).pipe(
                mergeMap(pageSequence => {
                    const setTreeData = of(
                        treeActions.fetchChildNodeDataSuccess({
                            bcName,
                            parentId,
                            data: pageSequence.accumulatedData,
                            hasNext: pageSequence.hasNext,
                            page: pageSequence.page,
                            lastResponseCount: pageSequence.data.length
                        })
                    )
                    const sourceAction = action.payload.bcDataRequestAction

                    if (!sourceAction) {
                        return setTreeData
                    }

                    const selectedNodeIds = getAssocTreeSelectedNodeIds(state, sourceAction, widget)
                    const maxRequests =
                        normalizeMaxRestoreRequests(
                            widget?.options?.tree?.treePathRestoreMaxRequestsBeforeFiltration ??
                                TREE_PATH_RESTORE_MAX_REQUESTS_BEFORE_FILTRATION
                        ) + 1

                    const restoreAssocTreeSelection = selectedNodeIds.length
                        ? restoreTreePaths({
                              api,
                              state,
                              bcName,
                              initialData: pageSequence.accumulatedData,
                              requestedIds: selectedNodeIds,
                              maxRequests
                          }).pipe(
                              last(),
                              map(restoreState =>
                                  treeActions.restoreNodePathsSuccess({
                                      bcName,
                                      data: restoreState.data,
                                      restoredNodeIds: restoreState.restoredNodeIds
                                  })
                              ),
                              catchError(error => {
                                  console.error(error)
                                  return utils.createApiErrorObservable(error)
                              })
                          )
                        : EMPTY

                    const sideEffects = getBcFetchSideEffects({
                        action: sourceAction,
                        state,
                        data: pageSequence.accumulatedData,
                        bcName,
                        widgetName: sourceAction.payload.widgetName ?? '',
                        widget: fetchContext.widget,
                        internalUtils
                    })

                    if (!sideEffects.widgetIsUsed) {
                        return concat(sideEffects.cursorChange, setTreeData, restoreAssocTreeSelection, sideEffects.fetchRowMeta)
                    }

                    return concat(
                        sideEffects.cursorChange,
                        sideEffects.resetOutdatedData,
                        setTreeData,
                        restoreAssocTreeSelection,
                        sideEffects.fetchRowMeta,
                        sideEffects.fetchChildren,
                        localSideEffects.applyFilter
                    )
                }),
                catchError(error => {
                    console.error(error)
                    return concat(of(treeFetchFailAction), bcFetchFail, utils.createApiErrorObservable(error))
                })
            )

            return race(cancelFlow, cancelByParentBc, normalFlow)
        })
    )

export const applyTreeFilterEpic: RootEpic = (action$, state$, { api }) =>
    action$.pipe(
        filter(treeActions.applyFilter.match),
        switchMap(action => {
            const { bcName } = action.payload
            const state = state$.value

            const currentFilters = selectBcFilters(state, bcName) || []
            const widget = (state.view.widgets as AppWidgetMeta[]).find(item => item.bcName === bcName && isTreeWidget(item))
            const { parentFieldKey } = getTreeFieldKeys(widget)
            const userFilters = currentFilters?.filter(filter => filter.fieldName !== parentFieldKey)
            const hasUserFilters = userFilters.length > 0

            if (!hasUserFilters) {
                return of(treeActions.clearFilter({ bcName }))
            }

            const filterPage = state.tree[bcName]?.filterPagination.page ?? DEFAULT_PAGE
            const fetchContext = buildBcFetchContext(state, bcName, {
                widgetName: widget?.name,
                page: filterPage,
                filters: userFilters
            })

            if (!fetchContext) {
                return of(treeActions.applyFilterFail({ bcName, more: action.payload.more }))
            }

            return fetchPagesUntilDataChanges({
                fetchPage: page =>
                    api.fetchBcData(state.screen.screenName, fetchContext.bcUrl, { ...fetchContext.fetchParams, _page: page }),
                initialPage: fetchContext.page,
                knownIds: new Set(action.payload.knownNodeIds ?? []),
                paginationType: getPaginationType(state, widget),
                limit: fetchContext.limit,
                defaultLimit: fetchContext.bc.defaultLimit ?? fetchContext.limit,
                total: state.tree[bcName]?.filterPagination.count,
                enabled: TREE_SHOW_MORE_AUTO_FETCH_ENABLED && action.payload.fetchUntilDataChanges === true,
                requestLimit: action.payload.maxRequests
            }).pipe(
                switchMap(pageSequence => {
                    const maxRequests = normalizeMaxRestoreRequests(
                        widget?.options?.tree?.treePathRestoreMaxRequestsBeforeFiltration ??
                            TREE_PATH_RESTORE_MAX_REQUESTS_BEFORE_FILTRATION
                    )

                    return restoreTreePaths({ api, state, bcName, initialData: pageSequence.accumulatedData, maxRequests }).pipe(
                        last(),
                        map(restoreState =>
                            treeActions.applyFilterSuccess({
                                bcName,
                                data: restoreState.data,
                                filterResultNodeIds: pageSequence.accumulatedData.map(item => String(item[FIELDS.TECHNICAL.ID])),
                                matchedNodeIds: pageSequence.accumulatedData
                                    .filter(item => isDataItemMatchedByFilters(item, userFilters, widget?.fields as WidgetFieldBase[]))
                                    .map(item => String(item[FIELDS.TECHNICAL.ID])),
                                restoredNodeIds: restoreState.restoredNodeIds,
                                hasNext: pageSequence.hasNext,
                                more: action.payload.more,
                                page: pageSequence.page,
                                lastResponseCount: pageSequence.data.length
                            })
                        )
                    )
                }),
                catchError(error => {
                    console.error(error)
                    return concat(
                        of(treeActions.applyFilterFail({ bcName, more: action.payload.more })),
                        utils.createApiErrorObservable(error)
                    )
                })
            )
        })
    )

export const applyTreeSortEpic: RootEpic = action$ =>
    action$.pipe(
        filter(treeActions.applySorter.match),
        mergeMap(action => {
            const { bcName } = action.payload

            return concat(
                of(treeActions.initTree({ bcName, reset: true })),
                of(treeActions.fetchChildNodeData({ bcName, parentId: null, page: DEFAULT_PAGE }))
            )
        })
    )

const restoreNodePathsEpic: RootEpic = (action$, state$, { api }) =>
    action$.pipe(
        filter(isAnyOf(treeActions.restoreNodePaths)),
        mergeMap(action => {
            const state = state$.value
            const { bcName } = action.payload
            const requestedIds = [...new Set(action.payload.ids.map(String))]
            const widget = (state.view.widgets as AppWidgetMeta[]).find(item => item.bcName === bcName && isTreeWidget(item))

            if (!requestedIds.length) {
                return EMPTY
            }

            return restoreTreePaths({
                api,
                state,
                bcName,
                initialData: [],
                requestedIds: requestedIds,
                maxRequests: normalizeMaxRestoreRequests(
                    widget?.options?.tree?.treePathRestoreMaxRequestsAfterFiltration ?? TREE_PATH_RESTORE_MAX_REQUESTS_AFTER_FILTRATION
                )
            }).pipe(
                last(),
                map(restoreState =>
                    treeActions.restoreNodePathsSuccess({
                        bcName,
                        data: restoreState.data,
                        restoredNodeIds: restoreState.restoredNodeIds
                    })
                ),
                catchError(error => {
                    console.error(error)
                    return utils.createApiErrorObservable(error)
                })
            )
        })
    )

export const treeEpics = {
    initTreeEpic,
    syncTreeNodesToBcDataEpic,
    fetchTreeChildNodesEpic,
    restoreNodePathsEpic,
    applyTreeFilterEpic,
    applyTreeSortEpic
}
