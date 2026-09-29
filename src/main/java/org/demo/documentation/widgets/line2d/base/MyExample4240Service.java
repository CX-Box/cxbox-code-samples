package org.demo.documentation.widgets.line2d.base;

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
public class MyExample4240Service extends AnySourceVersionAwareResponseService<MyExample4240DTO, MyExample4240DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4240Meta> meta = MyExample4240Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4240Dao> dao = MyExample4240Dao.class;

	@Override
	protected CreateResult<MyExample4240DTO> doCreateEntity(MyExample4240DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4240DTO> doUpdateEntity(MyExample4240DTO entity, MyExample4240DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
