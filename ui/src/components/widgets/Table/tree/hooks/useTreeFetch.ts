import { useCallback } from 'react'
import { useDispatch } from 'react-redux'
import { treeActions, BcTreeState } from '../../../../../slices/tree'

export const useTreeFetch = (bcName?: string, bcTreeState?: BcTreeState) => {
    const dispatch = useDispatch()

    const fetchChildNodes = useCallback(
        (parentId: string | null = null, more: boolean) => {
            if (!bcTreeState || !bcName) {
                return
            }
            // Do not request data again unless otherwise specified
            if (!more && bcTreeState.nodesState[parentId!]?.page) {
                return
            }

            const filtered = bcTreeState.filterActive && bcTreeState.searchMode === 'hide'
            dispatch(treeActions.fetchChildNodeData({ bcName, parentId, more, filtered }))
        },
        [bcName, bcTreeState, dispatch]
    )

    const createFetchChildNodesHandler = useCallback(
        (parentId: string | null = null, more: boolean) => {
            return () => fetchChildNodes(parentId, more)
        },
        [fetchChildNodes]
    )

    return { fetchChildNodes, createFetchChildNodesHandler }
}
