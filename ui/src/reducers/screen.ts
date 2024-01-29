import { AnyAction, actionTypes } from '../interfaces/actions'
import { AppState, ScreenState } from '../interfaces/storeSlices'
import { FilterGroup } from '../interfaces/filters'

/**
 * Your initial state for this slice
 */
export const initialState: ScreenState = {
    menuCollapsed: false,
    screenName: '',
    bo: {
        activeBcName: '',
        bc: {}
    },
    views: [],
    primaryView: '',
    cachedBc: {},
    filters: {},
    sorters: {}
}

export default function screenReducer(state: ScreenState = initialState, action: AnyAction, store?: Readonly<AppState>): ScreenState {
    switch (action.type) {
        case actionTypes.sendOperationSuccess:
        case actionTypes.bcSaveDataSuccess: {
            if (action.payload.dataItem == null) {
                return state
            }

            const newCursor = action.payload.dataItem.id

            return {
                ...state,
                bo: {
                    ...state.bo,
                    bc: {
                        ...state.bo.bc,
                        [action.payload.bcName]: {
                            ...state.bo.bc[action.payload.bcName],
                            loading: false,
                            /**
                             * Here we support id change on save action to support platform usage as other microservices data provider. I
                             * In this case new record is usually virtually created with temporary id, then on 'save' record is saved to real microservice and temporary id is replaced with new permanent one
                             */
                            cursor: newCursor
                        }
                    }
                },
                cachedBc: {
                    ...state.cachedBc,
                    [action.payload.bcName]: `${action.payload.bcName}/${newCursor}`
                }
            }
        }
        case actionTypes.changeMenuCollapsed: {
            return {
                ...state,
                menuCollapsed: action.payload
            }
        }
        /**
         * Your reducers for this slice
         */

        /**
         * An example reducer for custom action
         */
        case actionTypes.customAction: {
            return state
        }
        case actionTypes.removeFilterGroup: {
            const removedFilterGroup = action.payload

            const newFilterGroups = state.bo.bc[removedFilterGroup.bc as string].filterGroups?.filter(
                filterGroup => filterGroup.name !== removedFilterGroup.name
            )

            return {
                ...state,
                bo: {
                    ...state.bo,
                    bc: {
                        ...state.bo.bc,
                        [removedFilterGroup.bc]: { ...state.bo.bc[removedFilterGroup.bc], filterGroups: newFilterGroups }
                    }
                }
            }
        }

        case actionTypes.addFilterGroup: {
            const newFilterGroup = { ...action.payload, personal: true }
            const newFilterGroups = state.bo.bc[newFilterGroup.bc as string].filterGroups?.slice()
            newFilterGroups?.push(newFilterGroup)
            return {
                ...state,
                bo: {
                    ...state.bo,
                    bc: { ...state.bo.bc, [newFilterGroup.bc]: { ...state.bo.bc[newFilterGroup.bc], filterGroups: newFilterGroups } }
                }
            }
        }

        case actionTypes.updateIdForFilterGroup: {
            const newFilterGroup = action.payload
            const newFilterGroups = state.bo.bc[newFilterGroup.bc as string].filterGroups?.reduce((newFilterGroups, oldFilterGroup) => {
                if (oldFilterGroup.name === newFilterGroup.name) {
                    newFilterGroups.push({ ...oldFilterGroup, id: newFilterGroup.id })
                } else {
                    newFilterGroups.push(oldFilterGroup)
                }

                return newFilterGroups
            }, [] as FilterGroup[])

            return {
                ...state,
                bo: {
                    ...state.bo,
                    bc: { ...state.bo.bc, [newFilterGroup.bc]: { ...state.bo.bc[newFilterGroup.bc], filterGroups: newFilterGroups } }
                }
            }
        }
        default:
            return state
    }
}
