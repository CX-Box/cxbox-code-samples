package org.demo.documentation.widgets.column2d.title;

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
public class MyExample4253Service extends AnySourceVersionAwareResponseService<MyExample4253DTO, MyExample4253DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4253Meta> meta = MyExample4253Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4253Dao> dao = MyExample4253Dao.class;

	@Override
	protected CreateResult<MyExample4253DTO> doCreateEntity(MyExample4253DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4253DTO> doUpdateEntity(MyExample4253DTO entity, MyExample4253DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
