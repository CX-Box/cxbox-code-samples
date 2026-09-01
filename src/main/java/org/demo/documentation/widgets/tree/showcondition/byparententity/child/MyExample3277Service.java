package org.demo.documentation.widgets.tree.showcondition.byparententity.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.widgets.tree.showcondition.byparententity.PlatformMyExample3277Controller;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3277Service extends VersionAwareResponseService<MyExample3277DTO, MyEntity3277> {

	private final MyEntity3277Repository repository;

	private final MyEntity3276Repository repositoryParent;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3277Meta> meta = MyExample3277Meta.class;

	@Override
	protected Specification<MyEntity3277> getParentSpecification(BusinessComponent bc) {

		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity3277_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample3277DTO> doCreateEntity(MyEntity3277 entity, BusinessComponent bc) {
		MyEntity3276 myEntity3276 = repositoryParent.findById(bc.getParentIdAsLong()).orElse(null);
		entity.setCustomFieldEntity(myEntity3276);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3277DTO> doUpdateEntity(MyEntity3277 entity, MyExample3277DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3277DTO_.parentTreeId, entity::setParentTreeId);
		setIfChanged(data, MyExample3277DTO_.customFieldMoney, entity::setCustomFieldMoney);

		setIfChanged(data, MyExample3277DTO_.isLeaf, entity::setIsLeaf);
		setIfChanged(data, MyExample3277DTO_.customField, entity::setCustomField);

		return new ActionResultDTO<>(entityToDto(bc, entity)).setAction(
				PostAction.refreshBc(PlatformMyExample3277Controller.myexample3277
				));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3277DTO> getActions() {
		return Actions.<MyExample3277DTO>builder()
				.action(act -> act.action("save", "save")
						.invoker((bc, dto) -> {
							return new ActionResultDTO<MyExample3277DTO>().setAction(
									PostAction.refreshBc(PlatformMyExample3277Controller.myexample3277
									));
						}))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}