package org.demo.documentation.widgets.pie1d.labelposition;

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
public class MyExample4262Service extends AnySourceVersionAwareResponseService<MyExample4262DTO, MyExample4262DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4262Meta> meta = MyExample4262Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4262Dao> dao = MyExample4262Dao.class;

	@Override
	protected CreateResult<MyExample4262DTO> doCreateEntity(MyExample4262DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4262DTO> doUpdateEntity(MyExample4262DTO entity, MyExample4262DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
