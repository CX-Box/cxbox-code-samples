package org.demo.documentation.feature.massoperations;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.*;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.massoperations.enums.CustomFieldDictionaryEnum;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6101Service extends VersionAwareResponseService<MyExample6101DTO, MyEntity6101> {

	private final MyEntity6101Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6101Meta> meta = MyExample6101Meta.class;

	@Override
	protected CreateResult<MyExample6101DTO> doCreateEntity(MyEntity6101 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6101DTO> doUpdateEntity(MyEntity6101 entity, MyExample6101DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample6101DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample6101DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample6101DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6101DTO> getActions() {
		return Actions.<MyExample6101DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))

				// --8<-- [start:massEdit]
				.action(act -> act
						.action("massEdit", "Mass Edit")
						.withPreAction(PreAction.confirmWithWidget("myexample6101Form",
								cfw -> cfw))
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = getMassDTO(data, ids, false);
							return new MassActionResultDTO<MyExample6101DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massEdit]

				// --8<-- [start:massCheckboxTrue]
				.action(act -> act
						.action("massCheckboxTrue", "Mass Set Checkbox true")
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = getMassDTO(data, ids, true);
							return new MassActionResultDTO<MyExample6101DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massCheckboxTrue]
				// --8<-- [start:massEditCustomTitle]
				.action(act -> act
						.action("massEditCustomTitle", "Mass Edit With Custom Text")
						.withPreAction(PreAction.confirmWithWidget("myexample6101Form",
								cfw -> cfw.noText("It is text no")
										.title("Mass Edit Title")
										.yesText("It is text yes")))
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = getMassDTO(data, ids, false);
							return new MassActionResultDTO<MyExample6101DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massEditCustomTitle]

				// --8<-- [start:massEditWithoutTitle]
				.action(act -> act
						.action("massEditWithoutTitle", "Mass Edit Without Custom Text")
						.withPreAction(PreAction.confirmWithWidget("myexample6101Form",
								cfw -> cfw.withoutTitle()))
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = getMassDTO(data, ids, false);
							return new MassActionResultDTO<MyExample6101DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massEditWithoutTitle]
				// --8<-- [start:massDelete]
				.action(act -> act
						.action("massDelete", "Mass Delete")
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = ids.stream()
									.map(id -> {
										try {
											MyEntity6101 myEntity6101BD = repository.findById(Long.parseLong(id)).orElseThrow();
											if (myEntity6101BD.getCustomFieldDictionary() != null

													&& Objects.equals(myEntity6101BD.getCustomFieldDictionary().getValue(), CustomFieldDictionaryEnum.ERROR.getValue())) {
												return MassDTO.fail(id, "cannot delete Error");
											}
											MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
											repository.delete(myEntity6101);
											return MassDTO.success(id);
										} catch (Exception e) {
											return MassDTO.fail(id, "cannot delete");
										}
									})
									.collect(Collectors.toSet());
							return new MassActionResultDTO<MyExample6101DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massDelete]
				.build();
	}

	@NotNull
	private Set<MassDTO> getMassDTO(@NonNull MyExample6101DTO data, Set<String> ids, boolean onlyCheckboxChange) {
		return ids.stream()
				.map(id -> {
					try {
						MyEntity6101 myEntity6101BD = repository.findById(Long.parseLong(id)).orElseThrow();
						if (myEntity6101BD.getCustomFieldDictionary() != null

								&& Objects.equals(myEntity6101BD.getCustomFieldDictionary().getValue(), CustomFieldDictionaryEnum.ERROR.getValue())) {
							return MassDTO.fail(id, "cannot update Error");
						}
						MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
						if (!onlyCheckboxChange) {
							myEntity6101.setCustomFieldDictionary(data.getCustomFieldDictionary());
						}
						myEntity6101.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
						return MassDTO.success(id);
					} catch (Exception e) {
						return MassDTO.fail(id, "cannot update");
					}
				})
				.collect(Collectors.toSet());

	}

}