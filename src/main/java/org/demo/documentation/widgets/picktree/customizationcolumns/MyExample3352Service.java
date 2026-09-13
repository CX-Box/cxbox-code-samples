package org.demo.documentation.widgets.picktree.customizationcolumns;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3352Service extends VersionAwareResponseService<MyExample3352DTO, MyEntity3352> {

	private final MyEntity3352Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3352Meta> meta = MyExample3352Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3352DTO> doCreateEntity(MyEntity3352 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3352DTO> doUpdateEntity(MyEntity3352 entity, MyExample3352DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3352DTO_.customFieldPicktreeId)) {
			entity.setCustomFieldPicktreeEntity(data.getCustomFieldPicktreeId() != null
					? entityManager.getReference(MyEntity3352Pick.class, data.getCustomFieldPicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3352DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3352DTO> getActions() {
		return Actions.<MyExample3352DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

