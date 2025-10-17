package org.demo.conf.cxbox.customization.file;

import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.cxbox.core.file.controller.AbstractCxboxFileController;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.cxbox.core.file.dto.FileUploadDto;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.cxbox.core.config.properties.APIProperties.CXBOX_API_PATH_SPEL;

@RestController
@RequestMapping(CXBOX_API_PATH_SPEL + "/file")
public class FileController extends AbstractCxboxFileController {
    @SneakyThrows

    @Override
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CxboxResponseDTO<FileUploadDto> upload(MultipartFile file, String source) {
        throw new RuntimeException("My error");

        }

}
