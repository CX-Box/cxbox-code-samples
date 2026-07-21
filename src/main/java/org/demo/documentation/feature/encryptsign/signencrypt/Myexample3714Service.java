package org.demo.documentation.feature.encryptsign.signencrypt;


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
import org.demo.documentation.feature.encryptsign.signencrypt.enums.StatusSignEncryptEnum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3714Service extends VersionAwareResponseService<Myexample3714DTO, Myexample3714> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3714MetaBuilder> meta = Myexample3714MetaBuilder.class;

	private final MyEntity3714Repository myexample3714Repository;

	private final CxboxFileService cxboxFileService;

	@Override
	protected Specification<Myexample3714> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3714DTO> doCreateEntity(Myexample3714 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3714Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3714DTO> doUpdateEntity(Myexample3714 entity, Myexample3714DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3714DTO_.status, entity::setStatus);
		setIfChanged(data, Myexample3714DTO_.fileSignId, entity::setFileSignId);
		setIfChanged(data, Myexample3714DTO_.fileSign, entity::setFileSign);
		setIfChanged(data, Myexample3714DTO_.fileEncryptId, entity::setFileEncryptId);
		setIfChanged(data, Myexample3714DTO_.fileEncrypt, entity::setFileEncrypt);
		setIfChanged(data, Myexample3714DTO_.fileEncryptAndSignId, entity::setFileEncryptAndSignId);
		setIfChanged(data, Myexample3714DTO_.fileEncryptAndSign, entity::setFileEncryptAndSign);
		setIfChanged(data, Myexample3714DTO_.fileId, entity::setFileId);
		setIfChanged(data, Myexample3714DTO_.file, entity::setFile);
		if (data.isFieldChanged(Myexample3714DTO_.fileEncrypt)
				&& data.isFieldChanged(Myexample3714DTO_.fileSign) &&
				!data.getFileSign().isEmpty() && !data.getFileEncrypt().isEmpty()) {
			String zipName = entity.getFile().substring(0, entity.getFile().indexOf('.')) + ".zip";
			String uploadId = createAndUploadZip(data, entity, zipName);
			entity.setFileEncryptAndSignId(uploadId);
			entity.setFileEncryptAndSign(zipName);
		}
		return new ActionResultDTO<>(entityToDto(bc, myexample3714Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}
	// --8<-- [start:getActions]
	@Override
	public Actions<Myexample3714DTO> getActions() {
		return Actions.<Myexample3714DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("documentSignEncrypt", "Document Sign Encrypt")
						.scope(ActionScope.RECORD)
						.available(bc -> {
							return true;
						})
						.invoker((bc, dto) -> {
							Optional<Myexample3714> myexample = myexample3714Repository.findById(Long.valueOf(dto.getId()));
							myexample.ifPresent(e -> {
								e.setStatus(StatusSignEncryptEnum.SIGN_ENCRYPT);
								myexample3714Repository.save(myexample.get());
							});
							return new ActionResultDTO<Myexample3714DTO>()
									.setAction(PostAction.showMessage(
											MessageType.INFO, "Action documentSignEncrypt was invoked"
									));
						})
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}
	// --8<-- [end:getActions]
	public String createAndUploadZip(Myexample3714DTO dto, Myexample3714 entity, String zipName) {
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
