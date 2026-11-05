package org.demo.documentation.widgets.relationGraph.fieldkeys;

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
public class MyExample6164Service extends AnySourceVersionAwareResponseService<MyExample6164DTO, MyExample6164DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6164Meta> meta = MyExample6164Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6164Dao> dao = MyExample6164Dao.class;

	@Override
	protected CreateResult<MyExample6164DTO> doCreateEntity(MyExample6164DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6164DTO> doUpdateEntity(MyExample6164DTO entity, MyExample6164DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
