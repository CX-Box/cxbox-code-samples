package org.demo.documentation.fields.input.ro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionAvailableChecker;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class InputCreateEditService extends VersionAwareResponseService<InputCreateEditDTO, InputCreateEdit> {

	private final InputCreateEditRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<InputCreateEditMeta> meta = InputCreateEditMeta.class;

	@Override
	protected CreateResult<InputCreateEditDTO> doCreateEntity(InputCreateEdit entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputCreateEditDTO> doUpdateEntity(InputCreateEdit entity, InputCreateEditDTO data,
																 BusinessComponent bc) {
		if (data.isFieldChanged(InputCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputCreateEditDTO> getActions() {
		return Actions.<InputCreateEditDTO>builder()
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("activateFormPopup", "Activate FormPopup")
						.scope(ActionScope.BC)
						.available(ActionAvailableChecker.ALWAYS_TRUE)
						.withPreAction(PreAction.confirmWithWidget(
								"InputCreateEditFormPopup",
								cfw -> cfw
										.title("CustomTitleText")
										.yesText("CustomYesText")
										.noText("CustomNoText")
						))
						.invoker((bc, dto) ->
								new ActionResultDTO<InputCreateEditDTO>().setAction(PostAction.showMessage(
										MessageType.INFO, "Action activateFormPopup was invoked"
								)))
				)
				.build();
	}
	// --8<-- [end:getActions]


}
