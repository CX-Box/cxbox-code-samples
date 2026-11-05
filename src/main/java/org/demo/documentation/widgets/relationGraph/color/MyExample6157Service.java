package org.demo.documentation.widgets.relationGraph.color;

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
public class MyExample6157Service extends AnySourceVersionAwareResponseService<MyExample6157DTO, MyExample6157DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6157Meta> meta = MyExample6157Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6157Dao> dao = MyExample6157Dao.class;

	@Override
	protected CreateResult<MyExample6157DTO> doCreateEntity(MyExample6157DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6157DTO> doUpdateEntity(MyExample6157DTO entity, MyExample6157DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
