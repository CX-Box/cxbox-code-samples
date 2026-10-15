package org.demo.documentation.feature.encryptsign.largefile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample10000Service extends VersionAwareResponseService<Myexample10000DTO, Myexample10000> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample10000MetaBuilder> meta = Myexample10000MetaBuilder.class;

	private final MyEntity10000Repository repository;

	@Override
	protected CreateResult<Myexample10000DTO> doCreateEntity(Myexample10000 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample10000DTO> doUpdateEntity(Myexample10000 entity, Myexample10000DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample10000DTO_.description, entity::setDescription);
		setIfChanged(data, Myexample10000DTO_.fileId, entity::setFileId);
		setIfChanged(data, Myexample10000DTO_.file, entity::setFile);
		setIfChanged(data, Myexample10000DTO_.fileSignId, entity::setFileSignId);
		setIfChanged(data, Myexample10000DTO_.fileSign, entity::setFileSign);
		setIfChanged(data, Myexample10000DTO_.fileEncryptId, entity::setFileEncryptId);
		setIfChanged(data, Myexample10000DTO_.fileEncrypt, entity::setFileEncrypt);
		return new ActionResultDTO<>(entityToDto(bc, repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	// The frontend signs and/or encrypts the file and saves the result files before the action:
	// the action only records which operation was the last one
	@Override
	public Actions<Myexample10000DTO> getActions() {
		return Actions.<Myexample10000DTO>builder()
				.create(crt -> crt.text("Create"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("documentSign", "Sign")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> lastOperation(dto, "Sign"))
				)
				.action(act -> act
						.action("documentEncrypt", "Encrypt")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> lastOperation(dto, "Encrypt"))
				)
				.action(act -> act
						.action("documentSignEncrypt", "Sign and encrypt")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> lastOperation(dto, "Sign and encrypt"))
				)
				.action(act -> act
						.action("documentEncryptSign", "Encrypt and sign")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> lastOperation(dto, "Encrypt and sign"))
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}

	private ActionResultDTO<Myexample10000DTO> lastOperation(Myexample10000DTO dto, String operation) {
		repository.findById(Long.valueOf(dto.getId())).ifPresent(entity -> {
			entity.setLastOperation(operation);
			repository.save(entity);
		});
		return new ActionResultDTO<Myexample10000DTO>()
				.setAction(PostAction.showMessage(MessageType.INFO, operation + ": done"));
	}

}
