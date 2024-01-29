import { FilterGroup as CoreFilterGroup } from '@cxbox-ui/core/interfaces/filters'

export interface FilterGroup extends CoreFilterGroup {
    name: string
    filters: string
    id?: string
    personal?: boolean
    bc?: string
}
