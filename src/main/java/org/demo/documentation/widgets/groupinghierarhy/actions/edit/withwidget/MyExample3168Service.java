package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3168Service extends VersionAwareResponseService<MyExample3168DTO, MyEntity3168> {

	private final MyEntity3168Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3168Meta> meta = MyExample3168Meta.class;

	@Override
	protected CreateResult<MyExample3168DTO> doCreateEntity(MyEntity3168 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3168DTO> doUpdateEntity(MyEntity3168 entity, MyExample3168DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3168DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3168DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3168DTO> getActions() {
		return Actions.<MyExample3168DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]


}

