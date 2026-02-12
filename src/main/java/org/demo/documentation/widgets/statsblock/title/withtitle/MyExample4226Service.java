package org.demo.documentation.widgets.statsblock.title.withtitle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample4226Service extends AnySourceVersionAwareResponseService<MyExample4226DTO, MyExample4226DTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4226Meta> meta = MyExample4226Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4226Dao> dao = MyExample4226Dao.class;

	@Override
	protected CreateResult<MyExample4226DTO> doCreateEntity(MyExample4226DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}


	@Override
	protected ActionResultDTO<MyExample4226DTO> doUpdateEntity(MyExample4226DTO entity, MyExample4226DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
