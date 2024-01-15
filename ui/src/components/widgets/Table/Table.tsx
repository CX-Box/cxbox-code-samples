import React, { useCallback } from 'react'
import { buildBcUrl, TableWidget } from '@cxbox-ui/core'
import { ColumnProps } from 'antd/es/table'
import { DataItem } from '@cxbox-ui/core/interfaces/data'
import Pagination from '../../ui/Pagination/Pagination'
import { TableWidgetOwnProps } from '@cxbox-ui/core/components/widgets/TableWidget/TableWidget'
import ColumnTitle from '../../ColumnTitle/ColumnTitle'
import { useExpandableForm } from './hooks/useExpandableForm'
import styles from './Table.less'
import { useDispatch, useSelector } from 'react-redux'
import { AppState } from '../../../interfaces/storeSlices'
import { Icon, Menu } from 'antd'
import { useTranslation } from 'react-i18next'
import { useVisibility } from './hooks/useVisibility'
import DropdownSetting from './components/DropdownSetting'
import { $do } from '../../../actions/types'
import Operations from '../../Operations/Operations'
import { useExportTable } from './hooks/useExportTable'
import FilterSettingModal from './components/FilterSettingModal'
import { usePresetFilterSettings } from './hooks/usePresetFilterSettings'
import { AppWidgetTableMeta } from '../../../interfaces/widget'

export type ControlColumn = { column: ColumnProps<DataItem>; position: 'left' | 'right' }

interface TableProps extends TableWidgetOwnProps {
    meta: AppWidgetTableMeta
    primaryColumn?: ControlColumn
}

function Table({ meta, primaryColumn, disablePagination, ...rest }: TableProps) {
    const { expandable, expandIcon, expandIconColumn, getExpandIconColumnIndex, expandedRowRender, expandedRowKeys } =
        useExpandableForm(meta)

    const controlColumns = React.useMemo(() => {
        const resultColumns: Array<ControlColumn> = []

        if (meta.options?.primary?.enabled && primaryColumn) {
            resultColumns.push(primaryColumn as any)
        }

        if (expandIconColumn) {
            resultColumns.push({ column: expandIconColumn, position: 'right' })
        }

        return [...resultColumns]
    }, [expandIconColumn, meta.options?.primary?.enabled, primaryColumn])

    const bc = useSelector((state: AppState) => state.screen.bo.bc[meta.bcName])

    const { t } = useTranslation()

    const dispatch = useDispatch()

    const changeCursor = (rowId: string) => {
        if (rowId !== bc.cursor) {
            dispatch($do.bcSelectRecord({ bcName: bc.name, cursor: rowId }))
        }
    }

    // TODO the condition is necessary because of editable table cells inside the core, so that there would not be duplicated actions of record change
    const needRowSelectRecord = expandable || meta.options?.readOnly

    const bcUrl = useSelector((state: AppState) => state.screen.bo.bc[meta.bcName] && buildBcUrl(meta.bcName, true))
    const operations = useSelector((state: AppState) => state.view.rowMeta?.[meta.bcName]?.[bcUrl]?.actions)

    const { showExport, exportTable } = useExportTable({ widget: meta })
    const showSaveFiltersButton = true
    const showSettings = showExport || showSaveFiltersButton

    const { visible: filterSettingVisible, toggleVisibility: toggleFilterSettingVisible } = useVisibility(false)

    const { saveCurrentFiltersAsGroup, filterGroups, removeFilterGroup, filtersExist } = usePresetFilterSettings(meta.bcName)

    const handleSaveFilterGroup = useCallback(
        (values: { name: string }) => {
            saveCurrentFiltersAsGroup(values.name)
        },
        [saveCurrentFiltersAsGroup]
    )

    return (
        <div className={styles.tableContainer}>
            <div className={styles.operations}>
                <Operations operations={operations} bcName={meta.bcName} widgetMeta={meta} />

                {showSettings && (
                    <DropdownSetting
                        buttonClassName={styles.settingButton}
                        overlay={
                            <Menu>
                                {showExport && (
                                    <Menu.Item key="3" onClick={exportTable}>
                                        {t('Export to Excel')}
                                        <Icon type="file-excel" style={{ fontSize: 14, marginLeft: 4 }} />
                                    </Menu.Item>
                                )}
                                <Menu.Item key="4" onClick={toggleFilterSettingVisible}>
                                    {t('Save filters')}
                                </Menu.Item>
                            </Menu>
                        }
                    />
                )}
            </div>

            <FilterSettingModal
                filtersExist={filtersExist}
                onDelete={removeFilterGroup}
                filterGroups={filterGroups}
                visible={filterSettingVisible}
                onCancel={toggleFilterSettingVisible}
                onSubmit={handleSaveFilterGroup}
            />

            <TableWidget
                meta={meta}
                showRowActions={true}
                controlColumns={controlColumns}
                disablePagination={true}
                {...rest}
                columnTitleComponent={props => props && <ColumnTitle {...props} />}
                expandedRowKeys={expandedRowKeys}
                allowEdit={!expandable}
                expandIconColumnIndex={getExpandIconColumnIndex(controlColumns)}
                expandIconAsCell={false}
                expandIcon={expandIcon}
                expandedRowRender={expandedRowRender}
                rowClassName={record => (record.id === bc.cursor ? 'ant-table-row-selected' : '')}
                onRow={record => ({
                    onDoubleClick: needRowSelectRecord ? () => changeCursor(record.id) : undefined
                })}
            />
            {!disablePagination && <Pagination meta={meta} />}
        </div>
    )
}

export default React.memo(Table)
