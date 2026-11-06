package org.demo.documentation.widgets.dualaxes2d.base;

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
public class MyExample4280Service extends AnySourceVersionAwareResponseService<MyExample4280DTO, MyExample4280DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4280Meta> meta = MyExample4280Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4280Dao> dao = MyExample4280Dao.class;

	@Override
	protected CreateResult<MyExample4280DTO> doCreateEntity(MyExample4280DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4280DTO> doUpdateEntity(MyExample4280DTO entity, MyExample4280DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
