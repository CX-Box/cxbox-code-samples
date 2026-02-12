package org.demo.documentation.fields.text.colorconst;

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
public class MyExample42Service extends VersionAwareResponseService<MyExample42DTO, MyEntity42> {

	private final MyEntity42Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample42Meta> meta = MyExample42Meta.class;

	@Override
	protected CreateResult<MyExample42DTO> doCreateEntity(MyEntity42 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample42DTO> doUpdateEntity(MyEntity42 entity, MyExample42DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample42DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample42DTO> getActions() {
		return Actions.<MyExample42DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}