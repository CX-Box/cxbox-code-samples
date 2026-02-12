package org.demo.documentation.widgets.info.colortitle.forfields;

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
public class MyEntity3040PicklistPickService extends VersionAwareResponseService<MyEntity3040PicklistPickDTO, MyEntity3040Picklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3040PicklistPickMeta> meta = MyEntity3040PicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3040PicklistPickDTO> doCreateEntity(MyEntity3040Picklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3040PicklistPickDTO> doUpdateEntity(MyEntity3040Picklist entity, MyEntity3040PicklistPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}