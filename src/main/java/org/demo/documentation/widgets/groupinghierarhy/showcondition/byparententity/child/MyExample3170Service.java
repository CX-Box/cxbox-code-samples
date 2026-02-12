package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3170Service extends VersionAwareResponseService<MyExample3170DTO, MyEntity3170> {

	private final MyEntity3170Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3170Meta> meta = MyExample3170Meta.class;

	@Override
	protected Specification<MyEntity3170> getParentSpecification(BusinessComponent bc) {

		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity3170_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample3170DTO> doCreateEntity(MyEntity3170 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3170DTO> doUpdateEntity(MyEntity3170 entity, MyExample3170DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3170DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3170DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3170DTO> getActions() {
		return Actions.<MyExample3170DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

