package org.demo.documentation.widgets.dualaxes2d.drilldown;

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
public class MyExample4286Service extends AnySourceVersionAwareResponseService<MyExample4286DTO, MyExample4286DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4286Meta> meta = MyExample4286Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4286Dao> dao = MyExample4286Dao.class;

	@Override
	protected CreateResult<MyExample4286DTO> doCreateEntity(MyExample4286DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4286DTO> doUpdateEntity(MyExample4286DTO entity, MyExample4286DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
