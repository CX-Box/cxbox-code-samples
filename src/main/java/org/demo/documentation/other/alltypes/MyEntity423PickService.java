package org.demo.documentation.other.alltypes;

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
public class MyEntity423PickService extends VersionAwareResponseService<MyEntity423PickDTO, MyEntity423> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity423PickMeta> meta = MyEntity423PickMeta.class;

	@Override
	protected CreateResult<MyEntity423PickDTO> doCreateEntity(MyEntity423 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity423PickDTO> doUpdateEntity(MyEntity423 entity, MyEntity423PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}