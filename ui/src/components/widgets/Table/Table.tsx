import React, { ReactNode, useCallback, useMemo } from 'react'
import { ColumnProps, TableProps as AntdTableProps } from 'antd/es/table'
import { useExpandableForm } from './hooks/useExpandableForm'
import styles from './Table.less'
import { AppWidgetGroupingHierarchyMeta, AppWidgetTableMeta, CustomWidgetTypes } from '@interfaces/widget'
import { useAppSelector } from '@store'
import { useTableSetting, useTableSettingReset, useTableSettingResultedFields } from '@components/widgets/Table/hooks/useTableSetting'
import { useVisibility } from '@hooks/useVisibility'
import { useTranslation } from 'react-i18next'
import { useDispatch } from 'react-redux'
import { actions } from '@actions'
import { useExportTable } from '@components/widgets/Table/hooks/useExportTable'
import { Icon, Menu, Tooltip } from 'antd'
import DropdownSetting from './components/DropdownSetting'
import Operations from '../../Operations/Operations'
import FilterSettingModal from './components/FilterSettingModal'
import { usePresetFilterSettings } from './hooks/usePresetFilterSettings'
import { useRowMenu } from '@hooks/useRowMenu'
import { DataItem, FieldType, IdItemResponse } from '@cxbox-ui/core'
import { TableEventListeners } from 'antd/lib/table/interface'
import { ExpandIconProps } from 'antd/lib/table'
import { WidgetListField } from '@cxbox-ui/schema'
import ColumnTitle from '@components/ColumnTitle/ColumnTitle'
import { RowMetaField } from '@interfaces/rowMeta'
import { ControlColumn, CustomDataItem } from '@components/widgets/Table/Table.interfaces'
import { GroupingHierarchyCommonNode } from '@components/widgets/Table/groupingHierarchy'
import {
    fieldShowCondition,
    getGroupingHierarchyRowKey,
    rowShowCondition,
    useGroupingHierarchy
} from '@components/widgets/Table/groupingHierarchy'
import { selectBc, selectBcData } from '@selectors/selectors'
import ColumnOrderSettingModal from '@components/widgets/Table/components/ColumnOrderSettingModal'
import StandardTable from '@components/widgets/Table/StandardTable'
import MassLayout from '@components/widgets/Table/massOperations/Layout'
import { useRowSelection } from '@components/widgets/Table/massOperations/hooks/useRowSelection'
import ResultColumnTitle from '@components/widgets/Table/massOperations/ColumnTitle'
import { FIELDS } from '@constants'
import { useRowMetaWithCache } from '@hooks/useRowMetaWithCache'
import ResultColumnCell from '@components/widgets/Table/massOperations/ResultColumnCell'
import Button from '@components/ui/Button/Button'
import { ReactComponent as HierarchySVG } from '@assets/icons/hierarchy.svg'
import StickyTable from '@components/widgets/Table/StickyTable'
import { TableCell } from '@components/widgets/Table/TableCell'
import { ROW_KEY } from '@components/widgets/Table/constants'

interface TableProps<T extends CustomDataItem> extends AntdTableProps<T> {
    meta: AppWidgetTableMeta | AppWidgetGroupingHierarchyMeta
    primaryColumn?: ControlColumn<T>
    disablePagination?: boolean
    hideRowActions?: boolean
    disableCellEdit?: boolean
    disableMassMode?: boolean
    isGroupingHierarchy?: boolean
    settingsComponent?: ReactNode
}

function Table<T extends CustomDataItem>({
    meta: unprocessedMeta,
    isGroupingHierarchy,
    primaryColumn,
    disablePagination,
    hideRowActions: hideRowActionsExternal = false,
    disableCellEdit = false,
    disableMassMode = false,
    onRow,
    settingsComponent: outerSettingsComponent,
    ...rest
}: TableProps<T>) {
    const { t } = useTranslation()
    const { bcName, name: widgetName } = unprocessedMeta
    const bc = useAppSelector(state => selectBc(state, bcName))
    const bcRowMeta = useRowMetaWithCache(bcName, true)
    const selectedRow = useAppSelector(state => state.view.selectedRow)
    const bcData = useAppSelector(state => selectBcData(state, bcName)) as T[] | undefined
    const groupingHierarchyModeAggregate = !!(
        unprocessedMeta.options?.groupingHierarchy?.aggFields || unprocessedMeta.options?.groupingHierarchy?.aggLevels
    )

    const closeButton = useVisibility(false)
    const transfer = useVisibility(false)
    const filterSetting = useVisibility(false)

    const enabledMassMode = useAppSelector(state => state.screen.viewerMode[bcName]?.mode === 'mass' && !disableMassMode)
    const step = useAppSelector(state => state.screen.viewerMode[bcName]?.step)

    const hideRowActions = hideRowActionsExternal || enabledMassMode

    const {
        enabledGrouping,
        expandedParentRowKeys,
        changeExpand: onParentExpand,
        clearExpand: clearParentExpand,
        sortedGroupKeys,
        tree,
        getGroupingHierarchyRowKeyByRecordId,
        tableContainerRef,
        setEnabledGrouping,
        sortFieldsByGroupKeys,
        isIncorrectLimit,
        bcCountForShowing,
        bcPageLimit,
        scrollToTop,
        showUp
    } = useGroupingHierarchy(unprocessedMeta as AppWidgetGroupingHierarchyMeta, isGroupingHierarchy)

    const processedMeta = useMemo(
        () => ({ ...unprocessedMeta, fields: sortFieldsByGroupKeys(unprocessedMeta.fields) }),
        [unprocessedMeta, sortFieldsByGroupKeys]
    )

    const { onExpand, expandable, expandIcon, expandIconColumn, getExpandIconColumnIndex, expandedRowRender, expandedRowId } =
        useExpandableForm<T>(processedMeta)

    const { selectedRows, selectedRowKeys, selectAll, select } = useRowSelection(widgetName)

    const selectedRowsDictionary = useMemo(() => {
        const selectedRowsDictionary: Record<string, Omit<DataItem, 'vstamp'>> = {}

        selectedRows?.forEach(row => {
            selectedRowsDictionary[row.id as string] = row
        })

        return selectedRowsDictionary
    }, [selectedRows])

    const showSaveFiltersButton = processedMeta.options?.filterSetting?.enabled

    const disabledCheckboxForMassMode = step !== 'Select rows'
    const showCheckboxForMassMode = (['Select rows', 'Review rows'] as (typeof step)[]).includes(step)

    const rowSelectionForMassMode: AntdTableProps<DataItem>['rowSelection'] = useMemo(
        () =>
            showCheckboxForMassMode
                ? {
                      type: 'checkbox',
                      selectedRowKeys,
                      onSelect: select,
                      onSelectAll: selectAll,
                      getCheckboxProps: () => ({
                          'data-test-widget-list-column-select': true,
                          disabled: disabledCheckboxForMassMode
                      })
                  }
                : undefined,
        [disabledCheckboxForMassMode, select, selectAll, selectedRowKeys, showCheckboxForMassMode]
    )

    const currentRowSelection = enabledMassMode ? rowSelectionForMassMode : rest.rowSelection
    const showColumnSettings = !!processedMeta?.options?.additional?.enabled
    const exportConfig = processedMeta.options?.export
    const showExport = exportConfig?.enabled
    const showSettings = showSaveFiltersButton || showColumnSettings || showExport || enabledGrouping || isGroupingHierarchy
    const resetSetting = useTableSettingReset(processedMeta)
    const { resultedFields } = useTableSettingResultedFields(processedMeta, sortedGroupKeys)
    const { exportTable } = useExportTable({
        bcName: bcName,
        fields: resultedFields,
        title: exportConfig?.title ?? processedMeta.title
    })

    const controlColumns = useMemo(() => {
        const resultColumns: Array<ControlColumn<T>> = []

        if (processedMeta.options?.primary?.enabled && primaryColumn) {
            resultColumns.push(primaryColumn as any)
        }

        if (expandIconColumn && !enabledMassMode) {
            resultColumns.push({
                column: expandIconColumn,
                position: 'right'
            })
        }

        if (enabledMassMode && step === 'View results') {
            resultColumns.push({
                column: {
                    title: (
                        <ResultColumnTitle
                            title={t('Result')}
                            widgetName={widgetName}
                            bcName={bcName}
                            filterable={true}
                            fieldName={FIELDS.TECHNICAL.ID}
                        />
                    ),
                    key: '_mass-result',
                    render: (text, record: Partial<IdItemResponse>) => (
                        <ResultColumnCell record={record} selectedRow={selectedRowsDictionary[record.id as string]} />
                    )
                },
                position: 'left'
            })
        }
        return [...resultColumns]
    }, [
        processedMeta.options?.primary?.enabled,
        primaryColumn,
        expandIconColumn,
        enabledMassMode,
        step,
        t,
        widgetName,
        bcName,
        selectedRowsDictionary
    ])

    const { allFields, currentAdditionalFields, changeOrder, changeColumnsVisibility } = useTableSetting(
        processedMeta,
        sortedGroupKeys,
        currentRowSelection?.type,
        controlColumns
    )

    const hideColumn = useCallback((fieldKey: string) => changeColumnsVisibility([fieldKey], false), [changeColumnsVisibility])

    const { saveCurrentFiltersAsGroup, filterGroups, removeFilterGroup, filtersExist } = usePresetFilterSettings(bcName)

    const handleSaveFilterGroup = useCallback(
        (values: { name: string }) => {
            saveCurrentFiltersAsGroup(values.name)
        },
        [saveCurrentFiltersAsGroup]
    )

    const dispatch = useDispatch()

    // TODO the condition is necessary because of editable table cells inside the core, so that there would not be duplicated actions of record change
    const needRowSelectRecord = !expandable && processedMeta.options?.readOnly !== true && processedMeta.options?.edit?.style !== 'none'

    const isAllowEdit = !expandable && !processedMeta.options?.readOnly && !disableCellEdit && !enabledMassMode

    const [operationsRef, parentRef, handleRowMenu] = useRowMenu() // NOSONAR(S6440) hook is called conditionally, fix later

    const settings = useMemo(() => {
        if (outerSettingsComponent) {
            return outerSettingsComponent
        }
        if (showSettings) {
            let selectedKeys: string[] = []
            if (isGroupingHierarchy) {
                selectedKeys = enabledGrouping ? ['grouping_enabled'] : ['grouping_disabled']
            }
            return (
                <>
                    <DropdownSetting
                        overlay={
                            <Menu selectedKeys={selectedKeys}>
                                {showColumnSettings && (
                                    <Menu.ItemGroup key="additionalColumns" title={t('Additional columns')}>
                                        <Menu.Item key="0" onClick={transfer.toggleVisibility}>
                                            {t('Change')}
                                        </Menu.Item>
                                        <Menu.Item key="1" onClick={resetSetting}>
                                            {t('Reset')}
                                        </Menu.Item>
                                    </Menu.ItemGroup>
                                )}
                                {showExport && (
                                    <Menu.ItemGroup key="export" title={t('Export to')}>
                                        <Menu.Item key="3" onClick={() => exportTable()}>
                                            {t('Excel')}
                                            <Icon type="file-excel" style={{ fontSize: 14, marginLeft: 4 }} />
                                        </Menu.Item>
                                    </Menu.ItemGroup>
                                )}
                                {showSaveFiltersButton && (
                                    <Menu.ItemGroup key="filtersSettings" title={t('Filters settings')}>
                                        <Menu.Item key="4" onClick={filterSetting.toggleVisibility}>
                                            {t('Save filters')}
                                        </Menu.Item>
                                    </Menu.ItemGroup>
                                )}
                                {enabledGrouping && (
                                    <Menu.ItemGroup key={'grouping'} title={t('Grouping')}>
                                        <Menu.Item onClick={clearParentExpand}>{t('Collapse all')}</Menu.Item>
                                        {/*<Menu.Item onClick={clearParentExpand}>{t('Expand')}</Menu.Item>*/}
                                    </Menu.ItemGroup>
                                )}
                                {isGroupingHierarchy && (
                                    <Menu.ItemGroup key={'mode'} title={t('Mode')}>
                                        <Menu.Item
                                            key={'grouping_enabled'}
                                            disabled={isIncorrectLimit}
                                            onClick={() => setEnabledGrouping(true)}
                                        >
                                            <Tooltip
                                                title={
                                                    isIncorrectLimit
                                                        ? t('Warning! Only List mode available for Grouping Hierarchy', {
                                                              limit: bcPageLimit,
                                                              bcCount: bcCountForShowing
                                                          })
                                                        : undefined
                                                }
                                                trigger="hover"
                                            >
                                                <Icon component={HierarchySVG} />
                                                {t('Hierarchy')}
                                            </Tooltip>
                                        </Menu.Item>
                                        <Menu.Item key={'grouping_disabled'} onClick={() => setEnabledGrouping(false)}>
                                            <Icon type="table" />
                                            {t('Table')}
                                        </Menu.Item>
                                    </Menu.ItemGroup>
                                )}
                            </Menu>
                        }
                    />
                    {isGroupingHierarchy ? (
                        <div
                            style={{
                                display: showUp ? 'flex' : 'none',
                                position: 'absolute',
                                alignItems: 'center',
                                top: 0,
                                bottom: 0
                            }}
                        >
                            <Button
                                className={styles.moveToTop}
                                type="empty"
                                onClick={() => {
                                    scrollToTop()
                                }}
                                icon="arrow-up"
                            />
                        </div>
                    ) : null}
                    {isGroupingHierarchy && isIncorrectLimit ? (
                        <Tooltip
                            title={
                                isIncorrectLimit
                                    ? t('Warning! Only List mode available for Grouping Hierarchy', {
                                          limit: bcPageLimit,
                                          bcCount: bcCountForShowing
                                      })
                                    : undefined
                            }
                            trigger="hover"
                        >
                            <Icon type="warning" className={styles.limitWarningIcon} />
                        </Tooltip>
                    ) : null}
                </>
            )
        }
        return null
    }, [
        bcCountForShowing,
        bcPageLimit,
        clearParentExpand,
        enabledGrouping,
        exportTable,
        filterSetting.toggleVisibility,
        isGroupingHierarchy,
        isIncorrectLimit,
        outerSettingsComponent,
        resetSetting,
        scrollToTop,
        setEnabledGrouping,
        showColumnSettings,
        showExport,
        showSaveFiltersButton,
        showSettings,
        showUp,
        t,
        transfer.toggleVisibility
    ])

    const onHeaderRow = useCallback(() => {
        return {
            'data-test-widget-list-header': true,
            onDoubleClick: showColumnSettings ? closeButton.toggleVisibility : undefined
        }
    }, [showColumnSettings, closeButton.toggleVisibility])

    const expandedRowKeys = useMemo(() => {
        if (enabledGrouping) {
            const expandedRowKey = getGroupingHierarchyRowKeyByRecordId(expandedRowId)

            return expandedRowKey && !expandedParentRowKeys.includes(expandedRowKey)
                ? [expandedRowKey, ...expandedParentRowKeys]
                : expandedParentRowKeys
        }

        return expandedRowId ? [expandedRowId, ...expandedParentRowKeys] : expandedParentRowKeys
    }, [enabledGrouping, expandedParentRowKeys, expandedRowId, getGroupingHierarchyRowKeyByRecordId])

    const needHideActions = useCallback(
        (record: T) => {
            return (
                isGroupingHierarchy &&
                (!(
                    fieldShowCondition(
                        resultedFields
                            ?.filter(item => item.type !== FieldType.hidden && !item.hidden)
                            .find(field => !sortedGroupKeys.includes(field.key))?.key as string,
                        record,
                        sortedGroupKeys,
                        expandedRowKeys
                    ) || typeof record._groupLevel !== 'number'
                ) ||
                    (groupingHierarchyModeAggregate && typeof record._groupLevel === 'number'))
            )
        },
        [expandedRowKeys, groupingHierarchyModeAggregate, isGroupingHierarchy, resultedFields, sortedGroupKeys]
    )

    const needHideRow = useCallback(
        (record: T) => {
            return isGroupingHierarchy && enabledGrouping && !rowShowCondition(record, sortedGroupKeys, expandedParentRowKeys)
        },
        [enabledGrouping, expandedParentRowKeys, isGroupingHierarchy, sortedGroupKeys]
    )

    const handleRow = useCallback(
        (record: T, index: number) => {
            const rowMenuEventListeners = handleRowMenu(record as DataItem)

            const tableEventListeners = {
                ...rowMenuEventListeners,
                onClick: event => {
                    if (event.defaultPrevented) {
                        return
                    }

                    if (enabledMassMode) {
                        return
                    }

                    const selection = window.getSelection()
                    if (selection === null || selection.type !== 'Range') {
                        if (needRowSelectRecord) {
                            if (record.id !== selectedRow?.rowId) {
                                dispatch(actions.selectTableRowInit({ widgetName: widgetName, rowId: record.id }))
                            }
                        } else {
                            if (record.id !== bc?.cursor) {
                                dispatch(actions.bcSelectRecord({ bcName: bc?.name as string, cursor: record.id }))
                            }
                        }
                    }
                }
            } as TableEventListeners

            const otherProperties = {
                'data-test-widget-list-row-id': record.id,
                'data-test-widget-list-row-type': typeof record._groupLevel === 'number' ? 'GroupingRow' : 'Row'
            } as Record<string, unknown>

            if (needHideActions(record)) {
                Object.keys(tableEventListeners).forEach(key => {
                    delete tableEventListeners[key as keyof typeof tableEventListeners]
                })
            }

            if (needHideRow(record)) {
                otherProperties.style = { display: 'none' } // more performant than components.row
            }

            return {
                ...tableEventListeners,
                ...onRow?.(record, index),
                ...otherProperties
            } as TableEventListeners
        },
        [
            handleRowMenu,
            needHideActions,
            needHideRow,
            onRow,
            enabledMassMode,
            needRowSelectRecord,
            selectedRow?.rowId,
            dispatch,
            widgetName,
            bc?.cursor,
            bc?.name
        ]
    )

    const dataSource = useMemo(() => {
        return enabledGrouping ? (tree as T[]) : bcData
    }, [enabledGrouping, tree, bcData])

    const resultExpandIcon = useCallback(
        (expandIconProps: ExpandIconProps<T>) => {
            return !needHideActions(expandIconProps.record) ? expandIcon?.(expandIconProps) : null
        },
        [expandIcon, needHideActions]
    )

    // after: Expanding a record when changing a record or changing the order

    const isEditMode = useCallback(
        (record: T) => {
            return (
                isAllowEdit &&
                selectedRow !== null &&
                widgetName === selectedRow.widgetName &&
                record.id === selectedRow.rowId &&
                bc?.cursor === selectedRow.rowId
            )
        },
        [bc?.cursor, isAllowEdit, selectedRow, widgetName]
    )

    const columns: Array<ColumnProps<T>> = React.useMemo(() => {
        return (
            resultedFields?.map(item => {
                const fieldRowMeta = bcRowMeta?.fields?.find(field => field.key === item.key)
                const isGroupingHierarchy = (processedMeta?.type as string) === CustomWidgetTypes.GroupingHierarchy
                const isGroupingField = !!processedMeta?.options?.groupingHierarchy?.fields?.includes(item.key)

                return {
                    title: (
                        <ColumnTitle
                            showCloseButton={isGroupingHierarchy ? !isGroupingField && closeButton.visibility : closeButton.visibility}
                            onClose={hideColumn}
                            widgetName={widgetName}
                            widgetMeta={item as WidgetListField}
                            rowMeta={fieldRowMeta as RowMetaField}
                        />
                    ),
                    key: item.key,
                    dataIndex: item.key,
                    width: item.width,
                    render: (text: string, dataItem: T & GroupingHierarchyCommonNode) => (
                        <TableCell
                            item={item}
                            dataItem={dataItem}
                            isGroupingHierarchy={isGroupingHierarchy}
                            enabledGrouping={enabledGrouping}
                            isEditMode={isEditMode}
                            needHideActions={needHideActions}
                            sortedGroupKeys={sortedGroupKeys}
                            expandedParentRowKeys={expandedParentRowKeys}
                            groupingHierarchyModeAggregate={groupingHierarchyModeAggregate}
                            processedMeta={processedMeta}
                            bcName={bcName}
                            widgetName={widgetName}
                            onParentExpand={onParentExpand}
                        />
                    ),
                    onHeaderCell: () => {
                        return {
                            'data-test-widget-list-header-column-title': item?.title,
                            'data-test-widget-list-header-column-type': item?.type,
                            'data-test-widget-list-header-column-key': item?.key
                        }
                    }
                }
            }) ?? []
        )
    }, [
        resultedFields,
        bcRowMeta?.fields,
        processedMeta,
        closeButton.visibility,
        hideColumn,
        widgetName,
        enabledGrouping,
        isEditMode,
        needHideActions,
        sortedGroupKeys,
        expandedParentRowKeys,
        groupingHierarchyModeAggregate,
        bcName,
        onParentExpand
    ])

    const resultColumns = React.useMemo(() => {
        const controlColumnsLeft: Array<ColumnProps<T>> = []
        const controlColumnsRight: Array<ColumnProps<T>> = []
        controlColumns?.forEach(item => {
            item.position === 'left' ? controlColumnsLeft.push(item.column) : controlColumnsRight.push(item.column)
        })
        return [...controlColumnsLeft, ...columns, ...controlColumnsRight]
    }, [columns, controlColumns])

    const stickyWithHorizontalScroll = enabledGrouping && !!dataSource?.length

    const TableComponent = stickyWithHorizontalScroll ? StickyTable : StandardTable

    const tableElement = (
        <TableComponent<T>
            operationsRef={operationsRef as any}
            wrapperRef={parentRef as any}
            widgetName={widgetName}
            onColumnDragEnd={showColumnSettings ? changeOrder : undefined}
            columns={resultColumns}
            dataSource={dataSource}
            rowKey={isGroupingHierarchy ? getGroupingHierarchyRowKey : ROW_KEY}
            onRow={handleRow}
            onHeaderRow={onHeaderRow}
            expandedRowKeys={expandedRowKeys}
            expandIconColumnIndex={getExpandIconColumnIndex(controlColumns, resultedFields, currentRowSelection?.type)}
            expandIcon={enabledMassMode ? undefined : resultExpandIcon}
            expandedRowRender={enabledMassMode ? undefined : expandedRowRender}
            onExpand={onExpand}
            hideRowActions={hideRowActions}
            hidePagination={disablePagination || enabledGrouping}
            settingsRender={settings}
            {...rest}
            rowSelection={currentRowSelection}
        />
    )

    return (
        <div ref={tableContainerRef} className={styles.tableContainer}>
            {enabledMassMode ? (
                <MassLayout widgetName={widgetName} bcName={bcName}>
                    {tableElement}
                </MassLayout>
            ) : (
                <>
                    <div className={styles.operations}>
                        <Operations operations={bcRowMeta?.actions} bcName={bcName} widgetMeta={processedMeta} />
                    </div>
                    {tableElement}
                </>
            )}

            <ColumnOrderSettingModal
                visible={transfer.visibility}
                onCancel={transfer.toggleVisibility}
                dataSource={allFields}
                targetKeys={currentAdditionalFields}
                onChange={changeColumnsVisibility}
            />

            <FilterSettingModal
                filtersExist={filtersExist}
                onDelete={removeFilterGroup}
                filterGroups={filterGroups}
                visible={filterSetting.visibility}
                onCancel={filterSetting.toggleVisibility}
                onSubmit={handleSaveFilterGroup}
            />
        </div>
    )
}

export default React.memo(Table) as typeof Table
