package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel.MyEntity3198PickOnCancel;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.postaction.MyEntity3198PickPostAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3198Service extends VersionAwareResponseService<MyExample3198DTO, MyEntity3198> {

	private final MyEntity3198Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3198Meta> meta = MyExample3198Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3198DTO> doCreateEntity(MyEntity3198 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3198DTO> doUpdateEntity(MyEntity3198 entity, MyExample3198DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3198DTO_.customFieldPickListPostActionId)) {
			entity.setCustomFieldPickListPostActionEntity(data.getCustomFieldPickListPostActionId() != null
					? entityManager.getReference(MyEntity3198PickPostAction.class, data.getCustomFieldPickListPostActionId())
					: null);
		}
		if (data.isFieldChanged(MyExample3198DTO_.customFieldPickListOnCancelId)) {
			entity.setCustomFieldPickListOnCancelEntity(data.getCustomFieldPickListOnCancelId() != null
					? entityManager.getReference(MyEntity3198PickOnCancel.class, data.getCustomFieldPickListOnCancelId())
					: null);
		}
		if (data.isFieldChanged(MyExample3198DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(MyEntity3198Pick.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3198DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3198DTO> getActions() {
		return Actions.<MyExample3198DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

