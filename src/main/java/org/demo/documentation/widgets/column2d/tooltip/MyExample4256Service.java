package org.demo.documentation.widgets.column2d.tooltip;

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
public class MyExample4256Service extends AnySourceVersionAwareResponseService<MyExample4256DTO, MyExample4256DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4256Meta> meta = MyExample4256Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4256Dao> dao = MyExample4256Dao.class;

	@Override
	protected CreateResult<MyExample4256DTO> doCreateEntity(MyExample4256DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4256DTO> doUpdateEntity(MyExample4256DTO entity, MyExample4256DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
