package org.demo.documentation.widgets.column2d.group;

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
public class MyExample4254Service extends AnySourceVersionAwareResponseService<MyExample4254DTO, MyExample4254DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4254Meta> meta = MyExample4254Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4254Dao> dao = MyExample4254Dao.class;

	@Override
	protected CreateResult<MyExample4254DTO> doCreateEntity(MyExample4254DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4254DTO> doUpdateEntity(MyExample4254DTO entity, MyExample4254DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
