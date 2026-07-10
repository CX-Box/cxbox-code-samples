package org.demo.documentation.widgets.ringprogress.title.withtitle;

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
public class MyExample4220Service extends AnySourceVersionAwareResponseService<MyExample4220DTO, MyExample4220DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4220Meta> meta = MyExample4220Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4220Dao> dao = MyExample4220Dao.class;

	@Override
	protected CreateResult<MyExample4220DTO> doCreateEntity(MyExample4220DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4220DTO> doUpdateEntity(MyExample4220DTO entity, MyExample4220DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
