package org.demo.documentation.widgets.pie1d.base.customfields;

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
public class MyExample4211Service extends AnySourceVersionAwareResponseService<MyExample4211DTO, MyExample4211DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4211Meta> meta = MyExample4211Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4211Dao> dao = MyExample4211Dao.class;

	@Override
	protected CreateResult<MyExample4211DTO> doCreateEntity(MyExample4211DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4211DTO> doUpdateEntity(MyExample4211DTO entity, MyExample4211DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
