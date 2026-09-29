package org.demo.documentation.widgets.property.filtration.fulltextsearch.forcardlist;

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
public class MyEntity3614CardService extends VersionAwareResponseService<MyEntity3614CardDTO, MyEntity3614Card> {

	private final MyEntity3614CardRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3614CardMeta> meta = MyEntity3614CardMeta.class;

	@Override
	protected CreateResult<MyEntity3614CardDTO> doCreateEntity(MyEntity3614Card entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3614CardDTO> doUpdateEntity(MyEntity3614Card entity, MyEntity3614CardDTO data, BusinessComponent bc) {
		setIfChanged(data, MyEntity3614CardDTO_.document, entity::setDocument);
		setIfChanged(data, MyEntity3614CardDTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyEntity3614CardDTO_.customField, entity::setCustomField);
		setIfChanged(data, MyEntity3614CardDTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3614CardDTO> getActions() {
		return Actions.<MyEntity3614CardDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:getSpecification]
	@Override
	protected Specification<MyEntity3614Card> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam
				.map(value -> and(repository.getFullTextSearchSpecification(value), specification))
				.orElse(specification);
	}
	// --8<-- [end:getSpecification]

}
