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
public class MyEntity3329MultiMultiAssocMultivalueService extends VersionAwareResponseService<MyEntity3329MultiMultiAssocMultivalueDTO, MyEntity3329MultiMultiAssoc> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3329MultiMultiAssocMultivalueMeta> meta = MyEntity3329MultiMultiAssocMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3329MultiMultiAssocMultivalueDTO> doCreateEntity(MyEntity3329MultiMultiAssoc entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3329MultiMultiAssocMultivalueDTO> doUpdateEntity(MyEntity3329MultiMultiAssoc entity, MyEntity3329MultiMultiAssocMultivalueDTO data,
																					   BusinessComponent bc) {
		return null;
	}


}