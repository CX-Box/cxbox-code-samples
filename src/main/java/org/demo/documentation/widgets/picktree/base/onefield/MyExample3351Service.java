package org.demo.documentation.widgets.picktree.base.onefield;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3351Service extends VersionAwareResponseService<MyExample3351DTO, MyEntity3351> {

	private final MyEntity3351Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3351Meta> meta = MyExample3351Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3351DTO> doCreateEntity(MyEntity3351 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3351DTO> doUpdateEntity(MyEntity3351 entity, MyExample3351DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3351DTO_.customFieldInlinePickTreeId)) {
			entity.setCustomFieldInlinePickTreeEntity(data.getCustomFieldInlinePickTreeId() != null
					? entityManager.getReference(MyEntity3351Pick.class, data.getCustomFieldInlinePickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3351DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickTreeEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(MyEntity3351Pick.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3351DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3351DTO> getActions() {
		return Actions.<MyExample3351DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

