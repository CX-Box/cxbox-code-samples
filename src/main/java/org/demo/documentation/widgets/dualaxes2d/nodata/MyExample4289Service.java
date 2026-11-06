package org.demo.documentation.widgets.dualaxes2d.nodata;

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
public class MyExample4289Service extends AnySourceVersionAwareResponseService<MyExample4289DTO, MyExample4289DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4289Meta> meta = MyExample4289Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4289Dao> dao = MyExample4289Dao.class;

	@Override
	protected CreateResult<MyExample4289DTO> doCreateEntity(MyExample4289DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4289DTO> doUpdateEntity(MyExample4289DTO entity, MyExample4289DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
