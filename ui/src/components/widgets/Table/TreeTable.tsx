import React from 'react'
import { ColumnProps, TableProps as AntdTableProps } from 'antd/es/table'
import styles from './Table.less'
import { AppWidgetGroupingHierarchyMeta, AppWidgetTableMeta, CustomWidgetTypes } from '@interfaces/widget'
import Operations from '../../Operations/Operations'
import { WidgetListField } from '@cxbox-ui/schema'
import ColumnTitle from '@components/ColumnTitle/ColumnTitle'
import { RowMetaField } from '@interfaces/rowMeta'
import { CustomDataItem } from '@components/widgets/Table/Table.interfaces'
import StandardTable from '@components/widgets/Table/StandardTable'
import { useRowMetaWithCache } from '@hooks/useRowMetaWithCache'
import { TableCell } from '@components/widgets/Table/TableCell'
import { RESTORE_ANCESTORS_ID, ROW_KEY, TREE_ROOT_ID } from '@components/widgets/Table/constants'
import { TableTreeNode, useTableTree } from '@components/widgets/Table/tree/hooks/useTableTree'
import { Spin, Typography, Checkbox, Icon } from 'antd'
import { useTranslation } from 'react-i18next'
import { useTreeRowSelection } from '@components/widgets/Table/tree/hooks/useTreeRowSelection'
import { useWidgetPaginationLimit } from '@features/pagination/hooks/useWidgetPaginationLimit'
import Limit from '@components/ui/Pagination/components/Limit'
import Button from '@components/ui/Button/Button'
import { isDefined } from '@utils/isDefined'
import { useAppSelector } from '@store'
import { selectBc } from '@selectors/selectors'
import { useDispatch } from 'react-redux'
import { actions } from '@actions'
import { TableEventListeners } from 'antd/lib/table/interface'

interface TreeTableProps<T extends CustomDataItem> extends AntdTableProps<T> {
    meta: AppWidgetTableMeta | AppWidgetGroupingHierarchyMeta
    treeRowSelection?: ReturnType<typeof useTreeRowSelection>
    disableRowSelection?: boolean
}

const INDENT_SIZE = 20

const getLevel = (dataItem: any): number => {
    return dataItem._level ?? 0
}

function TreeTable<T extends CustomDataItem>({
    meta: widget,
    onRow,
    rowSelection,
    treeRowSelection,
    disableRowSelection,
    rowClassName,
    ...rest
}: TreeTableProps<T>) {
    const { t } = useTranslation()
    const { bcName, name: widgetName } = widget
    const bc = useAppSelector(state => selectBc(state, bcName))
    const dispatch = useDispatch()
    const bcRowMeta = useRowMetaWithCache(bcName, true)

    const { dataSource, handleExpand, expandedRowKeys, createFetchNodesHandler, restoreAncestorPaths } = useTableTree(widget)
    const defaultTreeRowSelection = useTreeRowSelection(widgetName)
    const { selectNode, getNodeSelectionState } = treeRowSelection ?? defaultTreeRowSelection
    const parentRef = React.useRef()

    const { changePageLimit, hideLimitOptions, value: pageLimit, options } = useWidgetPaginationLimit(widget)

    const handleRow = React.useCallback(
        (record: T, index: number) => {
            const treeRecord = record as T & TableTreeNode
            const tableEventListeners: TableEventListeners = {
                onClick: event => {
                    if (event.defaultPrevented || treeRecord._recordType !== 'node') {
                        return
                    }

                    const selection = window.getSelection()
                    if ((selection === null || selection.type !== 'Range') && record.id !== bc?.cursor) {
                        dispatch(actions.bcSelectRecord({ bcName: bc?.name as string, cursor: record.id }))
                    }
                }
            }

            return {
                ...tableEventListeners,
                ...onRow?.(record, index),
                'data-test-widget-tree-row-id': record.id,
                'data-test-widget-tree-row-type': treeRecord._recordType === 'node' ? 'Row' : 'PseudoRow'
            } as TableEventListeners
        },
        [bc?.cursor, bc?.name, dispatch, onRow]
    )

    const columns: Array<ColumnProps<any>> = React.useMemo(() => {
        const showSelection = !disableRowSelection

        return (
            widget.fields?.map((item, index) => {
                const fieldRowMeta = bcRowMeta?.fields?.find(field => field.key === item.key)
                const isGroupingHierarchy = (widget?.type as string) === CustomWidgetTypes.GroupingHierarchy

                const isFirstColumn = index === 0

                let titleContent: React.ReactNode = (
                    <ColumnTitle
                        showCloseButton={false}
                        widgetName={widgetName}
                        widgetMeta={item as WidgetListField}
                        rowMeta={fieldRowMeta as RowMetaField}
                    />
                )

                const { checked, indeterminate, implicit } = getNodeSelectionState(TREE_ROOT_ID)

                if (isFirstColumn && showSelection) {
                    titleContent = (
                        <div style={{ display: 'flex', alignItems: 'center' }}>
                            <Checkbox
                                style={{ marginRight: 8 }}
                                className={implicit ? styles.implicitCheckboxMuted : ''}
                                checked={checked}
                                indeterminate={indeterminate}
                                onChange={e => selectNode(TREE_ROOT_ID, e.target.checked)}
                                onClick={e => e.stopPropagation()}
                            />
                            {titleContent}
                        </div>
                    )
                }

                return {
                    title: titleContent,
                    key: item.key,
                    dataIndex: item.key,
                    width: item.width,
                    render: (text: string, dataItem: T & TableTreeNode) => {
                        const level = getLevel(dataItem)
                        const paddingLeft = level * INDENT_SIZE

                        const renderPrefix = () => {
                            if (!isFirstColumn) {
                                return null
                            }

                            const isExpanded = expandedRowKeys.includes(dataItem.id as string)

                            let expandIcon = null
                            if (!dataItem._treeIsLeaf && dataItem._recordType === 'node') {
                                expandIcon = (
                                    <Icon
                                        type={isExpanded ? 'down' : 'right'}
                                        style={{ marginRight: 8, cursor: 'pointer' }}
                                        onClick={e => {
                                            e.stopPropagation()
                                            handleExpand(!isExpanded, dataItem as any)
                                        }}
                                    />
                                )
                            } else {
                                expandIcon = <span style={{ display: 'inline-block', width: 22 }} />
                            }

                            const { checked, indeterminate, implicit, disabled } = getNodeSelectionState(dataItem)

                            let checkbox = null

                            if (showSelection && dataItem._recordType === 'node') {
                                checkbox = (
                                    <Checkbox
                                        style={{ marginRight: 8 }}
                                        className={implicit ? styles.implicitCheckboxMuted : ''}
                                        checked={checked}
                                        indeterminate={indeterminate}
                                        disabled={disabled}
                                        onChange={e => selectNode(dataItem as any, e.target.checked)}
                                        onClick={e => e.stopPropagation()}
                                    />
                                )
                            }

                            return (
                                <span style={{ paddingLeft, display: 'flex', alignItems: 'center' }}>
                                    {expandIcon}
                                    {checkbox}
                                </span>
                            )
                        }

                        if (
                            dataItem._recordType === 'loading' ||
                            dataItem._recordType === 'show-more' ||
                            dataItem._recordType === 'empty' ||
                            dataItem._recordType === 'restore-ancestors'
                        ) {
                            if (isFirstColumn) {
                                let content = null

                                const { checked, indeterminate, implicit, disabled } = getNodeSelectionState(dataItem)

                                let checkbox = null

                                if (showSelection && dataItem._recordType === 'show-more') {
                                    checkbox = (
                                        <Checkbox
                                            style={{ marginRight: 8 }}
                                            className={implicit ? styles.implicitCheckboxMuted : ''}
                                            checked={checked}
                                            indeterminate={indeterminate}
                                            disabled={disabled}
                                            onChange={e => selectNode(dataItem as any, e.target.checked)}
                                            onClick={e => e.stopPropagation()}
                                        />
                                    )
                                }

                                if (dataItem._recordType === 'loading') {
                                    content = (
                                        <span data-pseudo-row={true}>
                                            <Spin size="small" />
                                        </span>
                                    )
                                } else if (dataItem._recordType === 'empty') {
                                    content = (
                                        <span data-pseudo-row={true}>
                                            <Typography.Text type="secondary">{t('No Data')}</Typography.Text>
                                        </span>
                                    )
                                } else if (dataItem._recordType === 'show-more') {
                                    content = (
                                        <span data-pseudo-row={true}>
                                            {checkbox}
                                            <Button
                                                type="default"
                                                size="small"
                                                disabled={dataItem._disabled}
                                                loading={dataItem._loading}
                                                onClick={createFetchNodesHandler(dataItem.parentId, true)}
                                            >
                                                ...
                                            </Button>
                                        </span>
                                    )
                                } else if (dataItem._recordType === 'restore-ancestors') {
                                    content = (
                                        <span data-pseudo-row={true} style={{ color: '#fa8c16' }}>
                                            <Button
                                                style={{ marginLeft: -22, marginRight: 8 }}
                                                type="default"
                                                size="small"
                                                disabled={dataItem._disabled}
                                                loading={dataItem._loading}
                                                onClick={event => {
                                                    event.stopPropagation()
                                                    restoreAncestorPaths(
                                                        dataItem?.children?.map(i => i._treeParentId).filter(isDefined) ?? []
                                                    )
                                                }}
                                            >
                                                <Icon type="search" style={{ color: '#fa8c16' }} />
                                            </Button>
                                            {t('Path not fully restored')}
                                        </span>
                                    )
                                }

                                return (
                                    <div style={{ display: 'flex', alignItems: 'center' }} data-pseudo-row={true}>
                                        <span style={{ paddingLeft: paddingLeft + 22 }} />
                                        {content}
                                    </div>
                                )
                            }

                            return null
                        }

                        const cellContent = (
                            <TableCell
                                item={item}
                                dataItem={dataItem as any}
                                isGroupingHierarchy={isGroupingHierarchy}
                                enabledGrouping={false}
                                isEditMode={() => false}
                                needHideActions={() => false}
                                sortedGroupKeys={[]}
                                expandedParentRowKeys={[]}
                                groupingHierarchyModeAggregate={false}
                                processedMeta={widget}
                                bcName={bcName}
                                widgetName={widgetName}
                            />
                        )

                        if (isFirstColumn) {
                            return (
                                <div style={{ display: 'flex', alignItems: 'center' }}>
                                    {renderPrefix()}
                                    {cellContent}
                                </div>
                            )
                        }

                        return cellContent
                    },
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
        widget,
        bcRowMeta?.fields,
        widgetName,
        bcName,
        expandedRowKeys,
        getNodeSelectionState,
        handleExpand,
        selectNode,
        t,
        createFetchNodesHandler,
        restoreAncestorPaths,
        disableRowSelection
    ])

    return (
        <div className={styles.tableContainer}>
            <div className={styles.operations}>
                <Operations operations={bcRowMeta?.actions} bcName={bcName} widgetMeta={widget} />
            </div>
            <StandardTable<T>
                expandedRowKeys={[RESTORE_ANCESTORS_ID, ...expandedRowKeys]}
                wrapperRef={parentRef as any}
                widgetName={widgetName}
                columns={columns}
                dataSource={dataSource as unknown as T[]}
                rowKey={ROW_KEY}
                expandIconColumnIndex={-1}
                hidePagination={true}
                indentSize={0}
                rowSelection={undefined}
                rowClassName={(record, index) => {
                    const originalClassName = rowClassName?.(record, index)
                    return [originalClassName, (record as unknown as TableTreeNode)._matchesFilter ? styles.treeFilterMatch : '']
                        .filter(Boolean)
                        .join(' ')
                }}
                onRow={handleRow}
                {...rest}
            />
            {!hideLimitOptions && <Limit disabled={false} value={pageLimit} onChange={changePageLimit} total={null} options={options} />}
        </div>
    )
}

export default React.memo(TreeTable) as typeof TreeTable
