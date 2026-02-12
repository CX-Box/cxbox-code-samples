package org.demo.documentation.widgets.headerwidget.colortitle;

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
public class MyExample5024Service extends VersionAwareResponseService<MyExample5024DTO, MyEntity5024> {

	private final MyEntity5024Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5024Meta> meta = MyExample5024Meta.class;

	@Override
	protected CreateResult<MyExample5024DTO> doCreateEntity(MyEntity5024 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5024DTO> doUpdateEntity(MyEntity5024 entity, MyExample5024DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5024DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample5024DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5024DTO> getActions() {
		return Actions.<MyExample5024DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}