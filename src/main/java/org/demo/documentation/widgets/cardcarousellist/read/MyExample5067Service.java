package org.demo.documentation.widgets.cardcarousellist.read;

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
public class MyExample5067Service extends VersionAwareResponseService<MyExample5067DTO, MyEntity5067> {

	private final MyEntity5067Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5067Meta> meta = MyExample5067Meta.class;

	@Override
	protected CreateResult<MyExample5067DTO> doCreateEntity(MyEntity5067 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5067DTO> doUpdateEntity(MyEntity5067 entity, MyExample5067DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5067DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5067DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5067DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5067DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5067DTO> getActions() {
		return Actions.<MyExample5067DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
