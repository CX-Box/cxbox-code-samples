package org.demo.documentation.widgets.dualaxes2d.pagelimit;

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
public class MyExample4288Service extends AnySourceVersionAwareResponseService<MyExample4288DTO, MyExample4288DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4288Meta> meta = MyExample4288Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4288Dao> dao = MyExample4288Dao.class;

	@Override
	protected CreateResult<MyExample4288DTO> doCreateEntity(MyExample4288DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4288DTO> doUpdateEntity(MyExample4288DTO entity, MyExample4288DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
