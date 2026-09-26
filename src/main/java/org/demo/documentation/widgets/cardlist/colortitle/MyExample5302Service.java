package org.demo.documentation.widgets.cardlist.colortitle;

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
public class MyExample5302Service extends VersionAwareResponseService<MyExample5302DTO, MyEntity5302> {

	private final MyEntity5302Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5302Meta> meta = MyExample5302Meta.class;

	@Override
	protected CreateResult<MyExample5302DTO> doCreateEntity(MyEntity5302 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5302DTO> doUpdateEntity(MyEntity5302 entity, MyExample5302DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5302DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5302DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5302DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5302DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5302DTO> getActions() {
		return Actions.<MyExample5302DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
