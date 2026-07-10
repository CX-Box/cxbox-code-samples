package org.demo.documentation.widgets.pie1d.showcondition;

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
public class MyExample4215Service extends AnySourceVersionAwareResponseService<MyExample4215DTO, MyExample4215DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4215Meta> meta = MyExample4215Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4215Dao> dao = MyExample4215Dao.class;

	@Override
	protected CreateResult<MyExample4215DTO> doCreateEntity(MyExample4215DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4215DTO> doUpdateEntity(MyExample4215DTO entity, MyExample4215DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
