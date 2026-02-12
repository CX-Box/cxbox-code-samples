package org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup;

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
public class MyEntity3867PickPickService extends VersionAwareResponseService<MyEntity3867PickPickDTO, MyEntity3867Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3867PickPickMeta> meta = MyEntity3867PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3867PickPickDTO> doCreateEntity(MyEntity3867Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3867PickPickDTO> doUpdateEntity(MyEntity3867Pick entity, MyEntity3867PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}