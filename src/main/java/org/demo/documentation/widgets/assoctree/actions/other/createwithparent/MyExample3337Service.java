package org.demo.documentation.widgets.assoctree.actions.other.createwithparent;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assoc.MyEntity3339;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assocreq.MyEntity3340;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyEntity3338;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyEntity3338Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3337Service extends VersionAwareResponseService<MyExample3337DTO, MyEntity3337> {

	private final MyEntity3337Repository repository;
	private final MyEntity3338Repository repositoryParent;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3337Meta> meta = MyExample3337Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected Specification<MyEntity3337> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity3337_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample3337DTO> doCreateEntity(MyEntity3337 entity, BusinessComponent bc) {
		MyEntity3338 myEntity3338 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
		entity.setCustomFieldEntity(myEntity3338);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3337DTO> doUpdateEntity(MyEntity3337 entity, MyExample3337DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3337DTO_.customFieldReq)) {
			entity.getCustomFieldReqList().clear();
			entity.getCustomFieldReqList().addAll(data.getCustomFieldReq().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3340.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3337DTO_.customFieldTextReq, entity::setCustomFieldTextReq);
		setIfChanged(data, MyExample3337DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3337DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3339.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3337DTO> getActions() {
		return Actions.<MyExample3337DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
