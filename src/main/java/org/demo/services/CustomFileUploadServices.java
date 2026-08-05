package org.demo.services;

import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomFileUploadServices {

	public static final String FILENAME_FIELD = "filename";

	private final MinioClient minioClient;
	private final String defaultBucketName;

	public CustomFileUploadServices(
			MinioClient minioClient,
			@Value("${minio.bucket.name}") String defaultBucketName) {
		this.minioClient = minioClient;
		this.defaultBucketName = defaultBucketName;
	}

	@SneakyThrows
	public CxboxResponseDTO<FileUploadDto> uploadTxt(String fileName) {
		String name = "FILE_" + fileName + ".txt";

		byte[] content = "Test data".getBytes(StandardCharsets.UTF_8);

		return uploadFile(
				name,
				"text/plain",
				content
		);
	}

	@SneakyThrows
	public CxboxResponseDTO<FileUploadDto> uploadPdf(String fileName) {
		String name = "FILE_" + fileName + ".pdf";

		try (
				PDDocument document = new PDDocument();
				ByteArrayOutputStream output = new ByteArrayOutputStream()
		) {
			PDPage page = new PDPage();
			document.addPage(page);

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
				contentStream.beginText();
				contentStream.setFont(PDType1Font.HELVETICA, 12);
				contentStream.newLineAtOffset(100, 700);
				contentStream.showText("Test data");
				contentStream.endText();
			}

			document.save(output);

			return uploadFile(
					name,
					"application/pdf",
					output.toByteArray()
			);
		}
	}

	@SneakyThrows
	private CxboxResponseDTO<FileUploadDto> uploadFile(
			String fileName,
			String contentType,
			byte[] content
	) {

		ObjectWriteResponse response = minioClient.putObject(
				PutObjectArgs.builder()
						.bucket(defaultBucketName)
						.object(UUID.randomUUID().toString())
						.contentType(contentType)
						.userMetadata(Map.of(FILENAME_FIELD, fileName))
						.stream(
								new ByteArrayInputStream(content),
								Long.valueOf(content.length),
								-1L
						)
						.build()
		);

		return new CxboxResponseDTO<FileUploadDto>()
				.setData(
						new FileUploadDto(
								response.object(),
								fileName,
								contentType
						)
				);
	}
}