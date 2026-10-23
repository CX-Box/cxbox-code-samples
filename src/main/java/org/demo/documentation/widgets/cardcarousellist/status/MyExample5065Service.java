package org.demo.documentation.widgets.cardcarousellist.status;

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
public class MyExample5065Service extends VersionAwareResponseService<MyExample5065DTO, MyEntity5065> {

	private final MyEntity5065Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5065Meta> meta = MyExample5065Meta.class;

	@Override
	protected CreateResult<MyExample5065DTO> doCreateEntity(MyEntity5065 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5065DTO> doUpdateEntity(MyEntity5065 entity, MyExample5065DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5065DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5065DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5065DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5065DTO_.customFieldDescription, entity::setCustomFieldDescription);
		setIfChanged(data, MyExample5065DTO_.status, entity::setStatus);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5065DTO> getActions() {
		return Actions.<MyExample5065DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
