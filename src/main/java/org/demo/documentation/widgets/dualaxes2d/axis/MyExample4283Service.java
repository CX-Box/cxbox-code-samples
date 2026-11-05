package org.demo.documentation.widgets.dualaxes2d.axis;

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
public class MyExample4283Service extends AnySourceVersionAwareResponseService<MyExample4283DTO, MyExample4283DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4283Meta> meta = MyExample4283Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4283Dao> dao = MyExample4283Dao.class;

	@Override
	protected CreateResult<MyExample4283DTO> doCreateEntity(MyExample4283DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4283DTO> doUpdateEntity(MyExample4283DTO entity, MyExample4283DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
