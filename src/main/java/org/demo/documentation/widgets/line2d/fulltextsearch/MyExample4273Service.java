package org.demo.documentation.widgets.line2d.fulltextsearch;

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
public class MyExample4273Service extends AnySourceVersionAwareResponseService<MyExample4273DTO, MyExample4273DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4273Meta> meta = MyExample4273Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4273Dao> dao = MyExample4273Dao.class;

	@Override
	protected CreateResult<MyExample4273DTO> doCreateEntity(MyExample4273DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4273DTO> doUpdateEntity(MyExample4273DTO entity, MyExample4273DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
