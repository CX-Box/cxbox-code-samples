package org.demo.documentation.widgets.dualaxes2d.tablemode;

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
public class MyExample4287Service extends AnySourceVersionAwareResponseService<MyExample4287DTO, MyExample4287DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4287Meta> meta = MyExample4287Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4287Dao> dao = MyExample4287Dao.class;

	@Override
	protected CreateResult<MyExample4287DTO> doCreateEntity(MyExample4287DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4287DTO> doUpdateEntity(MyExample4287DTO entity, MyExample4287DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
