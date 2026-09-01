package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3268MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3268MultiHoverMultivalueDTO, Myexample3262MultiHover> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3268MultiHoverMultivalueMeta> meta = MyEntity3268MultiHoverMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3268MultiHoverMultivalueDTO> doCreateEntity(Myexample3262MultiHover entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3268MultiHoverMultivalueDTO> doUpdateEntity(Myexample3262MultiHover entity, MyEntity3268MultiHoverMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}