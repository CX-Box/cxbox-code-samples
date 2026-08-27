package org.demo.documentation.widgets.tree.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.base.allType.Myexample3262;
import org.demo.documentation.widgets.tree.base.allType.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.Myexample3262MultiHover;
import org.demo.documentation.widgets.tree.base.allType.Myexample3262Pick;
import org.demo.repository.core.Myexample3262Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3267Service extends VersionAwareResponseService<MyExample3267DTO, Myexample3262> {

	private final Myexample3262Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3267Meta> meta = MyExample3267Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3267DTO> doCreateEntity(Myexample3262 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3267DTO> doUpdateEntity(Myexample3262 entity, MyExample3267DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorInput)) {
			entity.setCustomField(data.getCustomFieldColorInput());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorText)) {
			entity.setCustomFieldText(data.getCustomFieldColorText());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDateTime)) {
			entity.setCustomFieldDateTime(data.getCustomFieldColorDateTime());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorCheckbox)) {
			entity.setCustomFieldCheckbox(data.getCustomFieldColorCheckbox());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDate)) {
			entity.setCustomFieldDate(data.getCustomFieldColorDate());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDateTimeWithSeconds)) {
			entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDictionary)) {
			entity.setCustomFieldDictionary(data.getCustomFieldColorDictionary());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldFileUploadId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldFileUpload(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorNumber)) {
			entity.setCustomFieldNumber(data.getCustomFieldColorNumber());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorPercent)) {
			entity.setCustomFieldPercent(data.getCustomFieldColorPercent());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMoney)) {
			entity.setCustomFieldMoney(data.getCustomFieldColorMoney());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorRadio)) {
			entity.setCustomFieldRadio(data.getCustomFieldColorRadio());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorPicklistId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldColorPicklistId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldColorPicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorInlinePicklistId)) {
			entity.setCustomFieldInlineEntity(data.getCustomFieldColorInlinePicklistId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldColorInlinePicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262Multi.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262MultiHover.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3267DTO> getActions() {
		return Actions.<MyExample3267DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
