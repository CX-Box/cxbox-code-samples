package org.demo.documentation.fields.percent.ro;

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
public class MyExample4Service extends VersionAwareResponseService<MyExample4DTO, MyEntity4> {

	private final MyEntity4Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4Meta> meta = MyExample4Meta.class;

    @Override
	protected CreateResult<MyExample4DTO> doCreateEntity(MyEntity4 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample4DTO> doUpdateEntity(MyEntity4 entity, MyExample4DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample4DTO> getActions() {
		return Actions.<MyExample4DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}