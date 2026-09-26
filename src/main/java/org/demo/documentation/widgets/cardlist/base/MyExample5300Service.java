package org.demo.documentation.widgets.cardlist.base;

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

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5300Service extends VersionAwareResponseService<MyExample5300DTO, MyEntity5300> {

	private final MyEntity5300Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5300Meta> meta = MyExample5300Meta.class;

	@Override
	protected CreateResult<MyExample5300DTO> doCreateEntity(MyEntity5300 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5300DTO> doUpdateEntity(MyEntity5300 entity, MyExample5300DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5300DTO_.document, entity::setDocument);
		setIfChanged(data, MyExample5300DTO_.documentId, entity::setDocumentId);
		setIfChanged(data, MyExample5300DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5300DTO_.customFieldDescription, entity::setCustomFieldDescription);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5300DTO> getActions() {
		return Actions.<MyExample5300DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]


	@Override
	protected Specification<MyEntity5300> getSpecification(BusinessComponent bc) {
		var specification = super.getSpecification(bc);
		return FullTextSearchExt.getFullTextSearchFilterParam(bc)
				.map(value -> org.cxbox.api.data.dao.SpecificationUtils.and(
						(Specification<MyEntity5300>) (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity5300_.customField)),
						specification))
				.orElse(specification);
	}

}
