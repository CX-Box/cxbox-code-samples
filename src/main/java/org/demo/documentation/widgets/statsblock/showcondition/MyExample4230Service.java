package org.demo.documentation.widgets.statsblock.showcondition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample4230Service extends AnySourceVersionAwareResponseService<MyExample4230DTO, MyExample4230DTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4230Meta> meta = MyExample4230Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4230Dao> dao = MyExample4230Dao.class;

	@Override
	protected CreateResult<MyExample4230DTO> doCreateEntity(MyExample4230DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}


	@Override
	protected ActionResultDTO<MyExample4230DTO> doUpdateEntity(MyExample4230DTO entity, MyExample4230DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}
