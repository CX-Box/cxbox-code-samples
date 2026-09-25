package org.demo.documentation.widgets.line2d.groups;

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
public class MyExample4243Service extends AnySourceVersionAwareResponseService<MyExample4243DTO, MyExample4243DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4243Meta> meta = MyExample4243Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4243Dao> dao = MyExample4243Dao.class;

	@Override
	protected CreateResult<MyExample4243DTO> doCreateEntity(MyExample4243DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4243DTO> doUpdateEntity(MyExample4243DTO entity, MyExample4243DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
