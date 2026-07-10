package org.demo.documentation.widgets.ringprogress.title.withouttitle;

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
public class MyExample4217Service extends AnySourceVersionAwareResponseService<MyExample4217DTO, MyExample4217DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4217Meta> meta = MyExample4217Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4217Dao> dao = MyExample4217Dao.class;

	@Override
	protected CreateResult<MyExample4217DTO> doCreateEntity(MyExample4217DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4217DTO> doUpdateEntity(MyExample4217DTO entity, MyExample4217DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
}
