package org.demo.documentation.widgets.picklist.allpropertiesfield;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup.MyEntity3405PickListPopup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3405Service extends VersionAwareResponseService<MyExample3405DTO, MyEntity3405> {

	private final MyEntity3405Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3405Meta> meta = MyExample3405Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3405DTO> doCreateEntity(MyEntity3405 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3405DTO> doUpdateEntity(MyEntity3405 entity, MyExample3405DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3405DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(MyEntity3405PickListPopup.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3405DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3405DTO> getActions() {
		return Actions.<MyExample3405DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

