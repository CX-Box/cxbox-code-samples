package org.demo.documentation.widgets.tree.base.inner;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.tree.data.inner.MyEntity3261Repository;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import static org.cxbox.api.data.dao.SpecificationUtils.and;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class Myexample3261PickService extends VersionAwareResponseService<Myexample3261PickDTO, Myexample3261> {

	private final MyEntity3261Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3261PickMeta> meta = Myexample3261PickMeta.class;

	@Override
	protected CreateResult<Myexample3261PickDTO> doCreateEntity(Myexample3261 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<Myexample3261PickDTO> doUpdateEntity(Myexample3261 entity, Myexample3261PickDTO data,
	                                                               BusinessComponent bc) {
		setIfChanged(data, Myexample3261PickDTO_.mnemonic, entity::setMnemonic);
		setIfChanged(data, Myexample3261PickDTO_.code, entity::setCode);
		setIfChanged(data, Myexample3261PickDTO_.description, entity::setDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	protected Specification<Myexample3261> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
	}


}