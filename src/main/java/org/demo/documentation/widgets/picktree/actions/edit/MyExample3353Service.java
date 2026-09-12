package org.demo.documentation.widgets.picktree.actions.edit;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.MyEntity3353Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3353Service extends VersionAwareResponseService<MyExample3353DTO, MyEntity3353> {

	private final MyEntity3353Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3353Meta> meta = MyExample3353Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3353DTO> doCreateEntity(MyEntity3353 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3353DTO> doUpdateEntity(MyEntity3353 entity, MyExample3353DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3353DTO_.customFieldInlinePickTreeId)) {
			entity.setCustomFieldInlinePickTreeEntity(data.getCustomFieldInlinePickTreeId() != null
					? entityManager.getReference(MyEntity3353Pick.class, data.getCustomFieldInlinePickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3353DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickTreeEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(MyEntity3353Pick.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3353DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3353DTO> getActions() {
		return Actions.<MyExample3353DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

