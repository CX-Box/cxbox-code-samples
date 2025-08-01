import React from 'react'
import { connect } from 'react-redux'
import { Dispatch } from 'redux'
import { Checkbox } from 'antd'
import { CheckboxChangeEvent } from 'antd/es/checkbox'
import { ChangeDataItemPayload } from '@components/Field/Field'
import { interfaces, actions } from '@cxbox-ui/core'
import { RootState } from '@store'
import { buildBcUrl } from '@utils/buildBcUrl'
import styles from './CheckboxPicker.less'

export interface CheckboxPickerOwnProps {
    fieldName: string
    fieldLabel: string
    bcName: string
    cursor: string
    readonly?: boolean
    placeholder?: string
    value: interfaces.DataValue
}

interface CheckboxPickerProps extends CheckboxPickerOwnProps {
    metaField?: interfaces.RowMetaField
    onChange: (payload: ChangeDataItemPayload) => void
}

/**
 *
 * @param props
 * @category Components
 */
const CheckboxPicker: React.FC<CheckboxPickerProps> = ({
    metaField,
    bcName,
    cursor,
    fieldName,
    value,
    readonly,
    placeholder,
    onChange
}) => {
    const handleChange = React.useCallback(
        (event: CheckboxChangeEvent) => {
            const dataItem: interfaces.PendingDataItem = { [fieldName]: event.target.checked }
            const payload: ChangeDataItemPayload = {
                bcName,
                cursor,
                dataItem
            }
            onChange(payload)
        },
        [onChange, bcName, cursor, fieldName]
    )

    return (
        <div className={styles.container}>
            <Checkbox
                data-test-field-checkbox-item={true}
                checked={value as boolean}
                disabled={metaField?.disabled || readonly}
                onChange={handleChange}
            >
                {placeholder}
            </Checkbox>
        </div>
    )
}

function mapStateToProps(state: RootState, ownProps: CheckboxPickerOwnProps) {
    const bcUrl = buildBcUrl(ownProps.bcName, true)
    const metaField = bcUrl
        ? state.view.rowMeta[ownProps.bcName]?.[bcUrl]?.fields?.find(field => field.key === ownProps.fieldName)
        : undefined
    return {
        metaField
    }
}

function mapDispatchToProps(dispatch: Dispatch) {
    return {
        onChange: (payload: ChangeDataItemPayload) => {
            dispatch(actions.changeDataItem({ ...payload, bcUrl: buildBcUrl(payload.bcName, true) }))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(CheckboxPicker)
