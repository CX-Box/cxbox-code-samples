package org.demo.documentation.fields.percent.colorconst;

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
public class MyExample3Service extends VersionAwareResponseService<MyExample3DTO, MyEntity3> {

	private final MyEntity3Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3Meta> meta = MyExample3Meta.class;

	@Override
	protected CreateResult<MyExample3DTO> doCreateEntity(MyEntity3 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3DTO> doUpdateEntity(MyEntity3 entity, MyExample3DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3DTO> getActions() {
		return Actions.<MyExample3DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}