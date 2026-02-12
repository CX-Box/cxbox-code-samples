package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

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
public class MyEntity3192PickPick0Service extends VersionAwareResponseService<MyEntity3192PickPick0DTO, MyEntity3192Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3192PickPick0Meta> meta = MyEntity3192PickPick0Meta.class;

	@Override
	protected CreateResult<MyEntity3192PickPick0DTO> doCreateEntity(MyEntity3192Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3192PickPick0DTO> doUpdateEntity(MyEntity3192Pick entity, MyEntity3192PickPick0DTO data,
																	   BusinessComponent bc) {
		return null;
	}


}