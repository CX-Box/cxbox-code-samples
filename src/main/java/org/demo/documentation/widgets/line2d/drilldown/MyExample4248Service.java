package org.demo.documentation.widgets.line2d.drilldown;

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
public class MyExample4248Service extends AnySourceVersionAwareResponseService<MyExample4248DTO, MyExample4248DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4248Meta> meta = MyExample4248Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4248Dao> dao = MyExample4248Dao.class;

	@Override
	protected CreateResult<MyExample4248DTO> doCreateEntity(MyExample4248DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4248DTO> doUpdateEntity(MyExample4248DTO entity, MyExample4248DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
