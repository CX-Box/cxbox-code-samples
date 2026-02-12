package org.demo.documentation.other.savewithparent.example3.relatedobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.other.savewithparent.example3.MyEntity3422;
import org.demo.documentation.other.savewithparent.example3.MyEntity3422Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3423Service extends VersionAwareResponseService<MyExample3423DTO, MyEntity3423> {

	private final MyEntity3423Repository repository;
	private final MyEntity3422Repository repositoryParent;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3423Meta> meta = MyExample3423Meta.class;

	@Override
	protected Specification<MyEntity3423> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity3423_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample3423DTO> doCreateEntity(MyEntity3423 entity, BusinessComponent bc) {
		MyEntity3422 myEntity3422 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
		entity.setCustomFieldEntity(myEntity3422);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3423DTO> doUpdateEntity(MyEntity3423 entity, MyExample3423DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3423DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3423DTO> getActions() {
		return Actions.<MyExample3423DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
