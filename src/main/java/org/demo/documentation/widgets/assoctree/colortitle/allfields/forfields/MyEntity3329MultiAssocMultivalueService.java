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
public class MyEntity3329MultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3329MultiAssocMultivalueDTO, MyEntity3329MultiAssoc> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3329MultiAssocMultivalueMeta> meta = MyEntity3329MultiAssocMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3329MultiAssocMultivalueDTO> doCreateEntity(MyEntity3329MultiAssoc entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3329MultiAssocMultivalueDTO> doUpdateEntity(MyEntity3329MultiAssoc entity, MyEntity3329MultiAssocMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}