package org.demo.documentation.widgets.dualaxes2d.showcondition;

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
public class MyExample4282Service extends AnySourceVersionAwareResponseService<MyExample4282DTO, MyExample4282DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4282Meta> meta = MyExample4282Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4282Dao> dao = MyExample4282Dao.class;

	@Override
	protected CreateResult<MyExample4282DTO> doCreateEntity(MyExample4282DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4282DTO> doUpdateEntity(MyExample4282DTO entity, MyExample4282DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
