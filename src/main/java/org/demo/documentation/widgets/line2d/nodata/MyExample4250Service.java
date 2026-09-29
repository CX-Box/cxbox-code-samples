package org.demo.documentation.widgets.line2d.nodata;

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
public class MyExample4250Service extends AnySourceVersionAwareResponseService<MyExample4250DTO, MyExample4250DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4250Meta> meta = MyExample4250Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4250Dao> dao = MyExample4250Dao.class;

	@Override
	protected CreateResult<MyExample4250DTO> doCreateEntity(MyExample4250DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4250DTO> doUpdateEntity(MyExample4250DTO entity, MyExample4250DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
