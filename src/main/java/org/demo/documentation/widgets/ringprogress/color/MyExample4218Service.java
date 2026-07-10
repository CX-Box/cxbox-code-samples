package org.demo.documentation.widgets.ringprogress.color;

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
public class MyExample4218Service extends AnySourceVersionAwareResponseService<MyExample4218DTO, MyExample4218DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4218Meta> meta = MyExample4218Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4218Dao> dao = MyExample4218Dao.class;

	@Override
	protected CreateResult<MyExample4218DTO> doCreateEntity(MyExample4218DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4218DTO> doUpdateEntity(MyExample4218DTO entity, MyExample4218DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
