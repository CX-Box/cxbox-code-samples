package org.demo.documentation.widgets.pie1d.drilldown.drilldown;

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
public class MyExample4219Service extends AnySourceVersionAwareResponseService<MyExample4219DTO, MyExample4219DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4219Meta> meta = MyExample4219Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4219Dao> dao = MyExample4219Dao.class;

	@Override
	protected CreateResult<MyExample4219DTO> doCreateEntity(MyExample4219DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4219DTO> doUpdateEntity(MyExample4219DTO entity, MyExample4219DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
