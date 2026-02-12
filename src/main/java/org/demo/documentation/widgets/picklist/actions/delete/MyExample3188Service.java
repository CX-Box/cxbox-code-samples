package org.demo.documentation.widgets.picklist.actions.delete;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup.MyEntity3188Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3188Service extends VersionAwareResponseService<MyExample3188DTO, MyEntity3188> {

	private final MyEntity3188Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3188Meta> meta = MyExample3188Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3188DTO> doCreateEntity(MyEntity3188 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3188DTO> doUpdateEntity(MyEntity3188 entity, MyExample3188DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3188DTO_.customFieldDeleteId)) {
			entity.setCustomFieldDeleteEntity(data.getCustomFieldDeleteId() != null
					? entityManager.getReference(MyEntity3188Pick.class, data.getCustomFieldDeleteId())
					: null);
		}
		if (data.isFieldChanged(MyExample3188DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3188DTO> getActions() {
		return Actions.<MyExample3188DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

