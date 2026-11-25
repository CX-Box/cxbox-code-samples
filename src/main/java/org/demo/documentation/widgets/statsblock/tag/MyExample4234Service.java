package org.demo.documentation.widgets.statsblock.tag;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@Service
public class MyExample4234Service extends AnySourceVersionAwareResponseService<MyExample4234DTO, MyExample4234DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4234Meta> meta = MyExample4234Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4234Dao> dao = MyExample4234Dao.class;

	@Override
	protected CreateResult<MyExample4234DTO> doCreateEntity(MyExample4234DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4234DTO> doUpdateEntity(MyExample4234DTO entity, MyExample4234DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
