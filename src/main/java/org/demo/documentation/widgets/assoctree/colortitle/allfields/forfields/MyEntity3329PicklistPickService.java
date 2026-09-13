package org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields;

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
public class MyEntity3329PicklistPickService extends VersionAwareResponseService<MyEntity3329PicklistPickDTO, MyEntity3329Picklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3329PicklistPickMeta> meta = MyEntity3329PicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3329PicklistPickDTO> doCreateEntity(MyEntity3329Picklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3329PicklistPickDTO> doUpdateEntity(MyEntity3329Picklist entity, MyEntity3329PicklistPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}