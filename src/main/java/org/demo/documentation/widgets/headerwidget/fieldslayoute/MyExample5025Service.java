package org.demo.documentation.widgets.headerwidget.fieldslayoute;

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
public class MyExample5025Service extends VersionAwareResponseService<MyExample5025DTO, MyEntity5025> {

	private final MyEntity5025Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5025Meta> meta = MyExample5025Meta.class;

	@Override
	protected CreateResult<MyExample5025DTO> doCreateEntity(MyEntity5025 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5025DTO> doUpdateEntity(MyEntity5025 entity, MyExample5025DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5025DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5025DTO> getActions() {
		return Actions.<MyExample5025DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}