package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

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
public class MyEntity3052PicklistPickService extends VersionAwareResponseService<MyEntity3052PicklistPickDTO, MyEntity3052Picklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3052PicklistPickMeta> meta = MyEntity3052PicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3052PicklistPickDTO> doCreateEntity(MyEntity3052Picklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3052PicklistPickDTO> doUpdateEntity(MyEntity3052Picklist entity, MyEntity3052PicklistPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}