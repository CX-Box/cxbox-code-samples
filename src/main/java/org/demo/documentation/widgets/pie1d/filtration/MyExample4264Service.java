package org.demo.documentation.widgets.pie1d.filtration;

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
public class MyExample4264Service extends AnySourceVersionAwareResponseService<MyExample4264DTO, MyExample4264DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4264Meta> meta = MyExample4264Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4264Dao> dao = MyExample4264Dao.class;

	@Override
	protected CreateResult<MyExample4264DTO> doCreateEntity(MyExample4264DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4264DTO> doUpdateEntity(MyExample4264DTO entity, MyExample4264DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
