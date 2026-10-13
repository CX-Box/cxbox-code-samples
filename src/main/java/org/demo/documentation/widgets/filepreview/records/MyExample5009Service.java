package org.demo.documentation.widgets.filepreview.records;

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
public class MyExample5009Service extends VersionAwareResponseService<MyExample5009DTO, MyEntity5009> {

	private final MyEntity5009Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5009Meta> meta = MyExample5009Meta.class;

	@Override
	protected CreateResult<MyExample5009DTO> doCreateEntity(MyEntity5009 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5009DTO> doUpdateEntity(MyEntity5009 entity, MyExample5009DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5009DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5009DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5009DTO_.documentId, entity::setDocumentId);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5009DTO> getActions() {
		return Actions.<MyExample5009DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
