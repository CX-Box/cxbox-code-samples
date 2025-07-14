package org.demo.documentation.fields.percent.filtration;

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
public class MyExample6Service extends VersionAwareResponseService<MyExample6DTO, MyEntity6> {

	private final MyEntity6Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample6Meta> meta = MyExample6Meta.class;

    @Override
	protected CreateResult<MyExample6DTO> doCreateEntity(MyEntity6 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample6DTO> doUpdateEntity(MyEntity6 entity, MyExample6DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample6DTO> getActions() {
		return Actions.<MyExample6DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}