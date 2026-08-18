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
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267InlinePicklist;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Multi;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Picklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3267Service extends VersionAwareResponseService<MyExample3267DTO, MyEntity3267> {

	private final MyEntity3267Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3267Meta> meta = MyExample3267Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3267DTO> doCreateEntity(MyEntity3267 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3267DTO> doUpdateEntity(MyEntity3267 entity, MyExample3267DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorInput)) {
			entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorText)) {
			entity.setCustomFieldColorText(data.getCustomFieldColorText());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDateTime)) {
			entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorCheckbox)) {
			entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDate)) {
			entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDateTimeWithSeconds)) {
			entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorDictionary)) {
			entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorNumber)) {
			entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorPercent)) {
			entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMoney)) {
			entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorRadio)) {
			entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorPicklistId)) {
			entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
					? entityManager.getReference(MyEntity3267Picklist.class, data.getCustomFieldColorPicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorInlinePicklistId)) {
			entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
					? entityManager.getReference(MyEntity3267InlinePicklist.class, data.getCustomFieldColorInlinePicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMultivalue)) {
			entity.getCustomFieldColorMultivalueTree().clear();
			entity.getCustomFieldColorMultivalueTree().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3267MultiMulti.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3267DTO_.customFieldColorMultivalueHover)) {
			entity.getCustomFieldColorMultivalueHoverTree().clear();
			entity.getCustomFieldColorMultivalueHoverTree().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3267Multi.class, e))
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
