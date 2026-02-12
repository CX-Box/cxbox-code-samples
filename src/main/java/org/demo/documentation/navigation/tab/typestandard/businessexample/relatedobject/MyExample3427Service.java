package org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyEntity3428;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyEntity3428Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3427Service extends VersionAwareResponseService<MyExample3427DTO, MyEntity3427> {

	private final MyEntity3427Repository repository;
	private final MyEntity3428Repository repositoryParent;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3427Meta> meta = MyExample3427Meta.class;

	@Override
	protected Specification<MyEntity3427> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity3427_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample3427DTO> doCreateEntity(MyEntity3427 entity, BusinessComponent bc) {
		MyEntity3428 myEntity3428 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
		entity.setCustomFieldEntity(myEntity3428);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3427DTO> doUpdateEntity(MyEntity3427 entity, MyExample3427DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3427DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3427DTO> getActions() {
		return Actions.<MyExample3427DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
