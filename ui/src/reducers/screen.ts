import { BcMetaState, DataValue, interfaces, reducers } from '@cxbox-ui/core'
import { actions, changeMenuCollapsed, customAction, sendOperationSuccess } from '@actions'
import { createReducer, isAnyOf } from '@reduxjs/toolkit'
import { FilterGroup } from '@interfaces/filters'

export interface ScreenState extends interfaces.ScreenState {
    menuCollapsed: boolean
    bo: {
        activeBcName: string
        bc: Record<
            string,
            BcMetaState & {
                filterGroups?: FilterGroup[]
                localFilterValues?: Record<string, DataValue | DataValue[]>
            }
        >
    }
    pagination: { [bcName: string]: { limit?: number } }
}

const initialState: ScreenState = {
    ...reducers.initialScreenState,
    menuCollapsed: false,
    pagination: {}
}

const screenReducerBuilder = reducers
    .createScreenReducerBuilderManager(initialState)
    .addCase(changeMenuCollapsed, (state, action) => {
        state.menuCollapsed = action.payload
    })
    .addCase(customAction, (state, action) => {
        /**
         * An example reducer for custom action
         */
        console.log(action.payload)
    })
    .addCase(actions.removeFilterGroup, (state, action) => {
        const removedFilterGroup = action.payload

        state.bo.bc[removedFilterGroup.bc] = state.bo.bc[removedFilterGroup.bc] ?? {}

        state.bo.bc[removedFilterGroup.bc].filterGroups = state.bo.bc[removedFilterGroup.bc as string].filterGroups?.filter(
            filterGroup => filterGroup.name !== removedFilterGroup.name
        )
    })
    .addCase(actions.addFilterGroup, (state, action) => {
        const newFilterGroup = { ...action.payload, personal: true }

        state.bo.bc[newFilterGroup.bc]?.filterGroups?.push(newFilterGroup)
    })
    .addCase(actions.updateIdForFilterGroup, (state, { payload: newFilterGroup }) => {
        const newFilterGroupIndex =
            state.bo.bc[newFilterGroup.bc].filterGroups?.findIndex(filterGroup => filterGroup.name === newFilterGroup.name) ?? -1

        if (newFilterGroupIndex !== -1) {
            ;(state.bo.bc[newFilterGroup.bc].filterGroups as FilterGroup[])[newFilterGroupIndex].id = newFilterGroup.id
        }
    })
    .addCase(actions.changePageLimit, (state, action) => {
        const { bcName, limit } = action.payload

        state.pagination[bcName] = state.pagination[bcName] ?? {}
        state.pagination[bcName].limit = limit

        state.bo.bc[bcName] = state.bo.bc[bcName] ?? {}
        state.bo.bc[bcName].limit = limit as number
    })
    .addCase(actions.updateBcData, (state, action) => {
        const { bcName } = action.payload

        state.bo.bc[bcName] = state.bo.bc[bcName] ?? {}
        state.bo.bc[bcName].loading = false
    })
    .addCase(actions.setLocalFilterValue, (state, action) => {
        const { bcName, fieldKey, value } = action.payload

        if (value?.toString()) {
            state.bo.bc[bcName].localFilterValues = { [fieldKey]: value }
        } else {
            delete state.bo.bc[bcName].localFilterValues?.[fieldKey]
        }
    })
    .addMatcher(isAnyOf(actions.selectScreen), (state, action) => {
        // временное решение чтобы сохранялся лимит при сменен экранов
        Object.values(state.bo.bc).forEach(bc => {
            bc.limit = state.pagination[bc.name]?.limit ?? bc.limit
        })
    })
    .addMatcher(isAnyOf(sendOperationSuccess, actions.bcSaveDataSuccess), (state, action) => {
        if (action.payload.dataItem) {
            const newCursor = action.payload.dataItem.id

            state.bo.bc[action.payload.bcName].loading = false
            /**
             * Here we support id change on save action to support platform usage as other microservices data provider. I
             * In this case new record is usually virtually created with temporary id, then on 'save' record is saved to real microservice and temporary id is replaced with new permanent one
             */
            state.bo.bc[action.payload.bcName].cursor = newCursor
            state.cachedBc[action.payload.bcName] = `${action.payload.bcName}/${newCursor}`
        }
    }).builder

export const screenReducer = createReducer(initialState, screenReducerBuilder)
