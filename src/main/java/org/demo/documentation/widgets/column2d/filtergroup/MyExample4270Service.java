package org.demo.documentation.widgets.column2d.filtergroup;

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
public class MyExample4270Service extends AnySourceVersionAwareResponseService<MyExample4270DTO, MyExample4270DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4270Meta> meta = MyExample4270Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4270Dao> dao = MyExample4270Dao.class;

	@Override
	protected CreateResult<MyExample4270DTO> doCreateEntity(MyExample4270DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4270DTO> doUpdateEntity(MyExample4270DTO entity, MyExample4270DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
