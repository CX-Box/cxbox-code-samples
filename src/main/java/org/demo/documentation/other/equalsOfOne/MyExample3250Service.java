package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOne_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3250Service extends VersionAwareResponseService<MyExample3250DTO, MyExample3250> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample3250Meta> meta = MyExample3250Meta.class;

	@Override
	protected Specification<MyExample3250> getSpecification(final BusinessComponent bc) {
		if (CxboxMyExample3250Controller.myexample3250OneToOne.isBc(bc)) {
			return ((root, query, criteriaBuilder) ->
					criteriaBuilder.isNotNull(root.get(MyExample3250_.myExample3250OneToOne).get(MyExample3250OneToOne_.myExample3250OneToOneOneToOne))
			);
		}
		if (CxboxMyExample3250Controller.myexample3250OneToMany.isBc(bc)) {
			return ((root, query, criteriaBuilder) ->
					criteriaBuilder.isNotEmpty(root.get(MyExample3250_.myExample3250OneToOne).get(MyExample3250OneToOne_.myExample3250OneToOneOneToManies))
			);
		}

		if (CxboxMyExample3250Controller.myexample3250ManyToMany.isBc(bc)) {
			return ((root, query, criteriaBuilder) ->
					criteriaBuilder.isNotEmpty(root.get(MyExample3250_.myExample3250OneToOne).get(MyExample3250OneToOne_.myExample3250OneToOneManyToMany))
			);
		}
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExample3250DTO> doCreateEntity(final MyExample3250 entity, final BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyExample3250DTO> doUpdateEntity(final MyExample3250 entity, final MyExample3250DTO data, final BusinessComponent bc) {
		return null;
	}

}

