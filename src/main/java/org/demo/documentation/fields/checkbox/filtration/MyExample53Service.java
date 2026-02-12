package org.demo.documentation.fields.checkbox.filtration;

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
public class MyExample53Service extends VersionAwareResponseService<MyExample53DTO, MyEntity53> {

	private final MyEntity53Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample53Meta> meta = MyExample53Meta.class;

	@Override
	protected CreateResult<MyExample53DTO> doCreateEntity(MyEntity53 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample53DTO> doUpdateEntity(MyEntity53 entity, MyExample53DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample53DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample53DTO> getActions() {
		return Actions.<MyExample53DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}