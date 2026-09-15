package org.demo.documentation.widgets.calendarlist.showcondition.byparententity.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent.MyEntity5058Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5059Service extends VersionAwareResponseService<MyExample5059DTO, MyEntity5059> {

	private final MyEntity5059Repository repository;

	private final MyEntity5058Repository repositoryParent;

	@Override
	protected Specification<MyEntity5059> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity5059_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5059Meta> meta = MyExample5059Meta.class;

	@Override
	protected CreateResult<MyExample5059DTO> doCreateEntity(MyEntity5059 entity, BusinessComponent bc) {
		entity.setCustomFieldEntity(repositoryParent.getReferenceById(bc.getParentIdAsLong()));
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5059DTO> doUpdateEntity(MyEntity5059 entity, MyExample5059DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5059DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5059DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5059DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5059DTO> getActions() {
		return Actions.<MyExample5059DTO>builder()
				.create(crt -> crt.text("Create"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}
