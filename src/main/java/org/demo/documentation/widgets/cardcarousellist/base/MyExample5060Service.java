package org.demo.documentation.widgets.cardcarousellist.base;

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
public class MyExample5060Service extends VersionAwareResponseService<MyExample5060DTO, MyEntity5060> {

	private final MyEntity5060Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5060Meta> meta = MyExample5060Meta.class;

	@Override
	protected CreateResult<MyExample5060DTO> doCreateEntity(MyEntity5060 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5060DTO> doUpdateEntity(MyEntity5060 entity, MyExample5060DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5060DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5060DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5060DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5060DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5060DTO> getActions() {
		return Actions.<MyExample5060DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
