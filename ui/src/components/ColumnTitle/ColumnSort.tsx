import React, { FunctionComponent, useCallback } from 'react'
import { shallowEqual, useDispatch } from 'react-redux'
import { Icon } from 'antd'
import cn from 'classnames'
import styles from './ColumnSort.less'
import { actions, BcSorter } from '@cxbox-ui/core'
import { useAppSelector } from '@store'
import { AppWidgetTableMeta } from '@interfaces/widget'

export interface ColumnSortProps {
    className?: string
    widgetName: string
    fieldKey: string
}

export const ColumnSort: FunctionComponent<ColumnSortProps> = ({ widgetName, fieldKey, className }) => {
    const { hideSort, sorter, toggleSort } = useSorter(widgetName, fieldKey)

    if (hideSort) {
        return null
    }

    const icon = sorter?.direction === 'asc' ? 'caret-up' : 'caret-down'

    return (
        <Icon
            className={cn(styles.icon, className, { [styles.forceShow]: sorter })}
            type={icon}
            data-test-widget-list-header-column-sort={true}
            onClick={toggleSort}
        />
    )
}

export default ColumnSort

export function useSorter(widgetName: string, fieldKey: string) {
    const { bcName, sorters, page, infinitePagination, permanentSorterFields, defaultSort } = useAppSelector(state => {
        const widget = state.view.widgets.find(item => item.name === widgetName) as AppWidgetTableMeta | undefined
        const bcName = widget?.bcName as string
        const sorters = state.screen.sorters[bcName] as BcSorter[] | undefined
        const page = state.screen.bo.bc[bcName]?.page
        const infinitePagination = !!state.view.infiniteWidgets?.includes(widgetName)
        const permanentSorterFields = widget?.options?.groupingHierarchy?.fields
        const defaultSort = state.screen.bo.bc[bcName]?.defaultSort
        return { bcName, infinitePagination, sorters, page, permanentSorterFields, defaultSort }
    }, shallowEqual)

    const fieldSorter = sorters?.find(item => item.fieldName === fieldKey)

    const dispatch = useDispatch()

    const setSort = useCallback(
        (newSorter: BcSorter | BcSorter[]) => {
            dispatch(actions.bcAddSorter({ bcName, sorter: newSorter }))

            infinitePagination
                ? dispatch(
                      actions.bcFetchDataPages({
                          bcName,
                          widgetName,
                          from: 1,
                          to: page
                      })
                  )
                : dispatch(
                      actions.bcForceUpdate({
                          bcName,
                          widgetName
                      })
                  )
        },
        [bcName, dispatch, infinitePagination, page, widgetName]
    )

    const toggleSort = useCallback(() => {
        const isPermanent = permanentSorterFields?.includes(fieldKey)
        if (fieldSorter) {
            if (fieldSorter.direction === 'desc') {
                const updatedSorter: BcSorter = {
                    ...fieldSorter,
                    direction: 'asc' as const
                }

                const newSorters = sorters?.map(s => (s.fieldName === fieldKey ? updatedSorter : s))

                setSort(newSorters ?? updatedSorter)
                return
            }

            if (fieldSorter.direction === 'asc') {
                if (!isPermanent) {
                    const newSorters = sorters?.filter(s => s.fieldName !== fieldKey)
                    if (newSorters && newSorters.length > 0) {
                        setSort(newSorters)
                        return
                    }
                    if (defaultSort && defaultSort?.indexOf(fieldKey) !== -1) {
                        const direction = () => {
                            if (defaultSort.indexOf('asc') !== -1) {
                                return 'asc'
                            }
                            if (defaultSort.indexOf('desc') === -1) {
                                return 'desc'
                            }
                            return 'desc'
                        }
                        setSort({
                            fieldName: fieldKey,
                            direction: direction()
                        })
                        return
                    }
                    setSort([])
                    return
                }

                const updatedSorter: BcSorter = {
                    ...fieldSorter,
                    direction: 'desc' as const
                }

                const newSorters = sorters?.map(s => (s.fieldName === fieldKey ? updatedSorter : s))

                setSort(newSorters ?? updatedSorter)
                return
            }
        }

        const newSorter: BcSorter = {
            fieldName: fieldKey,
            direction: 'desc' as const
        }

        const newSorters = permanentSorterFields ? [...(sorters ?? []), newSorter] : newSorter

        setSort(newSorters)
    }, [permanentSorterFields, fieldKey, fieldSorter, sorters, setSort, defaultSort])

    return {
        sorter: fieldSorter,
        hideSort: !bcName,
        toggleSort
    }
}
