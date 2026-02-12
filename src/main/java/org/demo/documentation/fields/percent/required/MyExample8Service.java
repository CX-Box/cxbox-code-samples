package org.demo.documentation.fields.percent.required;

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
public class MyExample8Service extends VersionAwareResponseService<MyExample8DTO, MyEntity8> {

	private final MyEntity8Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample8Meta> meta = MyExample8Meta.class;

	@Override
	protected CreateResult<MyExample8DTO> doCreateEntity(MyEntity8 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample8DTO> doUpdateEntity(MyEntity8 entity, MyExample8DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample8DTO> getActions() {
		return Actions.<MyExample8DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}