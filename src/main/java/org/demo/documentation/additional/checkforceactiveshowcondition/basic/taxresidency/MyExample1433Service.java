package org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.MyEntity1432Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample1433Service extends VersionAwareResponseService<MyExample1433DTO, MyEntity1433> {

	private final MyEntity1433Repository repository;

	private final MyEntity1432Repository parentRepository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample1433Meta> meta = MyExample1433Meta.class;

	@Override
	protected Specification<MyEntity1433> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity1433_.parentEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample1433DTO> doCreateEntity(MyEntity1433 entity, BusinessComponent bc) {
		entity.setParentEntity(parentRepository.getReferenceById(bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample1433DTO> doUpdateEntity(MyEntity1433 entity, MyExample1433DTO data,
															   BusinessComponent bc) {
		setIfChanged(data, MyExample1433DTO_.country, entity::setCountry);
		setIfChanged(data, MyExample1433DTO_.tin, entity::setTin);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample1433DTO> getActions() {
		return Actions.<MyExample1433DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
