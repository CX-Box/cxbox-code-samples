package org.demo.documentation.widgets.relationGraph.edges;

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
public class MyExample6156Service extends AnySourceVersionAwareResponseService<MyExample6156DTO, MyExample6156DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6156Meta> meta = MyExample6156Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6156Dao> dao = MyExample6156Dao.class;

	@Override
	protected CreateResult<MyExample6156DTO> doCreateEntity(MyExample6156DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6156DTO> doUpdateEntity(MyExample6156DTO entity, MyExample6156DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
