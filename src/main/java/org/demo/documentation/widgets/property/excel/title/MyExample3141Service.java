package org.demo.documentation.widgets.property.excel.title;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@Service
public class MyExample3141Service extends AnySourceVersionAwareResponseService<MyExample3141DTO, MyExample3141DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3141Meta> meta = MyExample3141Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3141Dao> dao = MyExample3141Dao.class;

	@Override
	protected CreateResult<MyExample3141DTO> doCreateEntity(MyExample3141DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3141DTO> doUpdateEntity(MyExample3141DTO entity, MyExample3141DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
