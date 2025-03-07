import React from 'react'
import { CheckboxFilter } from './CheckboxFilter/CheckboxFilter'
import { AppNumberFieldMeta, CustomFieldTypes } from '@interfaces/widget'
import { getFormat } from '@utils/date'
import RangePicker from './RangePicker'
import DatePicker from './DatePicker'
import { DateFieldTypes } from '@interfaces/date'
import { CheckboxChangeEvent } from 'antd/lib/checkbox'
import { Checkbox } from 'antd'
import { interfaces } from '@cxbox-ui/core'
import { ColumnFilterControlProps } from '@cxboxComponents/ui/FilterField/FilterField'
import { NumberInput, FilterField as CoreFilterField } from '@cxboxComponents'

interface FilterFieldProps extends ColumnFilterControlProps {
    visible?: boolean
    filterByRangeEnabled?: boolean
}

const { FieldType } = interfaces

function FilterField({ visible, filterByRangeEnabled, ...props }: FilterFieldProps) {
    const { widgetFieldMeta, value, onChange, rowFieldMeta } = props
    const fieldType = widgetFieldMeta.type as string

    switch (fieldType) {
        case FieldType.checkbox: {
            return (
                <Checkbox
                    data-test-filter-popup-select-value={true}
                    checked={value as boolean}
                    onChange={(e: CheckboxChangeEvent) => {
                        onChange(e.target.checked)
                    }}
                >
                    {rowFieldMeta?.placeholder}
                </Checkbox>
            )
        }
        case FieldType.number:
        case FieldType.money:
        case FieldType.percent:
            const fieldMeta = widgetFieldMeta as AppNumberFieldMeta
            return (
                <NumberInput
                    data-test-filter-popup-value={true}
                    value={value as number}
                    type={widgetFieldMeta.type as any}
                    onChange={onChange}
                    digits={fieldMeta.digits}
                    nullable={fieldMeta.nullable}
                    currency={fieldMeta.currency}
                    forceFocus={true}
                />
            )
        case CustomFieldTypes.MultipleSelect:
        case FieldType.radio: {
            return (
                <CheckboxFilter
                    title={widgetFieldMeta.title}
                    value={value as interfaces.DataValue[]}
                    filterValues={rowFieldMeta.filterValues ? rowFieldMeta.filterValues : []}
                    onChange={onChange}
                />
            )
        }
        case FieldType.pickList: {
            return <CoreFilterField {...props} widgetFieldMeta={{ ...props.widgetFieldMeta, type: FieldType.input }} />
        }
        case FieldType.dateTimeWithSeconds:
        case FieldType.dateTime:
        case FieldType.date: {
            if (filterByRangeEnabled) {
                return (
                    <RangePicker
                        value={props.value as interfaces.DataValue[]}
                        onChange={onChange}
                        format={getFormat(fieldType === FieldType.dateTime, fieldType === FieldType.dateTimeWithSeconds)}
                        open={visible}
                        showTime={getShowTime(fieldType)}
                    />
                )
            }
            return (
                <DatePicker
                    data-test-filter-popup-value={true}
                    autoFocus
                    onChange={onChange}
                    value={value as interfaces.DataValue[]}
                    format={getFormat()}
                    open={visible}
                />
            )
        }

        default: {
            return <CoreFilterField {...props} />
        }
    }
}

export default React.memo(FilterField)

function getShowTime(type: DateFieldTypes | string) {
    switch (type) {
        case FieldType.dateTimeWithSeconds:
            return { format: 'HH:mm:ss' }
        case FieldType.dateTime:
            return { format: 'HH:mm' }
        default:
            return undefined
    }
}
