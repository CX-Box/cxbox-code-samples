package org.demo.documentation.widgets.column2d.sorting;

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
public class MyExample4271Service extends AnySourceVersionAwareResponseService<MyExample4271DTO, MyExample4271DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4271Meta> meta = MyExample4271Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4271Dao> dao = MyExample4271Dao.class;

	@Override
	protected CreateResult<MyExample4271DTO> doCreateEntity(MyExample4271DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4271DTO> doUpdateEntity(MyExample4271DTO entity, MyExample4271DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
