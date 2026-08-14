import { RootEpic, RootState } from '@store'
import { catchError, concat, EMPTY, expand, filter, from, last, map, mergeMap, of, switchMap } from 'rxjs'
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
import { DEFAULT_PAGE } from '@constants/pagination'
import { TREE_PATH_RESTORE_MAX_REQUESTS } from '@components/widgets/Table/constants'
import { isDataItemMatchedByFilters } from '@utils/filterMatch'
import { getTreeFieldKeys } from '@utils/tree'
import { isTreeWidget } from '@constants/widget'
import { AppWidgetMeta } from '@interfaces/widget'
import { DEFAULT_SEARCH_MODE } from '@constants/tree'

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
                        searchMode: treeWidget?.options?.tree?.searchMode ?? DEFAULT_SEARCH_MODE,
                        ...treeFieldKeys
                    })
                ]
            })

            return from(initActions)
        })
    )

interface TreePathRestoreState {
    data: DataItem[]
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
}

const restoreTreePaths = ({ api, state, bcName, initialData = [], requestedIds = [] }: RestoreTreePathsOptions) => {
    const bc = state.screen.bo.bc[bcName]
    const widget = (state.view.widgets as AppWidgetMeta[]).find(item => item.bcName === bcName && isTreeWidget(item))

    if (!bc || !widget) {
        return EMPTY
    }

    const bcUrl = buildBcUrl(bcName, false, state) ?? ''
    const { parentFieldKey } = getTreeFieldKeys(widget)
    const limit = widget.limit || bc.limit || requestedIds.length || initialData.length
    const initiallyLoadedIds = new Set(Object.keys(state.tree[bcName]?.nodes ?? {}))

    const getMissingParentIds = (data: DataItem[], accumulatedData: DataItem[]) => {
        const accumulatedIds = new Set(accumulatedData.map(item => String(item[FIELDS.TECHNICAL.ID])))

        return [
            ...new Set(
                data
                    .map(item => item[parentFieldKey])
                    .filter(isDefined)
                    .map(String)
                    .filter(parentId => !initiallyLoadedIds.has(parentId) && !accumulatedIds.has(parentId))
            )
        ]
    }

    const fetchNodesByIds = (ids: string[], accumulatedData: DataItem[], requestCount: number) =>
        api
            .fetchBcData(state.screen.screenName, bcUrl, {
                _page: DEFAULT_PAGE,
                _limit: Math.max(limit, ids.length),
                [`${FIELDS.TECHNICAL.ID}.${FilterType.equalsOneOf}`]: JSON.stringify(ids)
            })
            .pipe(
                map(response => {
                    const dataById = new Map<string, DataItem>()

                    accumulatedData.forEach(item => dataById.set(String(item[FIELDS.TECHNICAL.ID]), item))
                    response.data.forEach(item => dataById.set(String(item[FIELDS.TECHNICAL.ID]), item))

                    const data = [...dataById.values()]

                    return {
                        data,
                        nextIds: getMissingParentIds(response.data, data),
                        requestCount
                    } satisfies TreePathRestoreState
                })
            )

    const uniqueRequestedIds = [...new Set(requestedIds.map(String))]
    const initialRestoreState: TreePathRestoreState = {
        data: initialData,
        nextIds: uniqueRequestedIds.length ? uniqueRequestedIds : getMissingParentIds(initialData, initialData),
        requestCount: 0
    }

    return of(initialRestoreState).pipe(
        expand(restoreState => {
            if (restoreState.requestCount >= TREE_PATH_RESTORE_MAX_REQUESTS || restoreState.nextIds.length === 0) {
                return EMPTY
            }

            return fetchNodesByIds(restoreState.nextIds, restoreState.data, restoreState.requestCount + 1)
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
        filter(isAnyOf(treeActions.fetchChildNodeDataSuccess, treeActions.fetchNodeDataSuccess)),
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
            const filtered = treeState?.filterActive && treeState.searchMode === 'hide'
            const nodeState = (filtered ? treeState?.filteredNodesState : treeState?.nodesState)?.[String(parentId)]
            const userFilters = (selectBcFilters(state, bcName) || []).filter(filter => filter.fieldName !== parentFieldKey)
            const parentFilter = {
                fieldName: parentFieldKey,
                type: parentId === null ? FilterType.specified : FilterType.equals,
                value: parentId === null ? false : parentId
            }
            const fetchContext = buildBcFetchContext(state, bcName, {
                widgetName: widget?.name,
                page: nodeState?.page ?? DEFAULT_PAGE,
                limit: action.payload.limit,
                filters: [...(filtered ? userFilters : []), parentFilter]
            })

            if (!fetchContext) {
                return of(treeActions.fetchChildNodeDataFail({ bcName, parentId, filtered }))
            }

            return api.fetchBcData(state.screen.screenName, fetchContext.bcUrl, fetchContext.fetchParams).pipe(
                mergeMap(response => {
                    const matchedNodeIds = filtered
                        ? response.data
                              .filter(item => isDataItemMatchedByFilters(item, userFilters, widget?.fields as WidgetFieldBase[]))
                              .map(item => String(item[FIELDS.TECHNICAL.ID]))
                        : undefined
                    const setTreeData = of(
                        treeActions.fetchChildNodeDataSuccess({
                            bcName,
                            parentId,
                            data: response.data,
                            hasNext: response.hasNext,
                            filtered,
                            matchedNodeIds
                        })
                    )
                    const sourceAction = action.payload.bcDataRequestAction

                    if (!sourceAction) {
                        return setTreeData
                    }

                    const sideEffects = getBcFetchSideEffects({
                        action: sourceAction,
                        state,
                        data: response.data,
                        bcName,
                        widgetName: sourceAction.payload.widgetName ?? '',
                        widget: fetchContext.widget,
                        internalUtils
                    })

                    if (!sideEffects.widgetIsUsed) {
                        return concat(sideEffects.cursorChange, setTreeData, sideEffects.fetchRowMeta)
                    }

                    return concat(
                        sideEffects.cursorChange,
                        sideEffects.resetOutdatedData,
                        setTreeData,
                        sideEffects.fetchRowMeta,
                        sideEffects.fetchChildren
                    )
                }),
                catchError(error => {
                    console.error(error)
                    return concat(
                        of(treeActions.fetchChildNodeDataFail({ bcName, parentId, filtered })),
                        utils.createApiErrorObservable(error)
                    )
                })
            )
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

            const fetchContext = buildBcFetchContext(state, bcName, {
                widgetName: widget?.name,
                page: DEFAULT_PAGE,
                filters: userFilters
            })

            if (!fetchContext) {
                return EMPTY
            }

            return api.fetchBcData(state.screen.screenName, fetchContext.bcUrl, fetchContext.fetchParams).pipe(
                switchMap(response => {
                    return restoreTreePaths({ api, state, bcName, initialData: response.data }).pipe(
                        last(),
                        map(restoreState =>
                            treeActions.applyFilterSuccess({
                                bcName,
                                data: restoreState.data,
                                matchedNodeIds: response.data
                                    .filter(item => isDataItemMatchedByFilters(item, userFilters, widget?.fields as WidgetFieldBase[]))
                                    .map(item => String(item[FIELDS.TECHNICAL.ID]))
                            })
                        )
                    )
                }),
                catchError(error => {
                    console.error(error)
                    return utils.createApiErrorObservable(error)
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
        filter(isAnyOf(treeActions.fetchNodeData, treeActions.restoreNodePaths)),
        mergeMap(action => {
            const state = state$.value
            const { bcName } = action.payload
            const requestedIds = [...new Set(action.payload.ids.map(String))]

            if (!requestedIds.length) {
                return EMPTY
            }

            return restoreTreePaths({
                api,
                state,
                bcName,
                initialData: [],
                requestedIds: requestedIds
            }).pipe(
                last(),
                map(restoreState => treeActions.fetchNodeDataSuccess({ bcName, data: restoreState.data })),
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
