import React from 'react'
import { CustomWidgetDescriptor, PopupWidgetTypes, WidgetTypes } from '@cxbox-ui/core/interfaces/widget'
import Card from '../Card/Card'
import { View as CxboxView } from '@cxbox-ui/core'
import { CustomFieldTypes, CustomWidgetTypes } from '../../interfaces/widget'
import MultipleSelectField from '../../fields/MultipleSelectField/MultipleSelectField'
import Form from '../widgets/Form/Form'
import Header from '../widgets/Header/Header'
import AssocListPopup from '../widgets/AssocListPopup/AssocListPopup'
import PickListPopup from '../widgets/PickListPopup/PickListPopup'
import EmptyCard from '../EmptyCard/EmptyCard'
import styles from './View.module.css'
import Info from '../widgets/Info/Info'
import Table from '../widgets/Table/Table'
import { FieldType } from '@cxbox-ui/core/interfaces/view'
import Dictionary from '../../fields/Dictionary/Dictionary'
import Steps from '../widgets/Steps/Steps'
import { DashboardLayout } from '../ui/DashboardLayout/DashboardLayout'
import Funnel from '../widgets/Funnel/Funnel'
import RingProgress from '../widgets/RingProgress/RingProgress'
import DashboardCard from '../DashboardCard/DashboardCard'
import DashboardList from '../widgets/DashboardList/DashboardList'
import LevelMenu from '../widgets/LevelMenu/LevelMenu'
import { Number } from '../../fields/NumberInput/NumberInput'
import { FormPopup } from '../widgets/FormPopup/FormPopup'
import MultivalueField from '../../fields/Multivalue/MultivalueField'
import InlinePickList from '../../fields/InlinePickList/InlinePickList'
import PickListField from '../../fields/PickListField/PickListField'
import { useSelector } from 'react-redux'
import { AppState } from '../../interfaces/storeSlices'
import ViewInfoLabel from '../DebugPanel/components/ViewInfoLabel'
import PopupWidgetInfoLabel from '../DebugPanel/components/PopupWidgetInfoLabel'
import FileUpload from '../../fields/FileUpload/FileUpload'

const skipWidgetTypes: WidgetTypes[] = []

const customFields = {
    [FieldType.number]: Number,
    [FieldType.percent]: Number,
    [FieldType.money]: Number,
    [FieldType.dictionary]: Dictionary,
    [FieldType.multivalue]: MultivalueField,
    [FieldType.pickList]: PickListField,
    [FieldType.inlinePickList]: InlinePickList,
    [CustomFieldTypes.MultipleSelect]: MultipleSelectField,
    [FieldType.fileUpload]: FileUpload
}

const customWidgets: Partial<Record<CustomWidgetTypes | WidgetTypes, CustomWidgetDescriptor>> = {
    [WidgetTypes.Form]: { component: Form },
    [WidgetTypes.Info]: { component: Info },
    [WidgetTypes.List]: { component: Table },
    [WidgetTypes.HeaderWidget]: { component: Header, card: EmptyCard },
    [CustomWidgetTypes.Steps]: { component: Steps, card: EmptyCard },
    [CustomWidgetTypes.Funnel]: { component: Funnel, card: DashboardCard },
    [CustomWidgetTypes.RingProgress]: { component: RingProgress, card: DashboardCard },
    [CustomWidgetTypes.DashboardList]: { component: DashboardList, card: DashboardCard },
    [CustomWidgetTypes.FormPopup]: { component: FormPopup },
    [WidgetTypes.AssocListPopup]: AssocListPopup,
    [WidgetTypes.PickListPopup]: PickListPopup,
    [WidgetTypes.SecondLevelMenu]: { component: LevelMenu, card: EmptyCard },
    [WidgetTypes.ThirdLevelMenu]: { component: LevelMenu, card: EmptyCard },
    [WidgetTypes.FourthLevelMenu]: { component: LevelMenu, card: EmptyCard }
}

function View() {
    const debugMode = useSelector((state: AppState) => state.session.debugMode || false)
    const widgets = useSelector((state: AppState) => state.view.widgets)

    return (
        <div className={styles.container}>
            {debugMode && <ViewInfoLabel />}

            <CxboxView
                customWidgets={customWidgets as Record<string, CustomWidgetDescriptor>}
                customFields={customFields}
                card={Card as any}
                skipWidgetTypes={skipWidgetTypes}
                customLayout={DashboardLayout}
                disableDebugMode={true}
            />

            {debugMode && widgets.filter(i => PopupWidgetTypes.includes(i.type)).map(i => <PopupWidgetInfoLabel key={i.name} meta={i} />)}
        </div>
    )
}

export default React.memo(View)
