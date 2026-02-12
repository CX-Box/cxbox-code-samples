package org.demo.documentation.widgets.property.defaultlimitpage.forpick;

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
public class MyEntity359PickPickService extends VersionAwareResponseService<MyEntity359PickPickDTO, MyEntity359Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity359PickPickMeta> meta = MyEntity359PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity359PickPickDTO> doCreateEntity(MyEntity359Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity359PickPickDTO> doUpdateEntity(MyEntity359Pick entity, MyEntity359PickPickDTO data,
																	 BusinessComponent bc) {
		return null;
	}


}