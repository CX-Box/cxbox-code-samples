import { Observable } from 'rxjs/Observable'
import { axiosInstance } from './session'
import { AxiosError, AxiosResponse } from 'axios'
import { ApiCallContext } from '@cxbox-ui/core/utils/api'
import { getStoreInstance } from '@cxbox-ui/core'
import { $do } from '../actions/types'

// TODO: Delete the file after adding the ability to transfer the body to axiosDelete

/**
 * HTTP DELETE axios request wrapped into RxJS Observable.
 * Can be interrupted by `redirectOccured` function.
 *
 * @param path Endpoint url
 * @param data
 * @param callContext Call context
 * @template ResponsePayload Response payload type
 * @category Utils
 */
export const axiosDeleteWithBody = <ResponsePayload>(path: string, data?: unknown, callContext?: ApiCallContext) => {
    return Observable.fromPromise(
        axiosInstance.delete<ResponsePayload>(`personalFilterGroups`, { data }).catch(reason => {
            onErrorHook(reason, callContext)
        }) as Promise<AxiosResponse<ResponsePayload>>
    )
        .takeWhile(redirectOccurred)
        .map(response => response.data)
}

function onErrorHook(error: AxiosError, callContext?: ApiCallContext) {
    getStoreInstance().dispatch($do.apiError({ error, callContext: callContext as ApiCallContext }))
    throw error
}

function redirectOccurred(value: AxiosResponse) {
    if (value.data?.redirectUrl) {
        let redirectUrl = value.data.redirectUrl
        if (!redirectUrl.startsWith('/') && !redirectUrl.match('^http(.?)://')) {
            redirectUrl = `${window.location.pathname}#/${redirectUrl}`
        }
        if (redirectUrl.startsWith('/') && !redirectUrl.startsWith('//')) {
            redirectUrl = `${window.location.origin}${redirectUrl}`
        }
        window.location.replace(redirectUrl)
        return false
    }
    return true
}
