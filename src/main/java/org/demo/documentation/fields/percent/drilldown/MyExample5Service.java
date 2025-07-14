package org.demo.documentation.fields.percent.drilldown;

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
public class MyExample5Service extends VersionAwareResponseService<MyExample5DTO, MyEntity5> {

	private final MyEntity5Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5Meta> meta = MyExample5Meta.class;

    @Override
	protected CreateResult<MyExample5DTO> doCreateEntity(MyEntity5 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample5DTO> doUpdateEntity(MyEntity5 entity, MyExample5DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5DTO> getActions() {
		return Actions.<MyExample5DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}