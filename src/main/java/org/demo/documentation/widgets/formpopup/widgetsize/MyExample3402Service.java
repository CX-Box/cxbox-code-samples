package org.demo.documentation.widgets.formpopup.widgetsize;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3402Service extends VersionAwareResponseService<MyExample3402DTO, MyEntity3402> {

	private final MyEntity3402Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3402Meta> meta = MyExample3402Meta.class;

	@Override
	protected CreateResult<MyExample3402DTO> doCreateEntity(MyEntity3402 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3402DTO> doUpdateEntity(MyEntity3402 entity, MyExample3402DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3402DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3402DTO> getActions() {
		return Actions.<MyExample3402DTO>builder()
				.action(act -> act
						.action("form-popup6", "See formPopup6")
						.withPreAction(PreAction.confirmWithWidget("MyExample3402Formpopup6", cfw -> cfw))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3402DTO>())

				)
				.action(act -> act
						.action("form-popup12", "See formPopup12")
						.withPreAction(PreAction.confirmWithWidget("MyExample3402Formpopup12", cfw -> cfw))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3402DTO>())
				)
				.action(act -> act
						.action("form-popup24", "See formPopup24")
						.withPreAction(PreAction.confirmWithWidget("MyExample3402Formpopup24", cfw -> cfw))
						.invoker((bc, dto) -> new ActionResultDTO<MyExample3402DTO>())
				)
				.build();
	}
}
