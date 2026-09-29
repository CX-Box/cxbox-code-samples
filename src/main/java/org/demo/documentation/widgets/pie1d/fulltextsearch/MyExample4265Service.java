package org.demo.documentation.widgets.pie1d.fulltextsearch;

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
public class MyExample4265Service extends AnySourceVersionAwareResponseService<MyExample4265DTO, MyExample4265DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4265Meta> meta = MyExample4265Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4265Dao> dao = MyExample4265Dao.class;

	@Override
	protected CreateResult<MyExample4265DTO> doCreateEntity(MyExample4265DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4265DTO> doUpdateEntity(MyExample4265DTO entity, MyExample4265DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
