package org.demo.documentation.additional.checkforceactiveshowcondition.common;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

/**
 * A bc of a check scenario: the records of {@link #scenario()}, by default the children of the current record of myexample1432.
 * The type parameters are declared by each service: cxbox reads the dto and the entity from the generic superclass of the service
 */
public abstract class AbstractMyExample1436Service<D extends MyExample1436DTO, E extends MyEntity1436>
		extends VersionAwareResponseService<D, E> {

	@Autowired
	protected MyEntity1436Repository repository;

	protected abstract String scenario();

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Class<? extends FieldMetaBuilder<D>> getMeta() {
		return (Class) MyExample1436Meta.class;
	}

	protected Predicate parentPredicate(Root<E> root, CriteriaBuilder cb, BusinessComponent bc) {
		return cb.equal(root.get(MyEntity1436_.parentEntity).get(BaseEntity_.id), bc.getParentIdAsLong());
	}

	@Override
	protected Specification<E> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity1436_.scenario), scenario()),
				parentPredicate(root, cb, bc)
		);
	}

	@Override
	protected CreateResult<D> doCreateEntity(E entity, BusinessComponent bc) {
		entity.setScenario(scenario());
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<D> doUpdateEntity(E entity, D data, BusinessComponent bc) {
		setIfChanged(data, MyExample1436DTO_.country, entity::setCountry);
		setIfChanged(data, MyExample1436DTO_.tin, entity::setTin);
		setIfChanged(data, MyExample1436DTO_.parentId, parentId -> entity.setParentId(parentId == null ? null : Long.valueOf(parentId)));
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<D> getActions() {
		return Actions.<D>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}
