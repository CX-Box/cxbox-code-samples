package org.demo.documentation.feature.encryptsign.encryptsign;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.cxbox.core.file.service.CxboxFileService;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3712Service extends VersionAwareResponseService<Myexample3712DTO, Myexample3712> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3712MetaBuilder> meta = Myexample3712MetaBuilder.class;

	private final MyEntity3712Repository myexample3712Repository;

	private final CxboxFileService cxboxFileService;

	@Override
	protected Specification<Myexample3712> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3712DTO> doCreateEntity(Myexample3712 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3712Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3712DTO> doUpdateEntity(Myexample3712 entity, Myexample3712DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3712DTO_.status, entity::setStatus);
		setIfChanged(data, Myexample3712DTO_.fileSignId, entity::setFileSignId);
		setIfChanged(data, Myexample3712DTO_.fileSign, entity::setFileSign);
		setIfChanged(data, Myexample3712DTO_.fileEncryptId, entity::setFileEncryptId);
		setIfChanged(data, Myexample3712DTO_.fileEncrypt, entity::setFileEncrypt);
		setIfChanged(data, Myexample3712DTO_.fileEncryptAndSignId, entity::setFileEncryptAndSignId);
		setIfChanged(data, Myexample3712DTO_.fileEncryptAndSign, entity::setFileEncryptAndSign);
		setIfChanged(data, Myexample3712DTO_.fileId, entity::setFileId);
		setIfChanged(data, Myexample3712DTO_.file, entity::setFile);
		if (data.isFieldChanged(Myexample3712DTO_.fileEncrypt)
				&& data.isFieldChanged(Myexample3712DTO_.fileSign) &&
				!data.getFileSign().isEmpty() && !data.getFileEncrypt().isEmpty()) {
			String zipName = entity.getFile().substring(0, entity.getFile().indexOf('.')) + ".zip";
			String uploadId = createAndUploadZip(data, entity, zipName);
			entity.setFileEncryptAndSignId(uploadId);
			entity.setFileEncryptAndSign(zipName);
		}
		return new ActionResultDTO<>(entityToDto(bc, myexample3712Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3712DTO> getActions() {
		return Actions.<Myexample3712DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("documentEncryptSign", "Document Encrypt Sign")
						.scope(ActionScope.RECORD)
						.available(bc -> {
							return true;
						})
						.invoker((bc, dto) -> {
							return new ActionResultDTO<Myexample3712DTO>()
									.setAction(PostAction.showMessage(
											MessageType.INFO, "Action documentEncryptSign was invoked"
									));
						})
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}

	public String createAndUploadZip(Myexample3712DTO dto, Myexample3712 entity, String zipName) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream zipOut = new ZipOutputStream(baos);

			addFile(zipOut, entity.getFile(), entity.getFile().getBytes());
			addFile(zipOut, dto.getFileSign(), dto.getFileSign().getBytes());
			addFile(zipOut, dto.getFileEncrypt(), dto.getFileEncrypt().getBytes());

			zipOut.finish();
			return cxboxFileService.upload(
					new FileDownloadDto(
							() -> new ByteArrayInputStream(baos.toByteArray()),
							baos.toByteArray().length,
							zipName,
							"application/zip"
					),
					null
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void addFile(ZipOutputStream zipOut, String fileName, byte[] content) throws IOException {
		if (content == null || content.length == 0) {
			return;
		}

		ZipEntry zipEntry = new ZipEntry(fileName);

		zipOut.putNextEntry(zipEntry);
		zipOut.write(content);
		zipOut.closeEntry();
	}

}
