package org.demo.documentation.widgets.column2d.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample4258Service extends AnySourceVersionAwareResponseService<MyExample4258DTO, MyExample4258DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4258Meta> meta = MyExample4258Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4258Dao> dao = MyExample4258Dao.class;

	@Override
	protected CreateResult<MyExample4258DTO> doCreateEntity(MyExample4258DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4258DTO> doUpdateEntity(MyExample4258DTO entity, MyExample4258DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
