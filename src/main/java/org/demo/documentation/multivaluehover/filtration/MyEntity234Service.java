package org.demo.documentation.multivaluehover.filtration;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity234Service extends VersionAwareResponseService<MyEntity234DTO, MyEntity234> {

	public MyEntity234Service() {
		super(MyEntity234DTO.class, MyEntity234.class, null, MyEntity234Meta.class);
	}

	@Override
	protected CreateResult<MyEntity234DTO> doCreateEntity(MyEntity234 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity234DTO> doUpdateEntity(MyEntity234 entity, MyEntity234DTO data,
			BusinessComponent bc) {
		return null;
	}


}