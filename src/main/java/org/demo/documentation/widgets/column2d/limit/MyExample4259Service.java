package org.demo.documentation.widgets.column2d.limit;

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
public class MyExample4259Service extends AnySourceVersionAwareResponseService<MyExample4259DTO, MyExample4259DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4259Meta> meta = MyExample4259Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4259Dao> dao = MyExample4259Dao.class;

	@Override
	protected CreateResult<MyExample4259DTO> doCreateEntity(MyExample4259DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4259DTO> doUpdateEntity(MyExample4259DTO entity, MyExample4259DTO data,
			BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}
