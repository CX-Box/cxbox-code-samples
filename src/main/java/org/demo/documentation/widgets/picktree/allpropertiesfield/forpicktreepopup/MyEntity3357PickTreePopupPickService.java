package org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup;

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
public class MyEntity3357PickTreePopupPickService extends VersionAwareResponseService<MyEntity3357PickTreePopupPickDTO, MyEntity3357PickTreePopup> {
	private final MyEntity3357PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3357PickTreePopupPickMeta> meta = MyEntity3357PickTreePopupPickMeta.class;

	@Override
	protected CreateResult<MyEntity3357PickTreePopupPickDTO> doCreateEntity(MyEntity3357PickTreePopup entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3357PickTreePopupPickDTO> doUpdateEntity(MyEntity3357PickTreePopup entity, MyEntity3357PickTreePopupPickDTO data,
																			   BusinessComponent bc) {
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldPlaceholder, entity::setCustomFieldPlaceholder);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldColor, entity::setCustomFieldColor);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldColorConst, entity::setCustomFieldColorConst);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldColorValidation, entity::setCustomFieldColorValidation);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldRequired, entity::setCustomFieldRequired);
		setIfChanged(data, MyEntity3357PickTreePopupPickDTO_.customFieldColorSort, entity::setCustomFieldColorSort);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyEntity3357PickTreePopupPickDTO> getActions() {
		return Actions.<MyEntity3357PickTreePopupPickDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}