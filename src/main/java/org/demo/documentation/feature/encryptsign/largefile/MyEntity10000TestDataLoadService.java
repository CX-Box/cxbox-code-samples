package org.demo.documentation.feature.encryptsign.largefile;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileUploadServices;
import org.springframework.stereotype.Service;

/**
 * Small files at the edges of the 3 MB parts the frontend passes to the CryptoPro plugin.
 * Large files (50–500 MB) are uploaded by hand through the File field: they would slow down every start.
 */
@Service
@RequiredArgsConstructor
public class MyEntity10000TestDataLoadService {

	private static final int MB = 1024 * 1024;

	private static final int PART = 3 * MB;

	private final MyEntity10000Repository repository;

	private final InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		save("PDF, 1 page", customFileUploadServices.uploadPdf("10000"));
		save("0 B", upload("empty.bin", 0));
		save("1 MB", upload("1mb.bin", MB));
		save("3 MB: exactly one part", upload("3mb.bin", PART));
		save("3 MB + 1 B: two parts", upload("3mb-plus-1b.bin", PART + 1));
	}

	private CxboxResponseDTO<FileUploadDto> upload(String name, int size) {
		byte[] content = new byte[size];
		new Random(size).nextBytes(content);
		return customFileUploadServices.uploadFile(name, "application/octet-stream", content);
	}

	private void save(String description, CxboxResponseDTO<FileUploadDto> file) {
		repository.save(new Myexample10000()
				.setDescription(description)
				.setFile(file.getData().getName())
				.setFileId(file.getData().getId()));
	}

}
