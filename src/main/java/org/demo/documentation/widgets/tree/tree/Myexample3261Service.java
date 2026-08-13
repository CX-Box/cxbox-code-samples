package org.demo.documentation.widgets.tree.tree;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.cxbox.api.data.dao.SpecificationUtils.and;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample3261Service extends VersionAwareResponseService<Myexample3261DTO, Myexample3261> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261MetaBuilder> meta = Myexample3261MetaBuilder.class;

	private final MyEntity3261Repository myexample3261Repository;



	@Override
	protected CreateResult<Myexample3261DTO> doCreateEntity(Myexample3261 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3261Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3261DTO> doUpdateEntity(Myexample3261 entity, Myexample3261DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3261DTO_.department, entity::setDepartment);
		return new ActionResultDTO<>(entityToDto(bc, myexample3261Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3261DTO> getActions() {
		return Actions.<Myexample3261DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
	@Override
	protected Specification<Myexample3261> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam.map(e -> and(myexample3261Repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
	}

}
