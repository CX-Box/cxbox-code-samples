package org.demo.documentation.fields.multivalue.validationbusinessex;

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
public class MyEntity193MultivalueService extends VersionAwareResponseService<MyEntity193MultivalueDTO, MyEntity193> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity193MultivalueMeta> meta = MyEntity193MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity193MultivalueDTO> doCreateEntity(MyEntity193 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity193MultivalueDTO> doUpdateEntity(MyEntity193 entity, MyEntity193MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}