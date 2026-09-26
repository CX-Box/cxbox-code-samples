package org.demo.documentation.widgets.cardcarousellist.colortitle;

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
public class MyExample5062Service extends VersionAwareResponseService<MyExample5062DTO, MyEntity5062> {

	private final MyEntity5062Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5062Meta> meta = MyExample5062Meta.class;

	@Override
	protected CreateResult<MyExample5062DTO> doCreateEntity(MyEntity5062 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5062DTO> doUpdateEntity(MyEntity5062 entity, MyExample5062DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5062DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5062DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5062DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5062DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5062DTO> getActions() {
		return Actions.<MyExample5062DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
