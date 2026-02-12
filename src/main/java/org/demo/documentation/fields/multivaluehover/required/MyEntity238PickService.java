package org.demo.documentation.fields.multivaluehover.required;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity238PickService extends VersionAwareResponseService<MyEntity238PickDTO, MyEntity238> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity238PickMeta> meta = MyEntity238PickMeta.class;

	@Override
	protected CreateResult<MyEntity238PickDTO> doCreateEntity(MyEntity238 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity238PickDTO> doUpdateEntity(MyEntity238 entity, MyEntity238PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}