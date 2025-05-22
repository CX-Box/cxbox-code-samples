import React, { useState } from 'react'
import cn from 'classnames'
import styles from './FileUpload.less'
import FileIcon from './FileIconContainer'
import { getExtension, trimString } from '@utils/fileViewer'
import { CxBoxApiInstance } from '../../api'
import Button from '@components/ui/Button/Button'
import PopupContent from '@components/FileViewerPopup/PopupContent'
import Popup from '@components/ui/Popup/Popup'
import { keycloak } from '../../keycloak'
import { DocumentEditor } from '@onlyoffice/document-editor-react'

export interface ReadOnlySingleFileUploadProps {
    mode?: 'default' | 'snapshot'
    fileName: string
    downloadUrl?: string // undefined if file url for download is not correct (no id)
    diffFileName?: string
    diffDownloadUrl?: string // undefined if file url for download is not correct (no id)
    onFileIconClick?: () => void
}

function onLoadComponentError(errorCode: any, errorDescription: any) {
    switch (errorCode) {
        case -1: // Unknown error loading component
            console.log(errorDescription)
            break

        case -2: // Error load DocsAPI from http://documentserver/
            console.log(errorDescription)
            break

        case -3: // DocsAPI is not defined
            console.log(errorDescription)
            break
    }
}

function onDocumentReady(event: any) {
    console.log('Document is loaded')
}

const getDocumentType = (ext: string) => {
    if (['docx', 'doc', 'odt'].includes(ext)) {
        return 'word'
    }
    if (['xlsx', 'xls', 'ods'].includes(ext)) {
        return 'cell'
    }
    if (['pptx', 'ppt', 'odp'].includes(ext)) {
        return 'slide'
    }
    return 'word'
}

function ReadOnlySingleFileUpload({
    mode,
    fileName,
    downloadUrl,
    diffFileName,
    diffDownloadUrl,
    onFileIconClick
}: ReadOnlySingleFileUploadProps) {
    const [visible, setVisible] = useState<boolean>(false)

    const url = `${window.location.origin}${downloadUrl}`

    const smartIcon = <FileIcon fileName={fileName} onFileIconClick={onFileIconClick} />

    const handleDownload = () => {
        setVisible(true)
        // пока отключено скачиваие по кнопке в инфо режиме
        // downloadUrl && CxBoxApiInstance.saveBlob(downloadUrl, fileName)
    }

    const handleDiffDownload = () => {
        diffDownloadUrl && CxBoxApiInstance.saveBlob(diffDownloadUrl, diffFileName)
    }

    if (mode === 'snapshot') {
        if ((diffDownloadUrl || downloadUrl) && diffDownloadUrl !== downloadUrl) {
            return (
                <div className={cn(styles.snapshot)}>
                    {smartIcon}
                    <div>
                        {diffDownloadUrl && (
                            <div>
                                <span className={cn(styles.viewLink, styles.prevValue)}>
                                    <Button type="link" removeIndentation={true} onClick={handleDiffDownload}>
                                        <span>{trimString(diffFileName)}</span>
                                    </Button>
                                </span>
                            </div>
                        )}
                        {downloadUrl && (
                            <div>
                                <span className={cn(styles.viewLink, styles.newValue)}>
                                    <Button type="link" removeIndentation={true} onClick={handleDownload}>
                                        <span>{trimString(fileName)}</span>
                                    </Button>
                                </span>
                            </div>
                        )}
                    </div>
                </div>
            )
        }
    }

    return (
        <div className={styles.root}>
            {smartIcon}
            <Button className={styles.readOnlyFileButton} type="link" removeIndentation={true} onClick={handleDownload}>
                <span className={styles.viewLink}>{downloadUrl && <span>{trimString(fileName)}</span>}</span>
            </Button>

            <Popup width={840} visible={visible} closable={true} onCancel={() => setVisible(false)} footer={null}>
                <PopupContent>
                    <DocumentEditor
                        id="documentEditor"
                        height={'700px'}
                        documentServerUrl="http://localhost:8080/" // адрес сервера документов или onlyoffice или r7-office, сделать динамическим
                        config={{
                            // token: 'anyTokenForDocumentServer', токен для сервера документов, если будет включена настройка
                            document: {
                                fileType: getExtension(fileName) || 'docx', // расширение из title файла
                                key: `file-${Date.now()}`, // уникальный ключ, возможно лучше выставлять разный, иначе может открыться кэшированная на сервере доков версия
                                title: fileName,
                                url: `http://host.docker.internal:3001/proxy-file?url=${url}&token=${keycloak.token}` // временно прокси бэк - для получения файла с токеном
                                // пока только localhost сделать динамическим
                            },
                            documentType: getDocumentType(getExtension(fileName) || ''), // функция для получения типа по расширению 'word' / 'cell'
                            editorConfig: {
                                lang: 'ru', // язык системы
                                mode: 'edit', // только просмотр 'view'
                                callbackUrl: 'http://host.docker.internal:3001/callback', // заглушка что успешно сохранили файл (временно прокси бэк)
                                customization: {
                                    autosave: false,
                                    forcesave: true //  при нажатии на сохранить сразу вызовет callbackUrl, при false вызовет callbackUrl непредсказуемо
                                },
                                user: {
                                    id: 'user',
                                    name: 'user' // отображается в кнопке с профилем, можно выводить имя текущего пользователя
                                }
                            }
                        }}
                        events_onDocumentReady={onDocumentReady}
                        onLoadComponentError={onLoadComponentError}
                    />
                </PopupContent>
            </Popup>
        </div>
    )
}

export default React.memo(ReadOnlySingleFileUpload)
