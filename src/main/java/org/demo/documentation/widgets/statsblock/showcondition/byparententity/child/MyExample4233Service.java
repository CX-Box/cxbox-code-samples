package org.demo.documentation.widgets.statsblock.showcondition.byparententity.child;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4233Service extends VersionAwareResponseService<MyExample4233DTO, MyEntity4233> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4233Meta> meta = MyExample4233Meta.class;

	@Override
	protected Specification<MyEntity4233> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity4233_.customFieldEntity).get(BaseEntity_.id), bc.getParentIdAsLong())
		);
	}

	@Override
	protected CreateResult<MyExample4233DTO> doCreateEntity(MyEntity4233 entity, BusinessComponent bc) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected ActionResultDTO<MyExample4233DTO> doUpdateEntity(MyEntity4233 entity, MyExample4233DTO data, BusinessComponent bc) {
		throw new UnsupportedOperationException();
	}

}
