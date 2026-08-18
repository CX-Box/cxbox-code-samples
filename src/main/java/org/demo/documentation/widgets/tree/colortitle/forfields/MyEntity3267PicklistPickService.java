package org.demo.documentation.widgets.tree.colortitle.forfields;

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
public class MyEntity3267PicklistPickService extends VersionAwareResponseService<MyEntity3267PicklistPickDTO, MyEntity3267Picklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3267PicklistPickMeta> meta = MyEntity3267PicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3267PicklistPickDTO> doCreateEntity(MyEntity3267Picklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3267PicklistPickDTO> doUpdateEntity(MyEntity3267Picklist entity, MyEntity3267PicklistPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}