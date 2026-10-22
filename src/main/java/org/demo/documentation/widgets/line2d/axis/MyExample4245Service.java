package org.demo.documentation.widgets.line2d.axis;

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
public class MyExample4245Service extends AnySourceVersionAwareResponseService<MyExample4245DTO, MyExample4245DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4245Meta> meta = MyExample4245Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4245Dao> dao = MyExample4245Dao.class;

	@Override
	protected CreateResult<MyExample4245DTO> doCreateEntity(MyExample4245DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4245DTO> doUpdateEntity(MyExample4245DTO entity, MyExample4245DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
