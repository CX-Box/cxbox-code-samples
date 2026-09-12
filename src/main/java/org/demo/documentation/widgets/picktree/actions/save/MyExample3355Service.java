package org.demo.documentation.widgets.picktree.actions.save;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup.MyEntity3355Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3355Service extends VersionAwareResponseService<MyExample3355DTO, MyEntity3355> {

	private final MyEntity3355Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3355Meta> meta = MyExample3355Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3355DTO> doCreateEntity(MyEntity3355 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3355DTO> doUpdateEntity(MyEntity3355 entity, MyExample3355DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3355DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickTreeEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(MyEntity3355Pick.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3355DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3355DTO> getActions() {
		return Actions.<MyExample3355DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}

