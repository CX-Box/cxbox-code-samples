package org.demo.documentation.widgets.line2d.title;

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
public class MyExample4241Service extends AnySourceVersionAwareResponseService<MyExample4241DTO, MyExample4241DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4241Meta> meta = MyExample4241Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4241Dao> dao = MyExample4241Dao.class;

	@Override
	protected CreateResult<MyExample4241DTO> doCreateEntity(MyExample4241DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4241DTO> doUpdateEntity(MyExample4241DTO entity, MyExample4241DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
