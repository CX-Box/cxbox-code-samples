package org.demo.documentation.widgets.list.actions.edit.withwidget;

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
public class MyExample3065Service extends VersionAwareResponseService<MyExample3065DTO, MyEntity3065> {

	private final MyEntity3065Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3065Meta> meta = MyExample3065Meta.class;

	@Override
	protected CreateResult<MyExample3065DTO> doCreateEntity(MyEntity3065 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3065DTO> doUpdateEntity(MyEntity3065 entity, MyExample3065DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3065DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3065DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3065DTO> getActions() {
		return Actions.<MyExample3065DTO>builder()
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("edit", "Edit"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}


}

