package org.demo.documentation.widgets.pie1d.filtergroup;

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
public class MyExample4266Service extends AnySourceVersionAwareResponseService<MyExample4266DTO, MyExample4266DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4266Meta> meta = MyExample4266Meta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4266Dao> dao = MyExample4266Dao.class;

	@Override
	protected CreateResult<MyExample4266DTO> doCreateEntity(MyExample4266DTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4266DTO> doUpdateEntity(MyExample4266DTO entity, MyExample4266DTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
