package org.demo.documentation.widgets.relationGraph.title;

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
public class MyExample6152Service extends AnySourceVersionAwareResponseService<MyExample6152DTO, MyExample6152DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6152Meta> meta = MyExample6152Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6152Dao> dao = MyExample6152Dao.class;

	@Override
	protected CreateResult<MyExample6152DTO> doCreateEntity(MyExample6152DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6152DTO> doUpdateEntity(MyExample6152DTO entity, MyExample6152DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
