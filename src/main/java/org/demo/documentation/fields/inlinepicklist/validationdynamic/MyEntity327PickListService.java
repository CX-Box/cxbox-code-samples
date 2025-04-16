package org.demo.documentation.fields.inlinepicklist.validationdynamic;

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
public class MyEntity327PickListService extends VersionAwareResponseService<MyEntity327PickDTO, MyEntity327> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity327PickListMeta> meta = MyEntity327PickListMeta.class;

    @Override
	protected CreateResult<MyEntity327PickDTO> doCreateEntity(MyEntity327 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity327PickDTO> doUpdateEntity(MyEntity327 entity, MyEntity327PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}