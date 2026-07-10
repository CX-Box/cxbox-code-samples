package org.demo.documentation.widgets.ringprogress.icon;

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
public class MyExample4214Service extends AnySourceVersionAwareResponseService<MyExample4214DTO, MyExample4214DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4214Meta> meta = MyExample4214Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4214Dao> dao = MyExample4214Dao.class;

	@Override
	protected CreateResult<MyExample4214DTO> doCreateEntity(MyExample4214DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4214DTO> doUpdateEntity(MyExample4214DTO entity, MyExample4214DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
