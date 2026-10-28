package org.demo.documentation.additional.forceactiveshowcondition.controlperson.taxresidency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.MyEntity1434Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample1435Service extends VersionAwareResponseService<MyExample1435DTO, MyEntity1435> {

	private final MyEntity1435Repository repository;

	private final MyEntity1434Repository parentRepository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample1435Meta> meta = MyExample1435Meta.class;

	@Override
	protected Specification<MyEntity1435> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity1435_.parentEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample1435DTO> doCreateEntity(MyEntity1435 entity, BusinessComponent bc) {
		entity.setParentEntity(parentRepository.getReferenceById(bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample1435DTO> doUpdateEntity(MyEntity1435 entity, MyExample1435DTO data,
															   BusinessComponent bc) {
		setIfChanged(data, MyExample1435DTO_.country, entity::setCountry);
		setIfChanged(data, MyExample1435DTO_.tin, entity::setTin);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample1435DTO> getActions() {
		return Actions.<MyExample1435DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
