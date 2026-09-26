package org.demo.documentation.widgets.column2d.base;

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
public class MyExample4252Service extends AnySourceVersionAwareResponseService<MyExample4252DTO, MyExample4252DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4252Meta> meta = MyExample4252Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4252Dao> dao = MyExample4252Dao.class;

	@Override
	protected CreateResult<MyExample4252DTO> doCreateEntity(MyExample4252DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4252DTO> doUpdateEntity(MyExample4252DTO entity, MyExample4252DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
