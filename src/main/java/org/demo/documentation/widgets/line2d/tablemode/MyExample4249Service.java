package org.demo.documentation.widgets.line2d.tablemode;

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
public class MyExample4249Service extends AnySourceVersionAwareResponseService<MyExample4249DTO, MyExample4249DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4249Meta> meta = MyExample4249Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4249Dao> dao = MyExample4249Dao.class;

	@Override
	protected CreateResult<MyExample4249DTO> doCreateEntity(MyExample4249DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4249DTO> doUpdateEntity(MyExample4249DTO entity, MyExample4249DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
