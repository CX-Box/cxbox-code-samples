package org.demo.documentation.fields.richtext.validationconfirm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample433Service extends VersionAwareResponseService<MyExample433DTO, MyEntity433> {

	private final MyEntity433Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample433Meta> meta = MyExample433Meta.class;

	@Override
	protected CreateResult<MyExample433DTO> doCreateEntity(MyEntity433 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample433DTO> doUpdateEntity(MyEntity433 entity, MyExample433DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample433DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample433DTO> getActions() {
		return Actions.<MyExample433DTO>builder()
				.action(act -> act
						.action("save", "save")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to save the value?")
						)))
				.build();
	}
	// --8<-- [end:getActions]

}