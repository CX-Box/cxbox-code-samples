package org.demo.documentation.widgets.filepreview.colortitle;

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
public class MyExample5004Service extends VersionAwareResponseService<MyExample5004DTO, MyEntity5004> {

	private final MyEntity5004Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5004Meta> meta = MyExample5004Meta.class;

	@Override
	protected CreateResult<MyExample5004DTO> doCreateEntity(MyEntity5004 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5004DTO> doUpdateEntity(MyEntity5004 entity, MyExample5004DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5004DTO_.customFieldId, entity::setCustomFieldId);
		setIfChanged(data, MyExample5004DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5004DTO> getActions() {
		return Actions.<MyExample5004DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}