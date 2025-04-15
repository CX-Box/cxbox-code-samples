package org.demo.documentation.fields.picklist.validationannotation;

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
public class MyEntity297PickService extends VersionAwareResponseService<MyEntity297PickDTO, MyEntity297> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity297PickMeta> meta = MyEntity297PickMeta.class;

    @Override
	protected CreateResult<MyEntity297PickDTO> doCreateEntity(MyEntity297 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity297PickDTO> doUpdateEntity(MyEntity297 entity, MyEntity297PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}