import { axiosGet, buildUrl, getStoreInstance } from '@cxbox-ui/core'
import { LoginResponse } from '@cxbox-ui/core/interfaces/session'
import axios, { AxiosRequestConfig } from 'axios'
import { keycloak, KEYCLOAK_MIN_VALIDITY } from '../keycloak'
import { __API__ } from '../constants/constants'
import { AppState, ScreenState } from '../interfaces/storeSlices'

const __AJAX_TIMEOUT__ = 900000
const __CLIENT_ID__: number = Date.now()

export const HEADERS = { Pragma: 'no-cache', 'Cache-Control': 'no-cache, no-store, must-revalidate' }

export function getBasicAuthRequest(login?: string, password?: string) {
    const hash = login && new Buffer(`${login}:${password}`).toString('base64') //TODO delete?
    const tzOffset = -new Date().getTimezoneOffset() * 60
    const entrypointUrl = `/${window.location.hash}`
    return axiosGet<LoginResponse>(
        buildUrl`login?_tzoffset=${tzOffset}&_entrypointUrl=${entrypointUrl}`,
        hash ? { headers: { Authorization: `Basic ${hash}` } } : { headers: { Authorization: `Bearer ${keycloak.token}` } }
    )
}

function tokenInterceptor(rqConfig: AxiosRequestConfig) {
    return keycloak.updateToken(KEYCLOAK_MIN_VALIDITY).then(() => {
        return {
            ...rqConfig,
            headers: {
                ...rqConfig.headers,
                Authorization: `Bearer ${keycloak.token}`
            }
        }
    })
}

export const EMPTY_ARRAY: unknown[] = []

/**
 * Sets `_fullTextSearch` parameter for get requests
 */
function useFullTextInterceptor(rqConfig: AxiosRequestConfig) {
    const storeInstance = getStoreInstance().getState() as AppState
    const isGetDataRequest =
        (rqConfig.url?.startsWith('data') || rqConfig.url?.startsWith('count/')) && rqConfig.method?.toUpperCase() === 'GET'
    const isCustomActionRequest = rqConfig.url?.startsWith('custom-action') && rqConfig.method?.toUpperCase() === 'POST'
    let bcName = null
    if (isGetDataRequest) {
        const bcHierarchy = rqConfig.url?.split('?')[0].split('/').slice(2)
        if (bcHierarchy && bcHierarchy.length % 2 !== 0) {
            bcName = bcHierarchy?.pop()
        }
    }
    if (isCustomActionRequest) {
        const bcHierarchy = rqConfig.url?.split('?')[0].split('/').slice(-2)
        bcName = bcHierarchy?.shift()
    }
    const isStoreContainFilter = (bcName && (storeInstance.screen as ScreenState).fullTextFilter[bcName]) || EMPTY_ARRAY
    if (isStoreContainFilter) {
        rqConfig.params = rqConfig.params || {}
        rqConfig.params._fullTextSearch = (storeInstance.screen as ScreenState).fullTextFilter[bcName as string]
    }
    return rqConfig
}

export function axiosInstance() {
    const instance = axios.create({
        baseURL: __API__,
        timeout: __AJAX_TIMEOUT__,
        responseType: 'json',
        headers: {
            ...HEADERS,
            ...{ ClientId: __CLIENT_ID__ }
        }
    })

    instance.interceptors.request.use(tokenInterceptor, () => Promise.reject())
    instance.interceptors.request.use(useFullTextInterceptor)

    return instance
}
