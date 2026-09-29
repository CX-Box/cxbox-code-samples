package org.demo.documentation.widgets.line2d.stack;

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
public class MyExample4244Service extends AnySourceVersionAwareResponseService<MyExample4244DTO, MyExample4244DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4244Meta> meta = MyExample4244Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4244Dao> dao = MyExample4244Dao.class;

	@Override
	protected CreateResult<MyExample4244DTO> doCreateEntity(MyExample4244DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4244DTO> doUpdateEntity(MyExample4244DTO entity, MyExample4244DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
