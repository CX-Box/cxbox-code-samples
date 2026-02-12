package org.demo.documentation.widgets.picklist.actions.edit;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3092Service extends VersionAwareResponseService<MyExample3092DTO, MyEntity3092> {

	private final MyEntity3092Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3092Meta> meta = MyExample3092Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3092DTO> doCreateEntity(MyEntity3092 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3092DTO> doUpdateEntity(MyEntity3092 entity, MyExample3092DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3092DTO_.customFieldInlinePickListId)) {
			entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
					? entityManager.getReference(MyEntity3092Pick.class, data.getCustomFieldInlinePickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3092DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(MyEntity3092Pick.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3092DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3092DTO> getActions() {
		return Actions.<MyExample3092DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

