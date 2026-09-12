package org.demo.documentation.widgets.picktree.allpropertiesfield;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup.MyEntity3357PickTreePopup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3357Service extends VersionAwareResponseService<MyExample3357DTO, MyEntity3357> {

	private final MyEntity3357Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3357Meta> meta = MyExample3357Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3357DTO> doCreateEntity(MyEntity3357 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3357DTO> doUpdateEntity(MyEntity3357 entity, MyExample3357DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3357DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickTreeEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(MyEntity3357PickTreePopup.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3357DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3357DTO> getActions() {
		return Actions.<MyExample3357DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

