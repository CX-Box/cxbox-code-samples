package org.demo.documentation.additional.forceactiveshowcondition.controlperson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.additional.forceactiveshowcondition.MyEntity1432Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample1434Service extends VersionAwareResponseService<MyExample1434DTO, MyEntity1434> {

	private final MyEntity1434Repository repository;

	private final MyEntity1432Repository parentRepository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample1434Meta> meta = MyExample1434Meta.class;

	@Override
	protected Specification<MyEntity1434> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity1434_.parentEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample1434DTO> doCreateEntity(MyEntity1434 entity, BusinessComponent bc) {
		entity.setParentEntity(parentRepository.getReferenceById(bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample1434DTO> doUpdateEntity(MyEntity1434 entity, MyExample1434DTO data,
															   BusinessComponent bc) {
		setIfChanged(data, MyExample1434DTO_.fullName, entity::setFullName);
		setIfChanged(data, MyExample1434DTO_.inn, entity::setInn);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample1434DTO> getActions() {
		return Actions.<MyExample1434DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
