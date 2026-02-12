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
public class MyEntity422PickService extends VersionAwareResponseService<MyEntity422PickDTO, MyEntity422> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity422PickMeta> meta = MyEntity422PickMeta.class;

	@Override
	protected CreateResult<MyEntity422PickDTO> doCreateEntity(MyEntity422 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity422PickDTO> doUpdateEntity(MyEntity422 entity, MyEntity422PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}