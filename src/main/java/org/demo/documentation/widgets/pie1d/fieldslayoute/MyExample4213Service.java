package org.demo.documentation.widgets.pie1d.fieldslayoute;

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
public class MyExample4213Service extends AnySourceVersionAwareResponseService<MyExample4213DTO, MyExample4213DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4213Meta> meta = MyExample4213Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4213Dao> dao = MyExample4213Dao.class;

	@Override
	protected CreateResult<MyExample4213DTO> doCreateEntity(MyExample4213DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4213DTO> doUpdateEntity(MyExample4213DTO entity, MyExample4213DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
