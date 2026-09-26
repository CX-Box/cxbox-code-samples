package org.demo.documentation.widgets.line2d.color;

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
public class MyExample4247Service extends AnySourceVersionAwareResponseService<MyExample4247DTO, MyExample4247DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4247Meta> meta = MyExample4247Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4247Dao> dao = MyExample4247Dao.class;

	@Override
	protected CreateResult<MyExample4247DTO> doCreateEntity(MyExample4247DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4247DTO> doUpdateEntity(MyExample4247DTO entity, MyExample4247DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
