package org.demo.documentation.widgets.picktree.actions.delete;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup.MyEntity3354Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3354Service extends VersionAwareResponseService<MyExample3354DTO, MyEntity3354> {

	private final MyEntity3354Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3354Meta> meta = MyExample3354Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3354DTO> doCreateEntity(MyEntity3354 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3354DTO> doUpdateEntity(MyEntity3354 entity, MyExample3354DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3354DTO_.customFieldDeleteId)) {
			entity.setCustomFieldDeleteEntity(data.getCustomFieldDeleteId() != null
					? entityManager.getReference(MyEntity3354Pick.class, data.getCustomFieldDeleteId())
					: null);
		}
		if (data.isFieldChanged(MyExample3354DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3354DTO> getActions() {
		return Actions.<MyExample3354DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

