package org.demo.documentation.widgets.picktree.base.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3343Service extends VersionAwareResponseService<MyExample3343DTO, MyEntity3343> {

	private final MyEntity3343Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3343Meta> meta = MyExample3343Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3343DTO> doCreateEntity(MyEntity3343 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3343DTO> doUpdateEntity(MyEntity3343 entity, MyExample3343DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3343DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3343DTO_.customFieldFileUploadeId, entity::setCustomFieldFileUploadeId);
		setIfChanged(data, MyExample3343DTO_.customFieldFileUploade, entity::setCustomFieldFileUploade);
		setIfChanged(data, MyExample3343DTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(MyExample3343DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3343Multi.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(org.demo.documentation.widgets.picktree.base.allfields.MyExample3343DTO_.customFieldInlinePickTreeId)) {
			entity.setCustomFieldInlinePickTreeEntity(data.getCustomFieldInlinePickTreeId() != null
					? entityManager.getReference(MyEntity3343Pick.class, data.getCustomFieldInlinePickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3343DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3343Pick.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3343DTO> getActions() {
		return Actions.<MyExample3343DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
