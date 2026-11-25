package org.demo.documentation.widgets.column2d.mode;

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
public class MyExample4277Service extends AnySourceVersionAwareResponseService<MyExample4277DTO, MyExample4277DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4277Meta> meta = MyExample4277Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4277Dao> dao = MyExample4277Dao.class;

	@Override
	protected CreateResult<MyExample4277DTO> doCreateEntity(MyExample4277DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4277DTO> doUpdateEntity(MyExample4277DTO entity, MyExample4277DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
