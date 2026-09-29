package org.demo.documentation.widgets.line2d.filtration;

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
public class MyExample4272Service extends AnySourceVersionAwareResponseService<MyExample4272DTO, MyExample4272DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4272Meta> meta = MyExample4272Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4272Dao> dao = MyExample4272Dao.class;

	@Override
	protected CreateResult<MyExample4272DTO> doCreateEntity(MyExample4272DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4272DTO> doUpdateEntity(MyExample4272DTO entity, MyExample4272DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
