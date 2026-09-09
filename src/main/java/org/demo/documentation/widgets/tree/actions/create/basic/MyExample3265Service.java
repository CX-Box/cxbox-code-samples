package org.demo.documentation.widgets.tree.actions.create.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.actions.create.basic.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.time.Duration;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3265Service extends VersionAwareResponseService<MyExample3265DTO, MyEntity3265> {

	private final MyEntity3265Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3265Meta> meta = MyExample3265Meta.class;

	@Override
	protected CreateResult<MyExample3265DTO> doCreateEntity(MyEntity3265 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3265DTO> doUpdateEntity(MyEntity3265 entity, MyExample3265DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3265DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3265DTO_.customFieldMoney, entity::setCustomFieldMoney);

		setIfChanged(data, MyExample3265DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3265DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample3265DTO_.parentId)) {
			entity.setParentId(data.getParentId());
		}
		MyExample3265DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto);
	}

	@Override
	public ActionResultDTO<MyExample3265DTO> deleteEntity(BusinessComponent bc) {
		super.deleteEntity(bc);
		return new ActionResultDTO<>();
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3265DTO> getActions() {
		return Actions.<MyExample3265DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("customSave", "custom Save")
						.scope(ActionScope.RECORD)
						.invoker(this::customSaveInvoker)
				)
				.action(act -> act
						.action("customSaveWithRefresh", "custom Save With Refresh")
						.scope(ActionScope.RECORD)
						.invoker(this::customSaveInvokerWithRefresh)
				)
				.action(act -> act
						.action("customDeleteConfirm", "custom Delete Confirm")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to delete the value?")
						))
						.invoker((bc, dto) ->
						{
							this.deleteEntity(bc);
							return new ActionResultDTO<MyExample3265DTO>();
						})
				)
				.action(act -> act
						.action("customDelete", "custom Delete")
						.invoker((bc, dto) ->
						{
							this.deleteEntity(bc);
							return new ActionResultDTO<MyExample3265DTO>();
						})
				)
				.action(act -> act
						.action("saveWaitUntil", "save Wait Until")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> {
							MyEntity3265 myEntity3265 = repository.findById(bc.getIdAsLong()).orElseThrow();
							myEntity3265.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH);
							repository.save(myEntity3265);
							return new ActionResultDTO<MyExample3265DTO>().setAction(
									PostAction.waitUntil(
													MyExample3265DTO_.customFieldDictionary,
													CustomFieldDictionaryEnum.HIGH)
											.timeoutMaxRequests(6).timeout(Duration.ofSeconds(12)).build());
						}))
				.build();
	}


	// --8<-- [end:getActions]
	private ActionResultDTO<MyExample3265DTO> customSaveInvoker(final BusinessComponent bc, final MyExample3265DTO dto) {
		MyEntity3265 entity = repository.findById(bc.getIdAsLong()).orElse(null);
		assert entity != null;
		entity.setCustomField("Test data" + Math.random());
		return new ActionResultDTO<>();
	}

	private ActionResultDTO<MyExample3265DTO> customSaveInvokerWithRefresh(final BusinessComponent bc, final MyExample3265DTO dto) {
		ActionResultDTO<MyExample3265DTO> actionResult = customSaveInvoker(bc, dto);
		return actionResult.setAction(PostAction.refreshBc(bc));
	}
}