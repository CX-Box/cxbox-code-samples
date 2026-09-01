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
import Button from '@components/ui/Button/Button'
import { isDefined } from '@utils/isDefined'
import { TREE_INDENT_SIZE } from '@components/widgets/Table/constants'

const EXPAND_ICON_WIDTH = 22
export const PSEUDO_ROW_TYPES: Array<TableTreeNode['_recordType']> = [
    'loading',
    'show-more',
    'empty',
    'restore-ancestors',
    'unallocated-nodes'
]
const EXPANDED_ICON_TYPE = 'down'
const COLLAPSED_ICON_TYPE = 'right'
const ListDotSvg = () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 10 10">
        <circle cx="5" cy="5" r="2" fill="currentColor" />
    </svg>
)

export const RightWithEllipse = () => (
    <svg
        xmlns="http://www.w3.org/2000/svg"
        viewBox="300 64 1600 894"
        width="2em"
        height="1em"
        fill="currentColor"
        aria-hidden="true"
        focusable="false"
    >
        <path
            d="
        M765.7 486.8
        L314.9 134.7
        A7.97 7.97 0 0 0 302 141
        v77.3
        c0 4.9 2.3 9.6 6.1 12.6
        l360 281.1
        -360 281.1
        c-3.9 3-6.1 7.7-6.1 12.6
        V883
        c0 6.7 7.7 10.4 12.9 6.3
        l450.8-352.1
        a31.96 31.96 0 0 0 0-50.4
        z

        M1207.7 511
        A56 56 0 1 0 1319.7 511
        A56 56 0 1 0 1207.7 511
        Z

        M1487.7 511
        A56 56 0 1 0 1599.7 511
        A56 56 0 1 0 1487.7 511
        Z

        M1767.7 511
        A56 56 0 1 0 1879.7 511
        A56 56 0 1 0 1767.7 511
        Z
    "
        />
    </svg>
)

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
    disableRowExpand?: boolean
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
    restoreAncestorPaths,
    disableRowExpand
}: TreeTableCellProps<T>) {
    const paddingLeft = (dataItem._level ?? 0) * TREE_INDENT_SIZE + TREE_INDENT_SIZE

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
                    disableRowExpand ? (
                        <Icon component={ListDotSvg} style={{ marginRight: 8, cursor: 'initial', color: 'rgba(0, 0, 0, 0.65)' }} />
                    ) : (
                        <Icon
                            type={isExpanded ? EXPANDED_ICON_TYPE : COLLAPSED_ICON_TYPE}
                            style={{ marginRight: 8, cursor: 'pointer' }}
                            onClick={event => {
                                event.stopPropagation()
                                handleExpand(!isExpanded, dataItem)
                            }}
                        />
                    )
                ) : (
                    <span style={{ display: 'inline-block', width: EXPAND_ICON_WIDTH }} />
                )}
                {dataItem._restorePath && isDefined(dataItem._treeParentId) && (
                    <Button
                        type="Link"
                        size="small"
                        removeIndentation={true}
                        style={{
                            border: 'none',
                            marginRight: 8,
                            color: '#0088bb',
                            background: 'transparent',
                            display: 'inline-flex',
                            alignItems: 'center'
                        }}
                        onClick={event => {
                            event.stopPropagation()
                            restoreAncestorPaths([String(dataItem._treeParentId)])
                        }}
                    >
                        <Icon component={RightWithEllipse} style={{ fontSize: 14, lineHeight: 1, verticalAlign: 'initial' }} />
                    </Button>
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
