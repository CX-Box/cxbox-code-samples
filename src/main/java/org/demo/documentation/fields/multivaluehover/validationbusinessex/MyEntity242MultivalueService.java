package org.demo.documentation.fields.multivaluehover.validationbusinessex;

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
public class MyEntity242MultivalueService extends VersionAwareResponseService<MyEntity242MultivalueDTO, MyEntity242> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity242MultivalueMeta> meta = MyEntity242MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity242MultivalueDTO> doCreateEntity(MyEntity242 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity242MultivalueDTO> doUpdateEntity(MyEntity242 entity, MyEntity242MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}