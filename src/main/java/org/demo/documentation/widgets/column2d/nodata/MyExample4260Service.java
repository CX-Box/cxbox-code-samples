package org.demo.documentation.widgets.column2d.nodata;

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
public class MyExample4260Service extends AnySourceVersionAwareResponseService<MyExample4260DTO, MyExample4260DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4260Meta> meta = MyExample4260Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4260Dao> dao = MyExample4260Dao.class;

	@Override
	protected CreateResult<MyExample4260DTO> doCreateEntity(MyExample4260DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4260DTO> doUpdateEntity(MyExample4260DTO entity, MyExample4260DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
