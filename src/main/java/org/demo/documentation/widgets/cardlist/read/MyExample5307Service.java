package org.demo.documentation.widgets.cardlist.read;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5307Service extends VersionAwareResponseService<MyExample5307DTO, MyEntity5307> {

	private final MyEntity5307Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5307Meta> meta = MyExample5307Meta.class;

	@Override
	protected CreateResult<MyExample5307DTO> doCreateEntity(MyEntity5307 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5307DTO> doUpdateEntity(MyEntity5307 entity, MyExample5307DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5307DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5307DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5307DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5307DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5307DTO> getActions() {
		return Actions.<MyExample5307DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
