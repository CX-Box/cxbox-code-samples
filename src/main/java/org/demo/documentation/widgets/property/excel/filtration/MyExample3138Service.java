package org.demo.documentation.widgets.property.excel.filtration;

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

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3138Service extends VersionAwareResponseService<MyExample3138DTO, MyEntity3138> {

	private final MyEntity3138Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3138Meta> meta = MyExample3138Meta.class;

	@Override
	protected Specification<MyEntity3138> getSpecification(BusinessComponent bc) {
		var fullTextSearchFilterParam = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		var specification = super.getSpecification(bc);
		return fullTextSearchFilterParam.map(e -> and(repository.getFullTextSearchSpecification(e), specification)).orElse(specification);
	}

	@Override
	protected CreateResult<MyExample3138DTO> doCreateEntity(MyEntity3138 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3138DTO> doUpdateEntity(MyEntity3138 entity, MyExample3138DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3138DTO_.parentId, entity::setParentId);
		setIfChanged(data, MyExample3138DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample3138DTO_.customFieldInput, entity::setCustomFieldInput);
		setIfChanged(data, MyExample3138DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample3138DTO_.customFieldDateTime, entity::setCustomFieldDateTime);

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3138DTO> getActions() {
		return Actions.<MyExample3138DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
