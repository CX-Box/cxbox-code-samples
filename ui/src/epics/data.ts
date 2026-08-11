import { RootEpic, RootState } from '@store'
import { catchError, concat, EMPTY, expand, filter, last, map, mergeMap, Observable, of, switchMap } from 'rxjs'
import { DataItem, OperationError, OperationErrorEntity, OperationTypeCrud, utils, WidgetFieldBase } from '@cxbox-ui/core'
import { actions } from '@actions'
import { AxiosError } from 'axios'
import { AnyAction, isAnyOf } from '@reduxjs/toolkit'
import { buildBcUrl } from '@utils/buildBcUrl'
import { selectBcFilters, selectBcNameFromPopupData, selectBcUrlRowMeta } from '@selectors/selectors'
import { treeActions } from '@slices/tree'
import { FilterType } from '@interfaces/filters'
import { FIELDS } from '@constants'
import { isDefined } from '@utils/isDefined'
import { bcFetchDataEpic, buildBcFetchContext, getBcFetchSideEffects } from './data/bcFetchDataEpic'
import { DEFAULT_PAGE } from '@constants/pagination'
import { TREE_PATH_RESTORE_MAX_REQUESTS } from '@components/widgets/Table/constants'
import { isDataItemMatchedByFilters } from '@utils/filterMatch'
import { getTreeFieldKeys } from '@utils/tree'
import { isTreeWidget } from '@constants/widget'
import { AppWidgetMeta } from '@interfaces/widget'

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

// TODO update this epic in the kernel to the current implementation
/**
 * Post record's pending changes to `save dataEpics.ts` API endpoint.
 * Pending changes for fields disabled through row meta are not send; please notice that fields are
 * disabled by default.
 *
 * On success following actions are dispatched:
 * - {@link bcSaveDataSuccess}
 * - {@link bcFetchRowMeta}
 * - one {@link bcFetchDataRequest} for each child of saved business component
 * - optional {@link ActionPayloadTypes.processPostInvokeEpic | processPostInvokeEpic } if present in response
 * - optional `onSuccessAction` callback if provided in payload.
 *
 * On failure, console\.error called and {@link ActionPayloadTypes.bcSaveDataFail | bcSaveDataFail} action
 * dispatched.
 *
 * If there was a `onSuccessAction` callback provided in action payload (and widget option
 * {@link WidgetOptions.disableNotification} was not set)
 * then a notification will be shown on failure with suggestion to cancel pending changes and a button that fires
 * {@link bcCancelPendingChanges}
 *
 * @category Epics
 */
export const bcSaveDataEpic: RootEpic = (action$, state$, { api, utils: internalUtils }) =>
    action$.pipe(
        filter(actions.sendOperation.match),
        filter(action => utils.matchOperationRole(OperationTypeCrud.save, action.payload, state$.value as any)), // TODO remove as any
        mergeMap(action => {
            /**
             * Default implementation for `bcSaveData` epic
             *
             * Post record's pending changes to `save dataEpics.ts` API endpoint.
             * Pending changes for fields disabled through row meta are not send; pleace notice that fields are
             * disabled by default.
             *
             * On success following actions are dispatched:
             * - {@link ActionPayloadTypes.bcSaveDataSuccess | bcSaveDataSuccess}
             * - {@link ActionPayloadTypes.bcFetchRowMeta | bcFetchRowMeta}
             * - one {@link ActionPayloadTypes.bcFetchDataRequest | bcFetchDataRequest } for each children of saved
             * business component
             * - optional {@link ActionPayloadTypes.processPostInvokeEpic | processPostInvokeEpic } if present in response
             * - optional `onSuccessAction` callback if provided in payload.
             *
             * On failure, console\.error called and {@link ActionPayloadTypes.bcSaveDataFail | bcSaveDataFail} action
             * dispatched.
             *
             * If there was a `onSuccessAction` callback provided in action payload (and widget option
             * {@link WidgetOptions.disableNotification | disableNotification } was not set)
             * then a notification will be shown on failure with suggestion to cancel pending changes and a button that fires
             * {@link ActionPayloadTypes.bcCancelPendingChanges | bcCancelPendingChanges}
             */
            const state = state$.value
            const bcName = action.payload.bcName
            const bcUrl = buildBcUrl(bcName, true, state) ?? ''
            const widgetName = action.payload.widgetName
            const cursor = state.screen.bo.bc[bcName].cursor as string
            const dataItem = state.data[bcName]?.find(item => item.id === cursor)
            const rowMeta = selectBcUrlRowMeta(state, bcName)
            const options = state.view.widgets.find(widget => widget.name === widgetName)?.options

            const pendingChanges = utils.removeDisabledFields(state.view.pendingDataChanges[bcName]?.[cursor], rowMeta)

            const lazyWidgetNames = utils.getWidgetsForLazyLoad(
                state$.value.view.widgets,
                internalUtils?.getInternalWidgets,
                selectBcNameFromPopupData(state)
            )
            const fetchChildrenBcData = Object.entries(
                utils.getEagerBcChildren(bcName, state.view.widgets, state.screen.bo.bc, lazyWidgetNames)
            )
                .filter(entry => {
                    const [childBcName] = entry
                    // Solves the problem of calling data for rows that can be changed/deleted in the next action
                    const bcForNextAction = action.payload.onSuccessAction?.payload?.bcName

                    return bcForNextAction ? bcForNextAction !== childBcName : true
                })
                .map(entry => {
                    const [childBcName, widgetNames] = entry
                    return actions.bcFetchDataRequest({ bcName: childBcName, widgetName: widgetNames[0] })
                })

            const context = { widgetName: action.payload.widgetName }
            return api.saveBcData(state.screen.screenName, bcUrl, { ...pendingChanges, vstamp: dataItem?.vstamp as number }, context).pipe(
                mergeMap(data => {
                    const postInvoke = data.postActions?.[0]
                    const responseDataItem = data.record
                    return concat(
                        of(actions.setOperationFinished({ bcName, operationType: OperationTypeCrud.save })),
                        of(actions.bcSaveDataSuccess({ bcName, cursor, dataItem: responseDataItem })),
                        of(actions.bcFetchRowMeta({ widgetName, bcName })),
                        of(actions.deselectTableRow()),
                        of(...fetchChildrenBcData),
                        postInvoke
                            ? of(
                                  actions.processPostInvoke({
                                      bcName,
                                      widgetName,
                                      postInvoke,
                                      cursor: responseDataItem.id
                                  })
                              )
                            : EMPTY,
                        action.payload.onSuccessAction ? of(action.payload.onSuccessAction) : EMPTY
                    )
                }),
                catchError((e: AxiosError) => {
                    console.error(e)
                    let notification$: Observable<AnyAction> = EMPTY
                    // Protection against widget blocking while autosaving
                    if (action.payload.onSuccessAction && !options?.disableNotification) {
                        notification$ = of(
                            actions.addNotification({
                                key: 'data_autosave_undo',
                                type: 'buttonWarningNotification',
                                message: 'There are pending changes. Please save them or cancel.',
                                duration: 0,
                                options: {
                                    buttonWarningNotificationOptions: {
                                        buttonText: 'Cancel changes',
                                        actionsForClick: [actions.bcCancelPendingChanges({ bcNames: [bcName] })]
                                    }
                                }
                            })
                        )
                    }
                    let viewError: string = null as any
                    let entityError: OperationErrorEntity = null as any
                    const operationError = e.response?.data as OperationError
                    if (e.response?.data === Object(e.response?.data)) {
                        entityError = operationError?.error?.entity ?? entityError
                        viewError = operationError?.error?.popup?.[0] ?? viewError
                    }

                    return concat(
                        of(actions.setOperationFinished({ bcName, operationType: OperationTypeCrud.save })),
                        of(actions.bcSaveDataFail({ bcName, bcUrl, viewError, entityError })),
                        notification$,
                        utils.createApiErrorObservable(e, context)
                    )
                })
            )
        })
    )

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

export const dataEpics = {
    bcSaveDataEpic,
    syncTreeNodesToBcDataEpic,
    fetchTreeChildNodesEpic,
    restoreNodePathsEpic,
    applyTreeFilterEpic,
    applyTreeSortEpic,
    bcFetchDataEpic // customized core epic
}
