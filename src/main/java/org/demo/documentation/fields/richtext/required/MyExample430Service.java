package org.demo.documentation.fields.richtext.required;

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
public class MyExample430Service extends VersionAwareResponseService<MyExample430DTO, MyEntity430> {

	private final MyEntity430Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample430Meta> meta = MyExample430Meta.class;

	@Override
	protected CreateResult<MyExample430DTO> doCreateEntity(MyEntity430 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample430DTO> doUpdateEntity(MyEntity430 entity, MyExample430DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample430DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample430DTO> getActions() {
		return Actions.<MyExample430DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}