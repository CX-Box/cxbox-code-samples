package org.demo.documentation.fields.picktree.filtration;

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
public class MyEntity3286PickPickTreeService extends VersionAwareResponseService<MyEntity3286PickDTO, MyEntity3286Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3286PickPickTreeMeta> meta = MyEntity3286PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3286PickDTO> doCreateEntity(MyEntity3286Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3286PickDTO> doUpdateEntity(MyEntity3286Pick entity, MyEntity3286PickDTO data,
																 BusinessComponent bc) {
		if (data.isFieldChanged(MyEntity3286PickDTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		return null;
	}


}