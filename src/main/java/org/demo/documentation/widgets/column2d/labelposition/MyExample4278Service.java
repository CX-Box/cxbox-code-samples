package org.demo.documentation.widgets.column2d.labelposition;

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
public class MyExample4278Service extends AnySourceVersionAwareResponseService<MyExample4278DTO, MyExample4278DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4278Meta> meta = MyExample4278Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4278Dao> dao = MyExample4278Dao.class;

	@Override
	protected CreateResult<MyExample4278DTO> doCreateEntity(MyExample4278DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4278DTO> doUpdateEntity(MyExample4278DTO entity, MyExample4278DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
