package org.demo.documentation.feature.massoperations.gh;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.MassActionResultDTO;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.massoperations.gh.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6102Service extends VersionAwareResponseService<MyExample6102DTO, MyEntity6102> {

	private final MyEntity6102Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6102Meta> meta = MyExample6102Meta.class;

	@Override
	protected CreateResult<MyExample6102DTO> doCreateEntity(MyEntity6102 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6102DTO> doUpdateEntity(MyEntity6102 entity, MyExample6102DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample6102DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample6102DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample6102DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6102DTO> getActions() {
		return Actions.<MyExample6102DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))

				// --8<-- [start:massEdit]
				.action(act -> act
						.action("massEdit", "Mass Edit")
						.withPreAction(PreAction.confirmWithWidget("myexample6102Form",
								cfw -> cfw))
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = getMassDTO(data, ids, false);
							return new MassActionResultDTO<MyExample6102DTO>(massResult)
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
							return new MassActionResultDTO<MyExample6102DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massCheckboxTrue]

				// --8<-- [start:massDelete]
				.action(act -> act
						.action("massDelete", "Mass Delete")
						.scope(ActionScope.MASS)
						.massInvoker((bc, data, ids) -> {
							var massResult = ids.stream()
									.map(id -> {
										try {
											MyEntity6102 myEntity6102 = repository.findById(Long.parseLong(id)).orElseThrow();
											if (myEntity6102.getCustomFieldDictionary() == CustomFieldDictionaryEnum.ERROR) {
												return MassDTO.fail(id, "cannot delete Error");
											}
											repository.delete(myEntity6102);
											return MassDTO.success(id);
										} catch (Exception e) {
											return MassDTO.fail(id, "cannot delete");
										}
									})
									.collect(Collectors.toSet());
							return new MassActionResultDTO<MyExample6102DTO>(massResult)
									.setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
						})
				)
				// --8<-- [end:massDelete]
				.build();
	}

	@NonNull
	private Set<MassDTO> getMassDTO(@NonNull MyExample6102DTO data, Set<String> ids, boolean onlyCheckboxChange) {
		return ids.stream()
				.map(id -> {
					try {
						MyEntity6102 myEntity6102 = repository.findById(Long.parseLong(id)).orElseThrow();
						if (myEntity6102.getCustomFieldDictionary() == CustomFieldDictionaryEnum.ERROR) {
							return MassDTO.fail(id, "cannot update Error");
						}
						if (onlyCheckboxChange) {
							myEntity6102.setCustomFieldCheckbox(true);
						} else {
							myEntity6102.setCustomFieldDictionary(data.getCustomFieldDictionary());
							myEntity6102.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
						}
						return MassDTO.success(id);
					} catch (Exception e) {
						return MassDTO.fail(id, "cannot update");
					}
				})
				.collect(Collectors.toSet());
	}

}
