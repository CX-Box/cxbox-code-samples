import React from 'react'
import { Checkbox, Icon } from 'antd'
import { WidgetListField } from '@cxbox-ui/schema'
import { TableCell } from '@components/widgets/Table/TableCell'
import { TreeTablePseudoRow } from '@components/widgets/Table/components/TreeTablePseudoRow'
import { CustomDataItem } from '@components/widgets/Table/Table.interfaces'
import { TableTreeNode, useTableTree } from '@components/widgets/Table/tree/hooks/useTableTree'
import { useTreeRowSelection } from '@components/widgets/Table/tree/hooks/useTreeRowSelection'
import { AppWidgetGroupingHierarchyMeta, AppWidgetTableMeta } from '@interfaces/widget'
import styles from '../Table.less'

const INDENT_SIZE = 20
const EXPAND_ICON_WIDTH = 22
const PSEUDO_ROW_TYPES: Array<TableTreeNode['_recordType']> = ['loading', 'show-more', 'empty', 'restore-ancestors']

interface TreeTableCellProps<T extends CustomDataItem> {
    field: WidgetListField
    dataItem: T & TableTreeNode
    isFirstColumn: boolean
    isGroupingHierarchy: boolean
    showSelection: boolean
    widget: AppWidgetTableMeta | AppWidgetGroupingHierarchyMeta
    expandedRowKeys: string[]
    selectNode: ReturnType<typeof useTreeRowSelection>['selectNode']
    getNodeSelectionState: ReturnType<typeof useTreeRowSelection>['getNodeSelectionState']
    handleExpand: ReturnType<typeof useTableTree>['handleExpand']
    createFetchNodesHandler: ReturnType<typeof useTableTree>['createFetchNodesHandler']
    restoreAncestorPaths: ReturnType<typeof useTableTree>['restoreAncestorPaths']
}

export function TreeTableCell<T extends CustomDataItem>({
    field,
    dataItem,
    isFirstColumn,
    isGroupingHierarchy,
    showSelection,
    widget,
    expandedRowKeys,
    selectNode,
    getNodeSelectionState,
    handleExpand,
    createFetchNodesHandler,
    restoreAncestorPaths
}: TreeTableCellProps<T>) {
    const paddingLeft = (dataItem._level ?? 0) * INDENT_SIZE

    if (PSEUDO_ROW_TYPES.includes(dataItem._recordType)) {
        return isFirstColumn ? (
            <TreeTablePseudoRow
                dataItem={dataItem}
                paddingLeft={paddingLeft}
                showSelection={showSelection}
                selectNode={selectNode}
                getNodeSelectionState={getNodeSelectionState}
                createFetchNodesHandler={createFetchNodesHandler}
                restoreAncestorPaths={restoreAncestorPaths}
            />
        ) : null
    }

    const cell = (
        <TableCell
            item={field}
            dataItem={dataItem as any}
            isGroupingHierarchy={isGroupingHierarchy}
            enabledGrouping={false}
            isEditMode={() => false}
            needHideActions={() => false}
            sortedGroupKeys={[]}
            expandedParentRowKeys={[]}
            groupingHierarchyModeAggregate={false}
            processedMeta={widget}
            bcName={widget.bcName}
            widgetName={widget.name}
        />
    )

    if (!isFirstColumn) {
        return cell
    }

    const isExpanded = expandedRowKeys.includes(dataItem.id as string)
    const selectionState = getNodeSelectionState(dataItem)

    return (
        <div style={{ display: 'flex', alignItems: 'center' }}>
            <span style={{ paddingLeft, display: 'flex', alignItems: 'center' }}>
                {!dataItem._treeIsLeaf && dataItem._recordType === 'node' ? (
                    <Icon
                        type={isExpanded ? 'down' : 'right'}
                        style={{ marginRight: 8, cursor: 'pointer' }}
                        onClick={event => {
                            event.stopPropagation()
                            handleExpand(!isExpanded, dataItem)
                        }}
                    />
                ) : (
                    <span style={{ display: 'inline-block', width: EXPAND_ICON_WIDTH }} />
                )}
                {showSelection && dataItem._recordType === 'node' && (
                    <Checkbox
                        style={{ marginRight: 8 }}
                        className={selectionState.implicit ? styles.implicitCheckboxMuted : ''}
                        checked={selectionState.checked}
                        indeterminate={selectionState.indeterminate}
                        disabled={selectionState.disabled}
                        onChange={event => selectNode(dataItem, event.target.checked)}
                        onClick={event => event.stopPropagation()}
                    />
                )}
            </span>
            {cell}
        </div>
    )
}
