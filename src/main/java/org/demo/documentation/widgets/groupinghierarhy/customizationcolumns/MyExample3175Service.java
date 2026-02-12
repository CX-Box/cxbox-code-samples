package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175InlinePick;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHover;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Pick;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3175Service extends VersionAwareResponseService<MyExample3175DTO, MyEntity3175> {

	private final MyEntity3175Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3175Meta> meta = MyExample3175Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3175DTO> doCreateEntity(MyEntity3175 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3175DTO> doUpdateEntity(MyEntity3175 entity, MyExample3175DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3175DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, MyExample3175DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample3175DTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, MyExample3175DTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, MyExample3175DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
		setIfChanged(data, MyExample3175DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
		setIfChanged(data, MyExample3175DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
		setIfChanged(data, MyExample3175DTO_.customFieldNumber, entity::setCustomFieldNumber);
		if (data.isFieldChanged(MyExample3175DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(MyEntity3175Pick.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample3175DTO_.customFieldInlineId)) {
			entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
					? entityManager.getReference(MyEntity3175InlinePick.class, data.getCustomFieldInlineId())
					: null);
		}
		setIfChanged(data, MyExample3175DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample3175DTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(MyExample3175DTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample3175DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3175Multi.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3175DTO_.customFieldHint, entity::setCustomFieldHint);
		if (data.isFieldChanged(MyExample3175DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3175MultiHover.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3175DTO_.customFieldPercent, entity::setCustomFieldPercent);
		setIfChanged(data, MyExample3175DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample3175DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3175DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3175DTO> getActions() {
		return Actions.<MyExample3175DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

