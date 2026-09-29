package org.demo.documentation.widgets.line2d.tooltip;

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
public class MyExample4246Service extends AnySourceVersionAwareResponseService<MyExample4246DTO, MyExample4246DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4246Meta> meta = MyExample4246Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4246Dao> dao = MyExample4246Dao.class;

	@Override
	protected CreateResult<MyExample4246DTO> doCreateEntity(MyExample4246DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4246DTO> doUpdateEntity(MyExample4246DTO entity, MyExample4246DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
