package org.demo.documentation.fields.multivalue.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity193MultivalueService extends VersionAwareResponseService<MyEntity193MultivalueDTO, MyEntity193> {

	public MyEntity193MultivalueService() {
		super(MyEntity193MultivalueDTO.class, MyEntity193.class, null, MyEntity193MultivalueMeta.class);
	}

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