package org.demo.documentation.widgets.cardcarousellist.fulltextsearch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;

import static org.cxbox.api.data.dao.SpecificationUtils.and;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5068Service extends VersionAwareResponseService<MyExample5068DTO, MyEntity5068> {

	private final MyEntity5068Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5068Meta> meta = MyExample5068Meta.class;

	@Override
	protected CreateResult<MyExample5068DTO> doCreateEntity(MyEntity5068 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5068DTO> doUpdateEntity(MyEntity5068 entity, MyExample5068DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5068DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5068DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5068DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5068DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5068DTO> getActions() {
		return Actions.<MyExample5068DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:getSpecification]
	@Override
	protected Specification<MyEntity5068> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam
				.map(value -> and(repository.getFullTextSearchSpecification(value), specification))
				.orElse(specification);
	}
	// --8<-- [end:getSpecification]

}
