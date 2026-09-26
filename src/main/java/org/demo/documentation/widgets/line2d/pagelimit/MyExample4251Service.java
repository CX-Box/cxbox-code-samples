package org.demo.documentation.widgets.line2d.pagelimit;

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
public class MyExample4251Service extends AnySourceVersionAwareResponseService<MyExample4251DTO, MyExample4251DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4251Meta> meta = MyExample4251Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4251Dao> dao = MyExample4251Dao.class;

	@Override
	protected CreateResult<MyExample4251DTO> doCreateEntity(MyExample4251DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4251DTO> doUpdateEntity(MyExample4251DTO entity, MyExample4251DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
