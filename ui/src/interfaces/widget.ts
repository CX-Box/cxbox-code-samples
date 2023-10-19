import {
    WidgetMeta,
    WidgetTypes,
    WidgetOptions,
    WidgetListFieldBase,
    WidgetFormMeta,
    WidgetTableMeta,
    PickListFieldMeta
} from '@cxbox-ui/core/interfaces/widget'

export enum CustomFieldTypes {
    MultipleSelect = 'multipleSelect',
    SuggestionPickList = 'suggestionPickList'
}

export enum CustomWidgetTypes {
    FormPopup = 'FormPopup',
    Steps = 'Steps',
    Funnel = 'Funnel',
    RingProgress = 'RingProgress',
    DashboardList = 'DashboardList',
    SuggestionPickList = 'SuggestionPickList'
}

export const removeRecordOperationWidgets: Array<WidgetTypes | string> = [WidgetTypes.List]

export interface StepsWidgetMeta extends WidgetMeta {
    type: CustomWidgetTypes.Steps
    options: WidgetOptions & {
        stepsOptions: {
            stepsDictionaryKey: string
        }
    }
}

export interface FunnelWidgetMeta extends WidgetMeta {
    type: CustomWidgetTypes.Funnel
    options: WidgetOptions & { funnelOptions: { dataKey: string } }
}

export interface RingProgressWidgetMeta extends WidgetMeta {
    type: CustomWidgetTypes.RingProgress
    options: WidgetOptions & { ringProgressOptions: { text: string; numberField: string; descriptionField: string; percentField: string } }
}

export type TableWidgetField = WidgetListFieldBase & {
    /**
     * Width (px) to be set for the field when exporting to Excel
     */
    excelWidth?: number
}

type InternalWidgetOption = {
    widget: string
    style: 'inlineForm' | 'popup' | 'inline' | 'none'
}

export interface AppWidgetMeta extends WidgetMeta {
    options?: WidgetOptions & {
        primary?: {
            enabled: boolean
            title?: string
        }

        create?: InternalWidgetOption
        edit?: InternalWidgetOption

        export?: {
            // Part of the file name, by default taken from the widget title
            title?: string
            enabled: boolean
        }
    }
}

export interface AppWidgetTableMeta extends WidgetTableMeta {
    options?: AppWidgetMeta['options']
}

export interface WidgetFormPopupMeta extends Omit<WidgetFormMeta, 'type'> {
    type: CustomWidgetTypes.FormPopup
}

export interface SuggestionPickListWidgetMeta extends WidgetMeta {
    type: CustomWidgetTypes.SuggestionPickList
    fields: Array<{
        title: string
        key: string
    }>
}

export interface SuggestionPickListField extends Omit<PickListFieldMeta, 'type'> {
    type: CustomFieldTypes.SuggestionPickList
}
