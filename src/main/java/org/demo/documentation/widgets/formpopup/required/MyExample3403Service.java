package org.demo.documentation.widgets.formpopup.required;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3403Service extends VersionAwareResponseService<MyExample3403DTO, MyEntity3403> {

	private final MyEntity3403Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3403Meta> meta = MyExample3403Meta.class;

	@Override
	protected CreateResult<MyExample3403DTO> doCreateEntity(MyEntity3403 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3403DTO> doUpdateEntity(MyEntity3403 entity, MyExample3403DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3403DTO_.customFieldRequired2, entity::setCustomFieldRequired2);
		setIfChanged(data, MyExample3403DTO_.customFieldRequired, entity::setCustomFieldRequired);
		setIfChanged(data, MyExample3403DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3403DTO> getActions() {
		return Actions.<MyExample3403DTO>builder()
				.action(act -> act
						.action("see-formpopup1", "See formpopup1")
						.withPreAction(PreAction.confirmWithWidget("myExample3403FormPopup1", cfw -> cfw))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3403DTO>())
				)
				.action(act -> act
						.action("see-formpopup2", "See formpopup2")
						.withPreAction(PreAction.confirmWithWidget("myExample3403FormPopup2", cfw -> cfw))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3403DTO>())
				)
				.build();
	}

}