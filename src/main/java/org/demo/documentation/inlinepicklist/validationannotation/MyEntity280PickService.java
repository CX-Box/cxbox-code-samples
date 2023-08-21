package org.demo.documentation.inlinepicklist.validationannotation;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity280PickService extends VersionAwareResponseService<MyEntity280PickDTO, MyEntity280> {

	public MyEntity280PickService() {
		super(MyEntity280PickDTO.class, MyEntity280.class, null, MyEntity280PickMeta.class);
	}

	@Override
	protected CreateResult<MyEntity280PickDTO> doCreateEntity(MyEntity280 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity280PickDTO> doUpdateEntity(MyEntity280 entity, MyEntity280PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}