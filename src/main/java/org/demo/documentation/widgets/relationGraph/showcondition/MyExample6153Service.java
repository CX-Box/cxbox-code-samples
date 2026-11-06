package org.demo.documentation.widgets.relationGraph.showcondition;

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
public class MyExample6153Service extends AnySourceVersionAwareResponseService<MyExample6153DTO, MyExample6153DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6153Meta> meta = MyExample6153Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6153Dao> dao = MyExample6153Dao.class;

	@Override
	protected CreateResult<MyExample6153DTO> doCreateEntity(MyExample6153DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6153DTO> doUpdateEntity(MyExample6153DTO entity, MyExample6153DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
