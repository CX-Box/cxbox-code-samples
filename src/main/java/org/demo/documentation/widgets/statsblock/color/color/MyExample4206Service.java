package org.demo.documentation.widgets.statsblock.color.color;

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
public class MyExample4206Service extends AnySourceVersionAwareResponseService<MyExample4206DTO, MyExample4206DTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4206Meta> meta = MyExample4206Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4206Dao> dao = MyExample4206Dao.class;

	@Override
	protected CreateResult<MyExample4206DTO> doCreateEntity(MyExample4206DTO entity, BusinessComponent bc) {

		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4206DTO> doUpdateEntity(MyExample4206DTO entity, MyExample4206DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}