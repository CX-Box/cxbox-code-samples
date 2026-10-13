package org.demo.documentation.widgets.column2d.fulltextsearch;

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
public class MyExample4269Service extends AnySourceVersionAwareResponseService<MyExample4269DTO, MyExample4269DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4269Meta> meta = MyExample4269Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4269Dao> dao = MyExample4269Dao.class;

	@Override
	protected CreateResult<MyExample4269DTO> doCreateEntity(MyExample4269DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4269DTO> doUpdateEntity(MyExample4269DTO entity, MyExample4269DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
