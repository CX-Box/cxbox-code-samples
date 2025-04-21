import React, { useEffect, useState } from 'react'
import { Icon, TimePicker } from 'antd'
import { DataValue } from '@cxbox-ui/schema'
import moment from 'moment'
import styles from './RangePicker.less'
import { useTranslation } from 'react-i18next'
import { isoLocalFormatter } from '@utils/date'
import { TimePickerProps } from 'antd/lib/time-picker'
import { useAppSelector } from '@store'

interface TimeRangePickerProps extends Omit<TimePickerProps, 'onChange' | 'value'> {
    onChange: (v: DataValue[]) => void
    value: DataValue[]
}

function TimeRangePicker({ value, onChange, open, ...rest }: TimeRangePickerProps) {
    const defaultDate = useAppSelector(state => state.session)
    const startTime = Array.isArray(value) && value?.[0] ? moment(value[0] as string) : undefined
    const endTime = Array.isArray(value) && value?.[1] ? moment(value[1] as string) : undefined
    const [endOpen, setEndOpen] = useState(false)
    const [startOpen, setStartOpen] = useState(false)

    const { t } = useTranslation()

    const handleChange = (pickerType: 'start' | 'end'): TimePickerProps['onChange'] => {
        return date => {
            const newStartDate = pickerType === 'start' ? (!startTime ? date?.startOf('day') : date) : startTime
            const newEndDate = pickerType === 'end' ? (!endTime ? date?.endOf('day') : date) : endTime

            onChange([isoLocalFormatter(newStartDate), isoLocalFormatter(newEndDate)])
        }
    }

    const handleOpenPicker = (picker: 'start' | 'end') => {
        if (picker === 'start') {
            setStartOpen(true)
        }
    }

    return (
        <div style={{ display: 'flex' }}>
            <TimePicker
                {...rest}
                data-test-filter-popup-start-value={true}
                placeholder={t('Start date')}
                onChange={handleChange('start')}
                value={startTime}
                open={startOpen}
                onOpenChange={open => setStartOpen(open)}
                popupStyle={{ zIndex: '9999999' }}
            />
            <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                <Icon style={{ color: '#c5c5c5' }} type="right-square" />
                <Icon style={{ color: '#c5c5c5' }} type="left-square" />
            </div>
            <TimePicker
                {...rest}
                data-test-filter-popup-end-value={true}
                placeholder={t('End time')}
                onChange={handleChange('end')}
                value={endTime}
                open={endOpen}
                onOpenChange={open => setEndOpen(open)}
                popupStyle={{ zIndex: '9999999' }}
            />
        </div>
    )
}

export default React.memo(TimeRangePicker)
