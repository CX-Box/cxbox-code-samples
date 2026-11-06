package org.demo.documentation.widgets.relationGraph.drilldown;

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
public class MyExample6158Service extends AnySourceVersionAwareResponseService<MyExample6158DTO, MyExample6158DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6158Meta> meta = MyExample6158Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6158Dao> dao = MyExample6158Dao.class;

	@Override
	protected CreateResult<MyExample6158DTO> doCreateEntity(MyExample6158DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6158DTO> doUpdateEntity(MyExample6158DTO entity, MyExample6158DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
