package org.demo.documentation.widgets.column2d.showcondition;

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
public class MyExample4276Service extends AnySourceVersionAwareResponseService<MyExample4276DTO, MyExample4276DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4276Meta> meta = MyExample4276Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4276Dao> dao = MyExample4276Dao.class;

	@Override
	protected CreateResult<MyExample4276DTO> doCreateEntity(MyExample4276DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4276DTO> doUpdateEntity(MyExample4276DTO entity, MyExample4276DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
