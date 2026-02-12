package org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent;

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
public class MyExample5030Service extends VersionAwareResponseService<MyExample5030DTO, MyEntity5030> {

	private final MyEntity5030Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5030Meta> meta = MyExample5030Meta.class;

	@Override
	protected CreateResult<MyExample5030DTO> doCreateEntity(MyEntity5030 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5030DTO> doUpdateEntity(MyEntity5030 entity, MyExample5030DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5030DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5030DTO> getActions() {
		return Actions.<MyExample5030DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}