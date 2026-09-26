package org.demo.documentation.widgets.cardlist.showcondition.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.demo.documentation.widgets.cardlist.showcondition.parent.MyEntity5303;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5313Service extends VersionAwareResponseService<MyExample5313DTO, MyEntity5313> {

	private final MyEntity5313Repository repository;

	private final EntityManager entityManager;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5313Meta> meta = MyExample5313Meta.class;

	@Override
	protected Specification<MyEntity5313> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity5313_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample5313DTO> doCreateEntity(MyEntity5313 entity, BusinessComponent bc) {
		entity.setCustomFieldEntity(entityManager.getReference(MyEntity5303.class, bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5313DTO> doUpdateEntity(MyEntity5313 entity, MyExample5313DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5313DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5313DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5313DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5313DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5313DTO> getActions() {
		return Actions.<MyExample5313DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
