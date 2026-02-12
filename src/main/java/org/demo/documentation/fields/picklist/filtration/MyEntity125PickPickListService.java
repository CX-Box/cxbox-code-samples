package org.demo.documentation.fields.picklist.filtration;

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
public class MyEntity125PickPickListService extends VersionAwareResponseService<MyEntity125PickDTO, MyEntity125> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity125PickPickListMeta> meta = MyEntity125PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity125PickDTO> doCreateEntity(MyEntity125 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity125PickDTO> doUpdateEntity(MyEntity125 entity, MyEntity125PickDTO data,
																 BusinessComponent bc) {
		if (data.isFieldChanged(MyEntity125PickDTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		return null;
	}


}