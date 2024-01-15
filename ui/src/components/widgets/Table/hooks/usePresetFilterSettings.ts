import { useAppSelector } from '../../../../hooks/useAppSelector'
import { getFilters, parseFilters } from '@cxbox-ui/core'
import { useCallback, useMemo } from 'react'
import { $do } from '../../../../actions/types'
import { BcFilter } from '@cxbox-ui/core/interfaces/filters'
import { shallowEqual, useDispatch } from 'react-redux'
import qs from 'query-string'

export function usePresetFilterSettings(bcName: string) {
    const { filterGroups, filters } = useAppSelector(state => {
        const bc = state.screen.bo.bc[bcName]

        return { filterGroups: bc.filterGroups, filters: state.screen.filters[bcName] }
    }, shallowEqual)

    const dispatch = useDispatch()

    const applyFilter = useCallback(
        (bcName: string, filter: BcFilter, widgetName?: string) => {
            dispatch($do.bcAddFilter({ bcName, filter, widgetName }))
        },
        [dispatch]
    )

    const removeFilter = useCallback(
        (bcName: string) => {
            dispatch($do.bcRemoveAllFilters({ bcName }))
        },
        [dispatch]
    )

    const forceUpdate = useCallback(
        (bcName: string) => {
            dispatch($do.bcForceUpdate({ bcName }))
        },
        [dispatch]
    )

    const applyFilterGroup = useMemo(() => {
        return (value: string) => {
            const filterGroup = filterGroups?.find(item => item.name === value)
            const parsedFilters = filterGroup?.filters ? parseFilters(filterGroup?.filters) : []

            removeFilter(bcName)

            parsedFilters.forEach(item => applyFilter(bcName, item))

            forceUpdate(bcName)
        }
    }, [filterGroups, removeFilter, bcName, forceUpdate, applyFilter])

    const cleanAllFilters = useCallback(() => {
        removeFilter(bcName)
        forceUpdate(bcName)
    }, [bcName, forceUpdate, removeFilter])

    const currentFilters = useMemo(() => qs.stringify({ ...getFilters(filters || []) }, { encode: true }), [filters])

    const saveCurrentFiltersAsGroup = useCallback(
        (name: string) => {
            const filterGroup = {
                filters: currentFilters,
                name,
                bc: bcName
            }

            dispatch($do.addFilterGroup(filterGroup))
        },
        [bcName, dispatch, currentFilters]
    )

    const removeFilterGroup = useCallback(
        (name: string, id: string) => {
            dispatch($do.removeFilterGroup({ name, bc: bcName, id }))
        },
        [bcName, dispatch]
    )

    return {
        currentFilters,
        filterGroups,
        filtersExist: !!filters?.length,
        applyFilterGroup,
        cleanAllFilters,
        saveCurrentFiltersAsGroup,
        removeFilterGroup
    }
}
