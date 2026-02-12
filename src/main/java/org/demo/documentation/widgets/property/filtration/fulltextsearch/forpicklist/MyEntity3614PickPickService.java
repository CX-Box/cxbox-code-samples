package org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.cxbox.api.data.dao.SpecificationUtils.and;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3614PickPickService extends VersionAwareResponseService<MyEntity3614PickPickDTO, MyEntity3614Pick> {

	private final MyEntity3614PickRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3614PickPickMeta> meta = MyEntity3614PickPickMeta.class;

	// --8<-- [start:getSpecification]
	@Override
	protected Specification<MyEntity3614Pick> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
	}
	// --8<-- [end:getSpecification]

	@Override
	protected CreateResult<MyEntity3614PickPickDTO> doCreateEntity(MyEntity3614Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3614PickPickDTO> doUpdateEntity(MyEntity3614Pick entity, MyEntity3614PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3614PickPickDTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyEntity3614PickPickDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3614PickPickDTO> getActions() {
		return Actions.<MyEntity3614PickPickDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}