package org.demo.documentation.fields.picklist.validationdynamic;

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
public class MyEntity401PickPickService extends VersionAwareResponseService<MyEntity401PickPickDTO, MyEntity401Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity401PickPickMeta> meta = MyEntity401PickPickMeta.class;

    @Override
	protected CreateResult<MyEntity401PickPickDTO> doCreateEntity(MyEntity401Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity401PickPickDTO> doUpdateEntity(MyEntity401Pick entity, MyEntity401PickPickDTO data,
			BusinessComponent bc) {
		return null;
	}


}