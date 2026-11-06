package org.demo.documentation.widgets.relationGraph.nodata;

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
public class MyExample6161Service extends AnySourceVersionAwareResponseService<MyExample6161DTO, MyExample6161DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6161Meta> meta = MyExample6161Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6161Dao> dao = MyExample6161Dao.class;

	@Override
	protected CreateResult<MyExample6161DTO> doCreateEntity(MyExample6161DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6161DTO> doUpdateEntity(MyExample6161DTO entity, MyExample6161DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
