package org.demo.documentation.widgets.line2d.filtergroup;

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
public class MyExample4274Service extends AnySourceVersionAwareResponseService<MyExample4274DTO, MyExample4274DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4274Meta> meta = MyExample4274Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4274Dao> dao = MyExample4274Dao.class;

	@Override
	protected CreateResult<MyExample4274DTO> doCreateEntity(MyExample4274DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4274DTO> doUpdateEntity(MyExample4274DTO entity, MyExample4274DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
