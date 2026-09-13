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
public class MyEntity3329PicklistAssocPickService extends VersionAwareResponseService<MyEntity3329PicklistAssocPickDTO, MyEntity3329PicklistAssoc> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3329PicklistAssocPickMeta> meta = MyEntity3329PicklistAssocPickMeta.class;

	@Override
	protected CreateResult<MyEntity3329PicklistAssocPickDTO> doCreateEntity(MyEntity3329PicklistAssoc entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3329PicklistAssocPickDTO> doUpdateEntity(MyEntity3329PicklistAssoc entity, MyEntity3329PicklistAssocPickDTO data,
																			   BusinessComponent bc) {
		return null;
	}


}