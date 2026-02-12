package org.demo.documentation.widgets.statsblock.base.defaultfields;

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
public class MyExample4203Service extends AnySourceVersionAwareResponseService<MyExample4203DTO, MyExample4203DTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4203Meta> meta = MyExample4203Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4203Dao> dao = MyExample4203Dao.class;

	@Override
	protected CreateResult<MyExample4203DTO> doCreateEntity(MyExample4203DTO entity, BusinessComponent bc) {

		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4203DTO> doUpdateEntity(MyExample4203DTO entity, MyExample4203DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
