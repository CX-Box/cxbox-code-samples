package org.demo.documentation.widgets.cardcarousellist.title;

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
public class MyExample5061Service extends VersionAwareResponseService<MyExample5061DTO, MyEntity5061> {

	private final MyEntity5061Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5061Meta> meta = MyExample5061Meta.class;

	@Override
	protected CreateResult<MyExample5061DTO> doCreateEntity(MyEntity5061 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5061DTO> doUpdateEntity(MyEntity5061 entity, MyExample5061DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5061DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5061DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5061DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5061DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5061DTO> getActions() {
		return Actions.<MyExample5061DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
