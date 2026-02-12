package org.demo.documentation.fields.percent.placeholder;

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
public class MyExample7Service extends VersionAwareResponseService<MyExample7DTO, MyEntity7> {

	private final MyEntity7Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample7Meta> meta = MyExample7Meta.class;

	@Override
	protected CreateResult<MyExample7DTO> doCreateEntity(MyEntity7 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample7DTO> doUpdateEntity(MyEntity7 entity, MyExample7DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample7DTO> getActions() {
		return Actions.<MyExample7DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}