package org.demo.documentation.widgets.list.base.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi2;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Pick;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Pick2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3002Service extends VersionAwareResponseService<MyExample3002DTO, MyEntity3002> {

	private final MyEntity3002Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3002Meta> meta = MyExample3002Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3002DTO> doCreateEntity(MyEntity3002 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3002DTO> doUpdateEntity(MyEntity3002 entity, MyExample3002DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3002DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3002Multi.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldHint)) {
			entity.setCustomFieldHint(data.getCustomFieldHint());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3002Multi2.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldInlineId)) {
			entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
					? entityManager.getReference(MyEntity3002Pick.class, data.getCustomFieldInlineId())
					: null);
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(MyEntity3002Pick2.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldRadio)) {
			entity.setCustomFieldRadio(data.getCustomFieldRadio());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldMoney)) {
			entity.setCustomFieldMoney(data.getCustomFieldMoney());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldPercent)) {
			entity.setCustomFieldPercent(data.getCustomFieldPercent());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldNumber)) {
			entity.setCustomFieldNumber(data.getCustomFieldNumber());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldFileUploadId)) {
			entity.setCustomFieldFileUploadId(data.getCustomFieldFileUploadId());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldFileUpload)) {
			entity.setCustomFieldFileUpload(data.getCustomFieldFileUpload());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldDictionary)) {
			entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldDateTimeWithSeconds)) {
			entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldDate)) {
			entity.setCustomFieldDate(data.getCustomFieldDate());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldCheckbox)) {
			entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldDateTime)) {
			entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldText)) {
			entity.setCustomFieldText(data.getCustomFieldText());
		}
		if (data.isFieldChanged(MyExample3002DTO_.customFieldHidden)) {
			entity.setCustomFieldHidden(data.getCustomFieldHidden());
		}

		if (data.isFieldChanged(MyExample3002DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3002DTO> getActions() {
		return Actions.<MyExample3002DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}