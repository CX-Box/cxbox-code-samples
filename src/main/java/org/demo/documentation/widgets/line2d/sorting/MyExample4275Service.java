package org.demo.documentation.widgets.line2d.sorting;

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
public class MyExample4275Service extends AnySourceVersionAwareResponseService<MyExample4275DTO, MyExample4275DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4275Meta> meta = MyExample4275Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4275Dao> dao = MyExample4275Dao.class;

	@Override
	protected CreateResult<MyExample4275DTO> doCreateEntity(MyExample4275DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4275DTO> doUpdateEntity(MyExample4275DTO entity, MyExample4275DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
