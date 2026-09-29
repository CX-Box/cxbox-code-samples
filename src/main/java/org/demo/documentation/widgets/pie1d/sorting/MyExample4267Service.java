package org.demo.documentation.widgets.pie1d.sorting;

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
public class MyExample4267Service extends AnySourceVersionAwareResponseService<MyExample4267DTO, MyExample4267DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4267Meta> meta = MyExample4267Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4267Dao> dao = MyExample4267Dao.class;

	@Override
	protected CreateResult<MyExample4267DTO> doCreateEntity(MyExample4267DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4267DTO> doUpdateEntity(MyExample4267DTO entity, MyExample4267DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
