package org.demo.documentation.other.drilldown.option;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3421Service extends VersionAwareResponseService<MyExample3421DTO, MyEntity3421> {

	private final MyEntity3421Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3421Meta> meta = MyExample3421Meta.class;

	@Override
	protected CreateResult<MyExample3421DTO> doCreateEntity(MyEntity3421 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/myexample3421/view/myexample3421form/"
								+ CxboxMyExample3421Controller.myexample3424));
	}

	@Override
	protected ActionResultDTO<MyExample3421DTO> doUpdateEntity(MyEntity3421 entity, MyExample3421DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3421DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3421DTO> getActions() {
		return Actions.<MyExample3421DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("finish", "Save and Finish")
						.invoker((bc, dto) -> {
							MyEntity3421 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample3421DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample3421/view/myexample3421list"
									));
						})
				)
				.build();
	}


}

