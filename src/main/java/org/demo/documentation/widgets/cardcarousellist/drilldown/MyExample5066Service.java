package org.demo.documentation.widgets.cardcarousellist.drilldown;

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
public class MyExample5066Service extends VersionAwareResponseService<MyExample5066DTO, MyEntity5066> {

	private final MyEntity5066Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5066Meta> meta = MyExample5066Meta.class;

	@Override
	protected CreateResult<MyExample5066DTO> doCreateEntity(MyEntity5066 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5066DTO> doUpdateEntity(MyEntity5066 entity, MyExample5066DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5066DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5066DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5066DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5066DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5066DTO> getActions() {
		return Actions.<MyExample5066DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
