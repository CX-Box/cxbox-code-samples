package org.demo.documentation.widgets.statsblock.drilldown.parentchild;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample4127Service extends AnySourceVersionAwareResponseService<MyExample4127DTO, MyExample4127DTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4127Meta> meta = MyExample4127Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4127Dao> dao = MyExample4127Dao.class;

	@Override
	protected CreateResult<MyExample4127DTO> doCreateEntity(MyExample4127DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4127DTO> doUpdateEntity(MyExample4127DTO entity, MyExample4127DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample4127DTO> getActions() {
		return Actions.<MyExample4127DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}