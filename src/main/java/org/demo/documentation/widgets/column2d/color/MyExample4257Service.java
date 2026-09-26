package org.demo.documentation.widgets.column2d.color;

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
public class MyExample4257Service extends AnySourceVersionAwareResponseService<MyExample4257DTO, MyExample4257DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4257Meta> meta = MyExample4257Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4257Dao> dao = MyExample4257Dao.class;

	@Override
	protected CreateResult<MyExample4257DTO> doCreateEntity(MyExample4257DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4257DTO> doUpdateEntity(MyExample4257DTO entity, MyExample4257DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
