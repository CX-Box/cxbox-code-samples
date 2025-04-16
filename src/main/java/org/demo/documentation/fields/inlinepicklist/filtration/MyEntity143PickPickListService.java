package org.demo.documentation.fields.inlinepicklist.filtration;

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
public class MyEntity143PickPickListService extends
		VersionAwareResponseService<MyEntity143PickDTO, org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity143PickPickListMeta> meta = MyEntity143PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity143PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity143PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143 entity, MyEntity143PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}