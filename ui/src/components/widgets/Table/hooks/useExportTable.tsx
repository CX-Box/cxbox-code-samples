import { useMemo } from 'react'
import { shallowEqual, useSelector } from 'react-redux'
import { AppState } from '../../../../interfaces/storeSlices'
import { WidgetListField, WidgetMeta } from '@cxbox-ui/core/interfaces/widget'
import { ExportOptions, exportTable } from '../../../../utils/export'
import { AppWidgetMeta } from '../../../../interfaces/widget'

interface UseExportButtonProps {
    widget: WidgetMeta
    exportWithDate?: boolean
}

export const useExportTable = ({ widget, exportWithDate = false }: UseExportButtonProps) => {
    const screenName = useSelector((store: AppState) => store.screen.screenName)
    const { bcName } = widget
    const tableFilters = useSelector((state: AppState) => state.screen.filters[bcName])
    const tableSorters = useSelector((state: AppState) => state.screen.sorters[bcName])
    const widgetData = useSelector((state: AppState) => state.data[bcName])
    const exportConfig = (widget as AppWidgetMeta).options?.export
    const showExport = exportConfig?.enabled
    const title = exportConfig?.title ?? widget.title
    const filteredFields = useMemo(() => {
        return (widget.fields as WidgetListField[])?.filter(field => !field?.hidden)
    }, [widget.fields])
    const exportOptions: ExportOptions = useSelector((state: AppState) => {
        const bc = state.screen.bo.bc[bcName]

        return {
            page: bc?.page,
            limit: bc?.limit
        }
    }, shallowEqual)

    return {
        showExport,
        exportTable: () => {
            return exportTable(
                screenName,
                bcName,
                filteredFields,
                title,
                exportWithDate,
                !!widgetData?.length,
                tableFilters,
                tableSorters,
                exportOptions
            )
        }
    }
}
