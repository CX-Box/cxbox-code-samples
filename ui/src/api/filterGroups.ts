import { axiosPost } from '@cxbox-ui/core'
import { FilterGroup } from '../interfaces/filters'
import { axiosDeleteWithBody } from './axiosDelete'

export function saveFilterGroup(data: { filterGroups: FilterGroup[] }) {
    return axiosPost<{ data: { id: string }[] }>('personalFilterGroups', { data: data || {} }, undefined).map(response => response.data)
}

export function deleteFilterGroup(filterGroupId: number) {
    return axiosDeleteWithBody<{ data: unknown }>(`personalFilterGroups`, { data: [filterGroupId] })
}
