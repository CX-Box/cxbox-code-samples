import { useInternalWidgetByType } from '@hooks/useInternalWidget'
import { useEffect } from 'react'
import { AppWidgetMeta } from '@interfaces/widget'

export function useTreeInternalWidget(externalWidget: AppWidgetMeta | undefined) {
    const editWidgetParams = useInternalWidgetByType(externalWidget, 'edit')
    const widgetName = externalWidget?.name

    useEffect(() => {
        if (widgetName && editWidgetParams?.style !== 'none') {
            console.error(`Tree widget "${widgetName}": editing is not supported yet. Only "edit.style: none" is allowed.`)
        }
    }, [editWidgetParams?.style, externalWidget, widgetName])
}
