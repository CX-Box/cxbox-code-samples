package org.demo.documentation.other.widgetEditStyles.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.WidgetStylesTestEnum;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesInlinePicklist;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesPicklist;
import org.demo.documentation.widgets.list.colortitle.MyExample3050DTO_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class WidgetStylesService extends VersionAwareResponseService<WidgetStylesDTO, WidgetStyles> {

	private final WidgetStylesRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<WidgetStylesMeta> meta = WidgetStylesMeta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<WidgetStylesDTO> doCreateEntity(WidgetStyles entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<WidgetStylesDTO> doUpdateEntity(WidgetStyles entity, WidgetStylesDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(WidgetStylesDTO_.hidden)) {
			entity.setHidden(data.getHidden());
		}
		if (data.isFieldChanged(WidgetStylesDTO_.time)) {
			entity.setTime(data.getTime());
		}
		if (data.isFieldChanged(WidgetStylesDTO_.hint)) {
			entity.setHint(data.getHint());
		}
		if (data.isFieldChanged(WidgetStylesDTO_.multipleSelect)) {
			entity.setMultipleSelect(
					data.getMultipleSelect().getValues()
							.stream()
							.map(v -> WidgetStylesTestEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorInput)) {
			entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorText)) {
			entity.setCustomFieldColorText(data.getCustomFieldColorText());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorDateTime)) {
			entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorCheckbox)) {
			entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorDate)) {
			entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorDateTimeWithSeconds)) {
			entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorDictionary)) {
			entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorNumber)) {
			entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorPercent)) {
			entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorMoney)) {
			entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorRadio)) {
			entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorPicklistId)) {
			entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
					? entityManager.getReference(WidgetStylesPicklist.class, data.getCustomFieldColorPicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorInlinePicklistId)) {
			entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
					? entityManager.getReference(WidgetStylesInlinePicklist.class, data.getCustomFieldColorInlinePicklistId())
					: null);
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorMultivalue)) {
			entity.getCustomFieldColorMultivalueList().clear();
			entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(WidgetStylesMultiMulti.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(MyExample3050DTO_.customFieldColorMultivalueHover)) {
			entity.getCustomFieldColorMultivalueHoverList().clear();
			entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(WidgetStylesMulti.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(MyExample3050DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<WidgetStylesDTO> getActions() {
		return Actions.<WidgetStylesDTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt
						.withAutoSaveBefore()
				)
				.delete(dlt -> dlt)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}


}

