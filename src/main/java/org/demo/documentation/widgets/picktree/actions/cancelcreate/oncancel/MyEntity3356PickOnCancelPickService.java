package org.demo.documentation.widgets.picktree.actions.cancelcreate.oncancel;

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
@Getter
@Service
public class MyEntity3356PickOnCancelPickService extends VersionAwareResponseService<MyEntity3356PickOnCancelPickDTO, MyEntity3356PickOnCancel> {
	private final MyEntity3356PickOnCancelRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3356PickOnCancelPickMeta> meta = MyEntity3356PickOnCancelPickMeta.class;

	@Override
	protected CreateResult<MyEntity3356PickOnCancelPickDTO> doCreateEntity(MyEntity3356PickOnCancel entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}


	@Override
	protected ActionResultDTO<MyEntity3356PickOnCancelPickDTO> doUpdateEntity(MyEntity3356PickOnCancel entity, MyEntity3356PickOnCancelPickDTO data,
																			  BusinessComponent bc) {
		setIfChanged(data, MyEntity3356PickOnCancelPickDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3356PickOnCancelPickDTO> getActions() {
		return Actions.<MyEntity3356PickOnCancelPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:onCancel]
	@Override
	public ActionResultDTO onCancel(BusinessComponent bc) {
		return new ActionResultDTO<>().setAction(PostAction.drillDown(
				DrillDownType.INNER,
				"/screen/myexample3353/view/myexample3348inlinecreatelist"
		));
	}
	// --8<-- [end:onCancel]
}