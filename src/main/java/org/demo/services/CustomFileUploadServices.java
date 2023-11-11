package org.demo.services;

import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.UUID;

@Service
public class CustomFileUploadServices {
    private final MinioClient minioClient;
    private final String defaultBucketName;
    public static final String FILENAME_FIELD = "filename";
    public static final int FIVE_MIB = 5242880;

    public CustomFileUploadServices(
            MinioClient minioClient,
            @Value("${minio.bucket.name}") String defaultBucketName) {
        this.minioClient = minioClient;
        this.defaultBucketName = defaultBucketName;
    }

    @SneakyThrows
    public CxboxResponseDTO<FileUploadDto> uploadTxt() {
        int min = 1000;
        int max = 9999;

        int randomNum = (int) (Math.random() * (max - min)) + min;
        String contentType = "text/plain";
        String name = "FILE_" + randomNum + ".txt";
        InputStream targetStream = new ByteArrayInputStream("Test data".getBytes());
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(PutObjectArgs
                .builder()
                .bucket(defaultBucketName)
                .object(UUID.randomUUID().toString())
                .contentType(contentType)
                .userMetadata(Collections.singletonMap(FILENAME_FIELD, name))
                .stream(targetStream, -1, FIVE_MIB)
                .build()
        );
        String id = objectWriteResponse.object();
        return new CxboxResponseDTO<FileUploadDto>()
                .setData(new FileUploadDto(id, name, contentType));
    }

}
