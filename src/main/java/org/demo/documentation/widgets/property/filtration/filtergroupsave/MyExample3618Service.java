package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist.MyEntity3618Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3618Service extends VersionAwareResponseService<MyExample3618DTO, MyEntity3618> {

	private final MyEntity3618Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3618Meta> meta = MyExample3618Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3618DTO> doCreateEntity(MyEntity3618 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3618DTO> doUpdateEntity(MyEntity3618 entity, MyExample3618DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3618DTO_.customFieldPicklistId)) {
			entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
					? entityManager.getReference(MyEntity3618Pick.class, data.getCustomFieldPicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3618DTO_.customFieldMultivalueDisplayedKey)) {
			entity.getCustomFieldMultivalueDisplayedKeyList().clear();
			entity.getCustomFieldMultivalueDisplayedKeyList().addAll(data.getCustomFieldMultivalueDisplayedKey().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3624.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3618DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3618DTO_.customFieldNew, entity::setCustomFieldNew);
		if (data.isFieldChanged(MyExample3618DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3618DTO> getActions() {
		return Actions.<MyExample3618DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

