package org.demo.documentation.widgets.picktree.actions.cancelcreate;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.basic.MyEntity3356Pick;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.oncancel.MyEntity3356PickOnCancel;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.postaction.MyEntity3356PickPostAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3356Service extends VersionAwareResponseService<MyExample3356DTO, MyEntity3356> {

	private final MyEntity3356Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3356Meta> meta = MyExample3356Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3356DTO> doCreateEntity(MyEntity3356 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3356DTO> doUpdateEntity(MyEntity3356 entity, MyExample3356DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3356DTO_.customFieldPickTreePostActionId)) {
			entity.setCustomFieldPickTreePostActionEntity(data.getCustomFieldPickTreePostActionId() != null
					? entityManager.getReference(MyEntity3356PickPostAction.class, data.getCustomFieldPickTreePostActionId())
					: null);
		}
		if (data.isFieldChanged(MyExample3356DTO_.customFieldPickTreeOnCancelId)) {
			entity.setCustomFieldPickTreeOnCancelEntity(data.getCustomFieldPickTreeOnCancelId() != null
					? entityManager.getReference(MyEntity3356PickOnCancel.class, data.getCustomFieldPickTreeOnCancelId())
					: null);
		}
		if (data.isFieldChanged(MyExample3356DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickTreeEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(MyEntity3356Pick.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3356DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3356DTO> getActions() {
		return Actions.<MyExample3356DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

