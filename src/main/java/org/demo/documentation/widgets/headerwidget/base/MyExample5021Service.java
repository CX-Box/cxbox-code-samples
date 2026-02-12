package org.demo.documentation.widgets.headerwidget.base;

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
public class MyExample5021Service extends VersionAwareResponseService<MyExample5021DTO, MyEntity5021> {

	private final MyEntity5021Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5021Meta> meta = MyExample5021Meta.class;

	@Override
	protected CreateResult<MyExample5021DTO> doCreateEntity(MyEntity5021 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5021DTO> doUpdateEntity(MyEntity5021 entity, MyExample5021DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5021DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5021DTO> getActions() {
		return Actions.<MyExample5021DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}