package org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3405PickListPopupPickService extends VersionAwareResponseService<MyEntity3405PickListPopupPickDTO, MyEntity3405PickListPopup> {
	private final MyEntity3405PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3405PickListPopupPickMeta> meta = MyEntity3405PickListPopupPickMeta.class;

	@Override
	protected CreateResult<MyEntity3405PickListPopupPickDTO> doCreateEntity(MyEntity3405PickListPopup entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3405PickListPopupPickDTO> doUpdateEntity(MyEntity3405PickListPopup entity, MyEntity3405PickListPopupPickDTO data,
																			   BusinessComponent bc) {
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldPlaceholder, entity::setCustomFieldPlaceholder);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldColor, entity::setCustomFieldColor);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldColorConst, entity::setCustomFieldColorConst);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldColorValidation, entity::setCustomFieldColorValidation);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldRequired, entity::setCustomFieldRequired);
		setIfChanged(data, MyEntity3405PickListPopupPickDTO_.customFieldColorSort, entity::setCustomFieldColorSort);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyEntity3405PickListPopupPickDTO> getActions() {
		return Actions.<MyEntity3405PickListPopupPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}