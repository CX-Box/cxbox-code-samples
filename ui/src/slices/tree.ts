import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { BcMetaState, DataItem } from '@cxbox-ui/core'
import { actions } from '@actions'
import { FIELDS } from '@constants'
import { CustomDataItem } from '@components/widgets/Table/Table.interfaces'
import { isDefined } from '@utils/isDefined'
import { DEFAULT_PAGE } from '@constants/pagination'
import { AnyAction } from 'redux'
import { TreeSearchModes } from '@interfaces/widget'
import { DEFAULT_SEARCH_MODE } from '@constants/tree'
import { DEFAULT_TREE_IS_LEAF_FIELD_KEY, DEFAULT_TREE_PARENT_FIELD_KEY, getTreeNodeIsLeaf } from '@utils/tree'

export interface TreeNode extends CustomDataItem {
    id: string
    name: string
    hasChildren?: boolean
}

export interface BcTreeState {
    nodes: Record<string, TreeNode>
    childIdsByParent: Record<string, string[]>
    nodesState: Record<string, Pick<BcMetaState, 'loading' | 'page' | 'hasNext'> & { lastResponseCount?: number }>
    errors: Record<string, string | null>
    expandedParents: string[]
    searchMode: TreeSearchModes
    filterActive: boolean
    matchedNodeIds: string[]
    filteredNodesState: BcTreeState['nodesState']
    parentFieldKey: string
    isLeafFieldKey: string
    expandedParentsBeforeFilter?: string[]
}

type TreeSate = { [bcName: string]: BcTreeState | undefined }

const initialState: TreeSate = {}

export function createDictionaryFrom<T extends Record<string, any>>(recordKey: string, data: T[]): Record<string, T> {
    return data.reduce((acc: Record<string, any>, dataItem) => {
        if (dataItem[recordKey]) {
            acc[dataItem[recordKey]] = dataItem
        }

        return acc
    }, {})
}

export function dataByCategory<T extends Record<string, any>>(recordKey: string, data: T[]): Record<string, T[]> {
    return data.reduce((acc: Record<string, T[]>, dataItem) => {
        const key = dataItem[recordKey]

        if (key !== undefined) {
            if (!acc[key]) {
                acc[key] = []
            }

            acc[key].push(dataItem)
        }

        return acc
    }, {})
}

export const getUniqueValues = <T>(array: T[]): T[] => {
    return [...new Set(array)]
}

export const pick = <T extends object, K extends keyof T>(obj: T, keys: readonly K[]): Pick<T, K> =>
    keys.reduce((acc, key) => {
        if (key in obj) {
            acc[key] = obj[key]
        }
        return acc
    }, {} as Pick<T, K>)

export const extractIds = <T extends { id: string }>(data: T[] = []): string[] => {
    return data.map(item => item[FIELDS.TECHNICAL.ID] as string)
}

const initBcTreeState = (initialTreeState?: Partial<BcTreeState>): BcTreeState => ({
    nodes: {},
    childIdsByParent: {},
    nodesState: {},
    errors: {},
    expandedParents: [],
    searchMode: DEFAULT_SEARCH_MODE,
    filterActive: false,
    matchedNodeIds: [],
    filteredNodesState: {},
    parentFieldKey: DEFAULT_TREE_PARENT_FIELD_KEY,
    isLeafFieldKey: DEFAULT_TREE_IS_LEAF_FIELD_KEY,
    ...initialTreeState
})

const treeSlice = createSlice({
    name: 'tree',
    initialState,
    reducers: {
        initTree(
            state,
            action: PayloadAction<{
                bcName: string
                nodeState?: BcTreeState['nodesState'][string]
                reset?: boolean
                searchMode?: TreeSearchModes
                parentFieldKey?: string
                isLeafFieldKey?: string
            }>
        ) {
            const { bcName, nodeState, reset, searchMode, parentFieldKey, isLeafFieldKey } = action.payload
            if (!state[bcName] || reset) {
                state[bcName] = initBcTreeState({
                    ...(nodeState ? { nodesState: { null: nodeState } } : undefined),
                    searchMode: searchMode ?? state[bcName]?.searchMode ?? DEFAULT_SEARCH_MODE,
                    parentFieldKey: parentFieldKey ?? state[bcName]?.parentFieldKey ?? DEFAULT_TREE_PARENT_FIELD_KEY,
                    isLeafFieldKey: isLeafFieldKey ?? state[bcName]?.isLeafFieldKey ?? DEFAULT_TREE_IS_LEAF_FIELD_KEY
                })
            }
        },
        fetchChildNodeData(
            state,
            action: PayloadAction<{
                bcName: string
                parentId: string | null
                page?: number
                more?: boolean
                limit?: number
                bcDataRequestAction?: AnyAction
                filtered?: boolean
            }>
        ) {
            const { bcName, page: newPage, more, filtered } = action.payload
            const parentId = action.payload.parentId as string

            if (!state[bcName]) {
                state[bcName] = initBcTreeState()
            }

            const currentTree = state[bcName]!

            const nodesState = filtered ? currentTree.filteredNodesState : currentTree.nodesState

            if (!nodesState[parentId]) {
                nodesState[parentId] = {}
            }

            nodesState[parentId].loading = true

            if (isDefined(newPage)) {
                nodesState[parentId].page = newPage
            }

            const currentPage = nodesState[parentId].page

            if (more) {
                nodesState[parentId].page = isDefined(currentPage) ? currentPage + 1 : DEFAULT_PAGE
            }
        },
        fetchChildNodeDataSuccess(
            state,
            action: PayloadAction<{
                bcName: string
                parentId: string | null | undefined
                data: DataItem[]
                hasNext?: boolean
                filtered?: boolean
                matchedNodeIds?: string[]
            }>
        ) {
            const { bcName, data, hasNext, parentId: requestedParentId, filtered, matchedNodeIds } = action.payload

            if (!state[bcName]) {
                state[bcName] = initBcTreeState()
            }

            const currentTree = state[bcName]!
            const nodesState = filtered ? currentTree.filteredNodesState : currentTree.nodesState

            const mutateBcTreeByParentId = (
                nodeId: string | null,
                options: { data: DataItem[]; loading: boolean; hasNext?: boolean; lastResponseCount?: number }
            ) => {
                const safeNodeId = String(nodeId)

                if (!nodesState[safeNodeId]) {
                    nodesState[safeNodeId] = {}
                }

                if (!currentTree.childIdsByParent[safeNodeId]) {
                    currentTree.childIdsByParent[safeNodeId] = []
                }

                const nodeState = nodesState[safeNodeId]

                nodeState.loading = options.loading

                if (options.hasNext !== undefined) {
                    nodeState.hasNext = options.hasNext
                }

                if (options.lastResponseCount !== undefined) {
                    nodeState.lastResponseCount = options.lastResponseCount
                }

                const existingChildIds = currentTree.childIdsByParent[safeNodeId]
                const newChildIds = extractIds(options.data)

                currentTree.childIdsByParent[safeNodeId] = getUniqueValues([...existingChildIds, ...newChildIds])
            }

            if (requestedParentId !== undefined) {
                currentTree.errors[String(requestedParentId)] = null
                mutateBcTreeByParentId(requestedParentId, {
                    data: [],
                    loading: false,
                    hasNext,
                    lastResponseCount: data.length
                })
            }

            const recordsByParentId = dataByCategory(currentTree.parentFieldKey, data)

            Object.entries(recordsByParentId).forEach(([actualParentId, groupData]) => {
                mutateBcTreeByParentId(actualParentId, {
                    data: groupData,
                    loading: false
                })
            })

            const newNodes = createDictionaryFrom(FIELDS.TECHNICAL.ID, data)
            Object.assign(currentTree.nodes, newNodes)

            if (filtered) {
                currentTree.matchedNodeIds = getUniqueValues([...currentTree.matchedNodeIds, ...(matchedNodeIds ?? [])])
            }
        },
        fetchChildNodeDataFail(
            state,
            action: PayloadAction<{ bcName: string; parentId: string | null; error?: string; filtered?: boolean }>
        ) {
            const { bcName, parentId, error, filtered } = action.payload
            const currentTree = state[bcName]
            const safeParentId = String(parentId)
            const nodesState = filtered ? currentTree?.filteredNodesState : currentTree?.nodesState

            if (nodesState?.[safeParentId]) {
                nodesState[safeParentId].loading = false
            }
            if (currentTree) {
                currentTree.errors[safeParentId] = error ?? null
            }
        },
        applyFilter(state, action: PayloadAction<{ bcName: string }>) {
            const { bcName } = action.payload

            if (!state[bcName]) {
                state[bcName] = initBcTreeState()
            }

            state[bcName]!.filteredNodesState = {}
        },
        applyFilterSuccess(state, action: PayloadAction<{ bcName: string; data: DataItem[]; matchedNodeIds: string[] }>) {
            const { bcName, data, matchedNodeIds } = action.payload
            const currentTree = state[bcName] ?? initBcTreeState()
            state[bcName] = currentTree

            if (!currentTree.filterActive) {
                currentTree.expandedParentsBeforeFilter = [...currentTree.expandedParents]
            }

            currentTree.filterActive = true
            currentTree.matchedNodeIds = getUniqueValues(matchedNodeIds.map(String))

            const recordsByParentId = dataByCategory(currentTree.parentFieldKey, data)
            Object.entries(recordsByParentId).forEach(([parentId, children]) => {
                currentTree.childIdsByParent[parentId] = getUniqueValues([
                    ...(currentTree.childIdsByParent[parentId] ?? []),
                    ...extractIds(children)
                ])
            })
            Object.assign(currentTree.nodes, createDictionaryFrom(FIELDS.TECHNICAL.ID, data))

            const expandedPathIds = new Set<string>()
            currentTree.matchedNodeIds.forEach(id => {
                let node = currentTree.nodes[id]
                const visited = new Set<string>()
                while (isDefined(node?.[currentTree.parentFieldKey])) {
                    const parentId = String(node[currentTree.parentFieldKey])
                    if (visited.has(parentId)) {
                        break
                    }
                    visited.add(parentId)
                    expandedPathIds.add(parentId)
                    node = currentTree.nodes[parentId]
                }
            })

            currentTree.expandedParents =
                currentTree.searchMode === 'highlight'
                    ? getUniqueValues([...currentTree.expandedParents, ...expandedPathIds])
                    : [...expandedPathIds]

            if (currentTree.searchMode === 'collapse' || currentTree.searchMode === 'hide') {
                const paginationState = currentTree.searchMode === 'hide' ? currentTree.filteredNodesState : currentTree.nodesState
                const visibleParentIds = new Set<string>([String(null), ...expandedPathIds])

                currentTree.matchedNodeIds.forEach(id => {
                    if (!getTreeNodeIsLeaf(currentTree.nodes[id], currentTree.isLeafFieldKey)) {
                        visibleParentIds.add(id)
                    }
                })

                visibleParentIds.forEach(parentId => {
                    if (!paginationState[parentId]) {
                        // Page zero means that this branch has not been requested in the current mode yet.
                        // It also keeps the show-more control visible until the first response provides hasNext.
                        paginationState[parentId] = { page: 0, hasNext: true }
                    }
                })
            }
        },
        clearFilter(state, action: PayloadAction<{ bcName: string }>) {
            const currentTree = state[action.payload.bcName]
            if (!currentTree) {
                return
            }
            currentTree.filterActive = false
            currentTree.matchedNodeIds = []
            currentTree.filteredNodesState = {}
            if (currentTree.expandedParentsBeforeFilter) {
                currentTree.expandedParents = currentTree.expandedParentsBeforeFilter
            }
            delete currentTree.expandedParentsBeforeFilter
        },
        applySorter(state, action: PayloadAction<{ bcName: string }>) {
            return
        },
        expandNode(state, action: PayloadAction<{ bcName: string; nodeId: string; value: boolean }>) {
            const { bcName, nodeId, value } = action.payload
            const currentTree = state[bcName]!

            currentTree.expandedParents = value
                ? [...new Set([...currentTree.expandedParents, nodeId])]
                : currentTree.expandedParents.filter(item => item !== nodeId)
        },
        fetchNodeData(state, action: PayloadAction<{ bcName: string; ids: string[] }>) {
            return
        },
        restoreNodePaths(state, action: PayloadAction<{ bcName: string; ids: string[] }>) {
            return
        },
        fetchNodeDataSuccess(state, action: PayloadAction<{ bcName: string; data: DataItem[] }>) {
            const { bcName, data } = action.payload

            if (!state[bcName]) {
                state[bcName] = initBcTreeState()
            }

            const currentTree = state[bcName]!
            const recordsByParentId = dataByCategory(currentTree.parentFieldKey, data)

            Object.entries(recordsByParentId).forEach(([parentId, children]) => {
                if (!currentTree.nodesState[parentId]) {
                    currentTree.nodesState[parentId] = {}
                }
                if (!currentTree.childIdsByParent[parentId]) {
                    currentTree.childIdsByParent[parentId] = []
                }

                const nodeState = currentTree.nodesState[parentId]
                nodeState.loading = false

                const childIds = extractIds(children)
                currentTree.childIdsByParent[parentId] = getUniqueValues([...currentTree.childIdsByParent[parentId], ...childIds])
            })

            Object.assign(currentTree.nodes, createDictionaryFrom(FIELDS.TECHNICAL.ID, data))

            const restoredParentIds = data
                .map(item => item[currentTree.parentFieldKey])
                .filter((parentId): parentId is string => isDefined(parentId))
                .map(String)

            currentTree.expandedParents = getUniqueValues([...currentTree.expandedParents, ...restoredParentIds])
        }
    },
    extraReducers: builder => {
        builder.addCase(actions.selectScreen, (state, action) => {
            return {}
        })
        builder.addCase(actions.selectView, (state, action) => {
            return {}
        })
    }
})

export const treeActions = treeSlice.actions
export const treeReducer = treeSlice.reducer
