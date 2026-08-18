package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

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
public class MyEntity3268MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3268MultiHoverMultivalueDTO, MyEntity3268MultiHover> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3268MultiHoverMultivalueMeta> meta = MyEntity3268MultiHoverMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3268MultiHoverMultivalueDTO> doCreateEntity(MyEntity3268MultiHover entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3268MultiHoverMultivalueDTO> doUpdateEntity(MyEntity3268MultiHover entity, MyEntity3268MultiHoverMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}