package org.demo.documentation.widgets.cardcarousellist.showcondition.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.demo.documentation.widgets.cardcarousellist.showcondition.parent.MyEntity5063;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5064Service extends VersionAwareResponseService<MyExample5064DTO, MyEntity5064> {

	private final MyEntity5064Repository repository;

	private final EntityManager entityManager;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5064Meta> meta = MyExample5064Meta.class;

	@Override
	protected Specification<MyEntity5064> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity5064_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample5064DTO> doCreateEntity(MyEntity5064 entity, BusinessComponent bc) {
		entity.setCustomFieldEntity(entityManager.getReference(MyEntity5063.class, bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5064DTO> doUpdateEntity(MyEntity5064 entity, MyExample5064DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5064DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5064DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5064DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5064DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5064DTO> getActions() {
		return Actions.<MyExample5064DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
