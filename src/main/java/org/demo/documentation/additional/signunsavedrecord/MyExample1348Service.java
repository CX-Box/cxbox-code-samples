package org.demo.documentation.additional.signunsavedrecord;

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
public class MyExample1348Service extends VersionAwareResponseService<MyExample1348DTO, MyEntity1348> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample1348Meta> meta = MyExample1348Meta.class;

	private final MyEntity1348Repository repository;

	@Override
	protected CreateResult<MyExample1348DTO> doCreateEntity(MyEntity1348 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExample1348DTO> doUpdateEntity(MyEntity1348 entity, MyExample1348DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample1348DTO_.file, entity::setFile);
		setIfChanged(data, MyExample1348DTO_.fileId, entity::setFileId);
		setIfChanged(data, MyExample1348DTO_.fileSign, entity::setFileSign);
		setIfChanged(data, MyExample1348DTO_.fileSignId, entity::setFileSignId);
		setIfChanged(data, MyExample1348DTO_.fileEncrypt, entity::setFileEncrypt);
		setIfChanged(data, MyExample1348DTO_.fileEncryptId, entity::setFileEncryptId);
		setIfChanged(data, MyExample1348DTO_.notes, entity::setNotes);
		return new ActionResultDTO<>(entityToDto(bc, repository.save(entity)));
	}

	@Override
	public Actions<MyExample1348DTO> getActions() {
		return Actions.<MyExample1348DTO>builder()
				.create(crt -> crt.text("Create"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("documentEncryptSign", "Document Sign Encrypt")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> {
							repository.findById(bc.getIdAsLong()).ifPresent(entity -> repository.save(entity.setSigned(true)));
							return new ActionResultDTO<MyExample1348DTO>()
									.setAction(PostAction.showMessage(MessageType.INFO, "Action documentEncryptSign was invoked"));
						})
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}

}
