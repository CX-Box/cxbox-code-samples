package org.demo.documentation.widgets.cardlist.status;

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
public class MyExample5305Service extends VersionAwareResponseService<MyExample5305DTO, MyEntity5305> {

	private final MyEntity5305Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5305Meta> meta = MyExample5305Meta.class;

	@Override
	protected CreateResult<MyExample5305DTO> doCreateEntity(MyEntity5305 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5305DTO> doUpdateEntity(MyEntity5305 entity, MyExample5305DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5305DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5305DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5305DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5305DTO_.customFieldDescription, entity::setCustomFieldDescription);
		setIfChanged(data, MyExample5305DTO_.status, entity::setStatus);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5305DTO> getActions() {
		return Actions.<MyExample5305DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
