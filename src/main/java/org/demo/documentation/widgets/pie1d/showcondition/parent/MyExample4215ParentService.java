package org.demo.documentation.widgets.pie1d.showcondition.parent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4215ParentService extends VersionAwareResponseService<MyExample4215ParentDTO, MyEntity4215Parent> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4215ParentMeta> meta = MyExample4215ParentMeta.class;

	@Override
	protected CreateResult<MyExample4215ParentDTO> doCreateEntity(MyEntity4215Parent entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4215ParentDTO> doUpdateEntity(MyEntity4215Parent entity,
			MyExample4215ParentDTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample4215ParentDTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExample4215ParentDTO> getActions() {
		return Actions.<MyExample4215ParentDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}
