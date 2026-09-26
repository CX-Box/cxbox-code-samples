package org.demo.documentation.widgets.cardlist.title;

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
public class MyExample5301Service extends VersionAwareResponseService<MyExample5301DTO, MyEntity5301> {

	private final MyEntity5301Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5301Meta> meta = MyExample5301Meta.class;

	@Override
	protected CreateResult<MyExample5301DTO> doCreateEntity(MyEntity5301 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5301DTO> doUpdateEntity(MyEntity5301 entity, MyExample5301DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5301DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5301DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5301DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5301DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5301DTO> getActions() {
		return Actions.<MyExample5301DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
