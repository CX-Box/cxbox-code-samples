package org.demo.documentation.widgets.steps.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionAvailableChecker;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5023Service extends VersionAwareResponseService<MyExample5023DTO, MyEntity5023> {

	private final MyEntity5023Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5023Meta> meta = MyExample5023Meta.class;

	@Override
	protected CreateResult<MyExample5023DTO> doCreateEntity(MyEntity5023 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5023DTO> doUpdateEntity(MyEntity5023 entity, MyExample5023DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5023DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5023DTO> getActions() {
		return Actions.<MyExample5023DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.scope(ActionScope.RECORD)
						.action("next", "Continue")
						.invoker((bc, dto) -> {
							MyEntity5023 myEntityStep = repository.getById(bc.getIdAsLong());
							StepsEnum nextStep = StepsEnum.getNextEditStep(myEntityStep).get();
							myEntityStep.setEditStep(nextStep);
							repository.save(myEntityStep);

							return new ActionResultDTO<MyExample5023DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											nextStep.getStepView() + CxboxMyExample5023Controller.myexample5023 + "/" + bc.getId()
									));
						})
						.available(ActionAvailableChecker.and(ActionAvailableChecker.NOT_NULL_ID, bc -> {
							MyEntity5023 entity = repository.getById(bc.getIdAsLong());
							return StepsEnum.getNextEditStep(entity).isPresent();
						}))
				)
				.action(act -> act
						.scope(ActionScope.RECORD)
						.action("finish", "Close")
						.invoker((bc, dto) -> {
							MyEntity5023 myEntityStep = repository.getById(bc.getIdAsLong());
							StepsEnum firstStep = Arrays.stream(StepsEnum.values()).findFirst().get();
							myEntityStep.setEditStep(firstStep);
							repository.save(myEntityStep);
							return new ActionResultDTO<MyExample5023DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample5023"
									));
						})
						.available(ActionAvailableChecker.and(ActionAvailableChecker.NOT_NULL_ID, bc -> {
							MyEntity5023 entity = repository.getById(bc.getIdAsLong());
							return !StepsEnum.getNextEditStep(entity).isPresent();
						}))
				)
				.action(act -> act
						.action("previous", "Back")
						.scope(ActionScope.RECORD)
						.invoker((bc, dto) -> {
							MyEntity5023 myEntityStep = repository.getById(bc.getIdAsLong());
							StepsEnum previousStep = StepsEnum.getPreviousEditStep(myEntityStep).get();
							myEntityStep.setEditStep(previousStep);
							repository.save(myEntityStep);
							return new ActionResultDTO<MyExample5023DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											previousStep.getStepView() + CxboxMyExample5023Controller.myexample5023 + "/" + bc.getId()
									));
						})
						.available(ActionAvailableChecker.and(ActionAvailableChecker.NOT_NULL_ID, bc -> {
							MyEntity5023 entity = repository.getById(bc.getIdAsLong());
							return StepsEnum.getPreviousEditStep(entity).isPresent();
						}))
				)
				.build();
	}

}