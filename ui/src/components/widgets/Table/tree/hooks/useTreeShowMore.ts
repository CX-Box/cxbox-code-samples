import { useCallback } from 'react'
import { PaginationMode } from '@constants/pagination'
import { getPaginationControlsState } from '@features/pagination/utils/paginationControls'
import { BcTreeState } from '@slices/tree'

export const useTreeShowMore = (paginationType: PaginationMode, limit: number, defaultLimit: number, total?: number) => {
    return useCallback(
        (parentId: string, nodeStates: BcTreeState['nodesState'], loadedChildCount: number) => {
            const parentNodeState = nodeStates[parentId]
            if (!parentNodeState) {
                return { visible: false, disabled: false }
            }

            if (parentNodeState.page === 0) {
                return { visible: true, disabled: false }
            }

            const state = getPaginationControlsState({
                type: paginationType,
                page: parentNodeState.page ?? 1,
                limit,
                defaultLimit,
                loadedCount: loadedChildCount,
                hasNext: parentNodeState.hasNext,
                total
            })

            return { visible: state.visible && !state.nextDisabled, disabled: state.nextDisabled }
        },
        [paginationType, limit, defaultLimit, total]
    )
}
