package org.demo.documentation.widgets.pie1d.total;

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
public class MyExample4261Service extends AnySourceVersionAwareResponseService<MyExample4261DTO, MyExample4261DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4261Meta> meta = MyExample4261Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4261Dao> dao = MyExample4261Dao.class;

	@Override
	protected CreateResult<MyExample4261DTO> doCreateEntity(MyExample4261DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4261DTO> doUpdateEntity(MyExample4261DTO entity, MyExample4261DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
