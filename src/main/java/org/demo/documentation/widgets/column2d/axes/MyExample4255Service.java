package org.demo.documentation.widgets.column2d.axes;

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
public class MyExample4255Service extends AnySourceVersionAwareResponseService<MyExample4255DTO, MyExample4255DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4255Meta> meta = MyExample4255Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4255Dao> dao = MyExample4255Dao.class;

	@Override
	protected CreateResult<MyExample4255DTO> doCreateEntity(MyExample4255DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4255DTO> doUpdateEntity(MyExample4255DTO entity, MyExample4255DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
