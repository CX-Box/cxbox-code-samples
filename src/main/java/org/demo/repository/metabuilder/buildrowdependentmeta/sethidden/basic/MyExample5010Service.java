package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic;

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
public class MyExample5010Service extends VersionAwareResponseService<MyExample5010DTO, MyEntity5010> {

	private final MyEntity5010Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5010Meta> meta = MyExample5010Meta.class;

	@Override
	protected CreateResult<MyExample5010DTO> doCreateEntity(MyEntity5010 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5010DTO> doUpdateEntity(MyEntity5010 entity, MyExample5010DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5010DTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, MyExample5010DTO_.customField, entity::setCustomField);

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5010DTO> getActions() {
		return Actions.<MyExample5010DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}