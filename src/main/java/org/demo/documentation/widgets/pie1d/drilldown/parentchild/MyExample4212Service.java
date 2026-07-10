package org.demo.documentation.widgets.pie1d.drilldown.parentchild;

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
public class MyExample4212Service extends AnySourceVersionAwareResponseService<MyExample4212DTO, MyExample4212DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4212Meta> meta = MyExample4212Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4212Dao> dao = MyExample4212Dao.class;

	@Override
	protected CreateResult<MyExample4212DTO> doCreateEntity(MyExample4212DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4212DTO> doUpdateEntity(MyExample4212DTO entity, MyExample4212DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
