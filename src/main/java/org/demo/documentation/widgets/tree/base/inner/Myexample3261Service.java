package org.demo.documentation.widgets.tree.base.inner;


import jakarta.persistence.criteria.Join;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.FilterParameter;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.tree.data.inner.MyEntity3261Repository;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261MetaBuilder;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.cxbox.api.data.dao.SpecificationUtils.and;
import static org.demo.documentation.widgets.tree.base.inner.Myexample3261DTO_.isIncluded;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample3261Service extends VersionAwareResponseService<Myexample3261DTO, Myexample3261> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261MetaBuilder> meta = Myexample3261MetaBuilder.class;

	private final MyEntity3261Repository myexample3261Repository;
	private final MyEntity3263Repository myexample3263Repository;

	@Override
	public Specification<Myexample3261> getSpecification(BusinessComponent bc) {
		Boolean isIncludedFilterValues = getFilterFieldName(
				bc.getParameters(),
				isIncluded.getName()
		);
		if (isIncludedFilterValues!=null) {
			return super.getSpecification(bc)
					.and(getSpecIsIncludedField(bc))
					.and(getFilterSpecification(bc));
		}
		return super.getSpecification(bc).and(getFilterSpecification(bc));
	}

	private Boolean getFilterFieldName(QueryParameters queryParameters, String fieldName) {
		return queryParameters.getFilter().getParameters().stream()
				.filter(f -> f.getName().contains(fieldName))
				.map(FilterParameter::getBooleanValue)
				.findFirst().orElse(null);
	}

	protected Specification<Myexample3261> getFilterSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam.map(e -> and(myexample3261Repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
	}

	private Specification<Myexample3261> getSpecIsIncludedField(BusinessComponent bc) {
		return (root, cq, cb) -> {
			Join<Myexample3261, Myexample3263> parentJoin =
					root.join(Myexample3261_.departments);
			return cb.and(
					super.getParentSpecification(bc).toPredicate(root, cq, cb),
					cb.equal(
							parentJoin.get(BaseEntity_.id),
							bc.getParentIdAsLong()
					)
			);
		};
	}


	@Override
	protected CreateResult<Myexample3261DTO> doCreateEntity(Myexample3261 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3261Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3261DTO> doUpdateEntity(Myexample3261 entity, Myexample3261DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3261DTO_.mnemonic, entity::setMnemonic);
		setIfChanged(data, Myexample3261DTO_.code, entity::setCode);
		setIfChanged(data, Myexample3261DTO_.description, entity::setDescription);
		setIfChanged(data, Myexample3261DTO_.department, entity::setDepartment);
		return new ActionResultDTO<>(entityToDto(bc, myexample3261Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Myexample3261DTO entityToDto(final BusinessComponent bc, final Myexample3261 entity) {
		Myexample3261DTO myexample3261DTO = super.entityToDto(bc, entity);

		if (bc.getParentId()!=null) {
			List<Long> allDepartmentIds = myexample3263Repository.findById(Long.valueOf(bc.getParentId()))
					.map(e -> e.getDepartmentsList().stream()
							.map(BaseEntity::getId)
							.toList())
					.orElse(Collections.emptyList());
			myexample3261DTO.setIsIncluded(allDepartmentIds.contains(entity.getId()));
			if(allDepartmentIds.contains(entity.getId())) {
				myexample3261DTO.setColorIncluded("#a6eda6");
			}
		}
		return myexample3261DTO;}

	@Override
	public Actions<Myexample3261DTO> getActions() {
		return Actions.<Myexample3261DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}