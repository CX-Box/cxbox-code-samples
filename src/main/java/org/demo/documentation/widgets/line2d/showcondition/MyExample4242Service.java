package org.demo.documentation.widgets.line2d.showcondition;

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
public class MyExample4242Service extends AnySourceVersionAwareResponseService<MyExample4242DTO, MyExample4242DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4242Meta> meta = MyExample4242Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4242Dao> dao = MyExample4242Dao.class;

	@Override
	protected CreateResult<MyExample4242DTO> doCreateEntity(MyExample4242DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4242DTO> doUpdateEntity(MyExample4242DTO entity, MyExample4242DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
