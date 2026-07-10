package org.demo.documentation.widgets.ringprogress.base.defaultfields;

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
public class MyExample4207Service extends AnySourceVersionAwareResponseService<MyExample4207DTO, MyExample4207DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4207Meta> meta = MyExample4207Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4207Dao> dao = MyExample4207Dao.class;

	@Override
	protected CreateResult<MyExample4207DTO> doCreateEntity(MyExample4207DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4207DTO> doUpdateEntity(MyExample4207DTO entity, MyExample4207DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
