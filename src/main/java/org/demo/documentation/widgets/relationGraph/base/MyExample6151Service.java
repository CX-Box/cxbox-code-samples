package org.demo.documentation.widgets.relationGraph.base;

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
public class MyExample6151Service extends AnySourceVersionAwareResponseService<MyExample6151DTO, MyExample6151DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6151Meta> meta = MyExample6151Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6151Dao> dao = MyExample6151Dao.class;

	@Override
	protected CreateResult<MyExample6151DTO> doCreateEntity(MyExample6151DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6151DTO> doUpdateEntity(MyExample6151DTO entity, MyExample6151DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
