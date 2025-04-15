package org.demo.documentation.fields.inlinepicklist.validationconfirm;

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
public class MyEntity153PickPickListService extends
		VersionAwareResponseService<MyEntity153PickDTO, org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity153PickPickListMeta> meta = MyEntity153PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity153PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity153PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153 entity, MyEntity153PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}