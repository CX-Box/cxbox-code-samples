import { useAppSelector } from '@store'
import React from 'react'
import { AppWidgetMeta } from '@interfaces/widget'
import { ROW_KEY } from '@components/widgets/Table/constants'
import { CustomDataItem } from '@components/widgets/Table/Table.interfaces'
import { useTreePagination } from './useTreePagination'
import { useTreeShowMore } from './useTreeShowMore'
import { useTreeFetch } from './useTreeFetch'
import { useTreeDataSource, TableTreeNode } from './useTreeDataSource'
import { selectBcTree } from '@selectors/selectors'
import { useDispatch } from 'react-redux'
import { treeActions } from '@slices/tree'

export type { TableTreeNode }

export const useTableTree = (widgetMeta: AppWidgetMeta | undefined) => {
    const bcName = widgetMeta?.bcName
    const bcTreeState = useAppSelector(state => state.tree[bcName!])

    const { limit, defaultLimit, total, paginationType } = useTreePagination(bcName, widgetMeta)

    const calculateShowMoreState = useTreeShowMore(paginationType, limit, defaultLimit, total)

    const { fetchChildNodes, createFetchChildNodesHandler } = useTreeFetch(bcName, bcTreeState)

    const dataSource = useTreeDataSource(bcTreeState, calculateShowMoreState)

    const expandedRowKeys = useAppSelector(state => selectBcTree(state, bcName)?.expandedParents) ?? []
    const dispatch = useDispatch()

    const handleExpand = React.useCallback(
        (expanded: boolean, record: CustomDataItem) => {
            if (expanded) {
                const activeNodesState =
                    bcTreeState?.filterActive && bcTreeState.searchMode === 'hide'
                        ? bcTreeState.filteredNodesState
                        : bcTreeState?.nodesState
                if (!activeNodesState?.[record.id]) {
                    fetchChildNodes(record.id as string, true)
                }
            }

            dispatch(treeActions.expandNode({ bcName: bcName!, nodeId: String(record[ROW_KEY]), value: expanded }))
        },
        [dispatch, bcName, bcTreeState?.nodesState, fetchChildNodes]
    )

    const restoreAncestorPaths = React.useCallback(
        (ids: string[]) => {
            if (bcName && ids.length > 0) {
                dispatch(treeActions.restoreNodePaths({ bcName, ids }))
            }
        },
        [bcName, dispatch]
    )

    return {
        expandedRowKeys,
        handleExpand,
        dataSource,
        createFetchNodesHandler: createFetchChildNodesHandler,
        restoreAncestorPaths
    }
}
