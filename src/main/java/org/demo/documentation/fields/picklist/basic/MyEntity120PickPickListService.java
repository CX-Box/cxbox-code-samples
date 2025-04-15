package org.demo.documentation.fields.picklist.basic;

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
public class MyEntity120PickPickListService extends VersionAwareResponseService<MyEntity120PickDTO, MyEntityPick120> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity120PickPickListMeta> meta = MyEntity120PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity120PickDTO> doCreateEntity(MyEntityPick120 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity120PickDTO> doUpdateEntity(MyEntityPick120 entity, MyEntity120PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}