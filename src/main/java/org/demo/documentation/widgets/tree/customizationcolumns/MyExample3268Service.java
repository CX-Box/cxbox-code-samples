package org.demo.documentation.widgets.tree.customizationcolumns;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.data.alltypes.Myexample3262;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;
import org.demo.documentation.widgets.tree.base.allType.repository.MyEntity3262Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3268Service extends VersionAwareResponseService<MyExample3268DTO, Myexample3262> {

	private final MyEntity3262Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3268Meta> meta = MyExample3268Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3268DTO> doCreateEntity(Myexample3262 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3268DTO> doUpdateEntity(Myexample3262 entity, MyExample3268DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262MultiHover.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262Multi.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3268DTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, MyExample3268DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample3268DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, MyExample3268DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
		setIfChanged(data, MyExample3268DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
		setIfChanged(data, MyExample3268DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
		setIfChanged(data, MyExample3268DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample3268DTO_.customFieldPercent, entity::setCustomFieldPercent);
		if (data.isFieldChanged(MyExample3268DTO_.customFieldPickTreeId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickTreeId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldPickTreeId())
					: null);
		}
		if (data.isFieldChanged(MyExample3268DTO_.customFieldInlineId)) {
			entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldInlineId())
					: null);
		}
		setIfChanged(data, MyExample3268DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3268DTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262Multi.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3268DTO_.customFieldHint, entity::setCustomFieldHint);
		if (data.isFieldChanged(MyExample3268DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262MultiHover.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3268DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample3268DTO_.customFieldCheckBox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample3268DTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, MyExample3268DTO_.customFieldInput, entity::setCustomField);
		if (data.isFieldChanged(MyExample3268DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3268DTO> getActions() {
		return Actions.<MyExample3268DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
