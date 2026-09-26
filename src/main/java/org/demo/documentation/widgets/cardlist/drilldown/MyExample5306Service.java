package org.demo.documentation.widgets.cardlist.drilldown;

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
public class MyExample5306Service extends VersionAwareResponseService<MyExample5306DTO, MyEntity5306> {

	private final MyEntity5306Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5306Meta> meta = MyExample5306Meta.class;

	@Override
	protected CreateResult<MyExample5306DTO> doCreateEntity(MyEntity5306 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5306DTO> doUpdateEntity(MyEntity5306 entity, MyExample5306DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5306DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5306DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5306DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5306DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5306DTO> getActions() {
		return Actions.<MyExample5306DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
