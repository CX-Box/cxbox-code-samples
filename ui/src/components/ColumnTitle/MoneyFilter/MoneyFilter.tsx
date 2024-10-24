import React, { useCallback, useEffect } from 'react'
import { useAppDispatch, useAppSelector } from '@store'
import { actions } from '@actions'
import { NumberTypes } from '@cxboxComponents/ui/NumberInput/formaters'
import CoreNumberInput from '../../../fields/NumberInput/CoreNumberInput'
import { buildBcUrl } from '@utils/buildBcUrl'
import { interfaces } from '@cxbox-ui/core'
import { AppMoneyFieldMeta } from '@interfaces/widget'
import styles from './MoneyFilter.less'

interface MoneyFilterProps {
    value: number
    meta: AppMoneyFieldMeta
    bcName: string
    onChange?: (value: number) => void
}

export const MoneyFilter = ({ value, bcName, onChange, meta }: MoneyFilterProps) => {
    const dispatch = useAppDispatch()

    const currencyKey = meta.currencyKey as string
    const bcUrl = bcName && buildBcUrl(bcName, true)
    const localCurrencyValue = useAppSelector(state => state.screen.bo.bc[bcName]?.localFilterValues?.[currencyKey]) as string[]
    const activeCurrencyFilter = useAppSelector(state => state.screen.filters[bcName]?.find(item => item.fieldName === currencyKey))
    const rowMeta = useAppSelector(state => bcName && bcUrl && state.view.rowMeta[bcName]?.[bcUrl])
    const rowFieldMeta = (rowMeta as interfaces.RowMeta)?.fields.find(field => field.key === currencyKey)

    const handleChangeCurrency = useCallback(
        (item: string | string[]) => {
            dispatch(
                actions.setLocalFilterValue({
                    value: item,
                    fieldKey: currencyKey,
                    bcName
                })
            )
        },
        [bcName, dispatch, currencyKey]
    )

    useEffect(() => {
        handleChangeCurrency(activeCurrencyFilter?.value as string[])
    }, [activeCurrencyFilter?.value, handleChangeCurrency])

    return (
        <div className={styles.container}>
            <CoreNumberInput
                meta={meta}
                value={value}
                type={NumberTypes.money}
                currency={currencyKey ? localCurrencyValue : meta.currency}
                currencyValues={rowFieldMeta?.filterValues}
                digits={meta.digits}
                nullable={meta.nullable}
                forceFocus={true}
                multipleCurrency={true}
                onChange={onChange}
                onChangeCurrency={handleChangeCurrency}
            />
        </div>
    )
}
