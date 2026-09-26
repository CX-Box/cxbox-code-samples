package org.demo.documentation.widgets.pie1d.pagelimit;

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
public class MyExample4263Service extends AnySourceVersionAwareResponseService<MyExample4263DTO, MyExample4263DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4263Meta> meta = MyExample4263Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4263Dao> dao = MyExample4263Dao.class;

	@Override
	protected CreateResult<MyExample4263DTO> doCreateEntity(MyExample4263DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4263DTO> doUpdateEntity(MyExample4263DTO entity, MyExample4263DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
