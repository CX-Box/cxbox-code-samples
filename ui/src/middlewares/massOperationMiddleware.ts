import { AnyAction, Dispatch, MiddlewareAPI } from 'redux'
import { RootState } from '@store'
import { actions, resetRecordForm } from '@actions'
import { Middleware } from '@reduxjs/toolkit'
import { OperationTypeCrud, PendingDataItem } from '@cxbox-ui/core'
import { selectors } from '@selectors'
import { showUnsavedNotification } from './utils'
import { openNotification } from '@components/NotificationsContainer/utils'
import i18n from 'i18next'

const { selectBcRecordPendingDataChanges, selectBcRecordForm, selectBc } = selectors

export const massOperationMiddleware: Middleware =
    ({ getState, dispatch }: MiddlewareAPI<Dispatch<AnyAction>, RootState>) =>
    (next: Dispatch) =>
    (action: AnyAction) => {
        const EMPTY_ACTION = actions.emptyAction()
        const state = getState()

        const bcRecordForm = selectBcRecordForm(state, action.payload?.bcName)
        const previousCursor = selectBc(state, action.payload?.bcName)?.cursor

        const previousPendingDataChanges = selectBcRecordPendingDataChanges(state, action.payload?.bcName, previousCursor)
        const previousRecordHasPendingDataChanges = hasPendingDataChanges(previousPendingDataChanges)
        const actionIsRelatedToRecordForm = action.payload?.bcName === bcRecordForm?.bcName
        const isInclusionOfMassMode = actions.setViewerMode.match(action) && action.payload.mode === 'mass'

        const saveCallback = () => {
            dispatch(
                actions.sendOperation({
                    bcName: action.payload?.bcName,
                    operationType: OperationTypeCrud.save,
                    widgetName: bcRecordForm?.widgetName ?? '',
                    onSuccessAction: action
                })
            )
        }

        const cancelPendingChanges = (bcName: string | undefined) => {
            if (bcName) {
                dispatch(actions.bcCancelPendingChanges({ bcNames: [bcName] }))
                dispatch(actions.clearValidationFails(null))
            }
        }

        const cancelCreate = () => {
            return next(
                actions.sendOperation({
                    bcName: action.payload?.bcName,
                    operationType: OperationTypeCrud.cancelCreate,
                    widgetName: bcRecordForm?.widgetName ?? ''
                })
            )
        }

        if (isInclusionOfMassMode && actionIsRelatedToRecordForm) {
            const cancelCallback = () => {
                if (bcRecordForm?.create) {
                    cancelCreate()
                } else {
                    cancelPendingChanges(action.payload?.bcName)
                    next(resetRecordForm({ bcName: action.payload?.bcName }))
                    next(action)
                }
            }

            if (previousRecordHasPendingDataChanges) {
                showUnsavedNotification(saveCallback, cancelCallback)
            } else {
                cancelCallback()
            }

            return next(EMPTY_ACTION)
        }

        const viewerMode = state.screen.viewerMode[action.payload?.bcName]
        const actionIsRelatedToMassMode = viewerMode?.mode === 'mass'
        const isSelectRecord = actions.bcSelectRecord.match(action)

        if (isSelectRecord && actionIsRelatedToMassMode && viewerMode?.step !== 'Select rows') {
            openNotification({
                type: 'info',
                message: i18n.t('Changing the active record is not available until the bulk operation is finished')
            })
            return next(actions.emptyAction())
        }

        return next(action)
    }

function hasPendingDataChanges(pendingDataChanges: PendingDataItem | undefined) {
    return pendingDataChanges ? !!Object.keys(pendingDataChanges).length : false
}
