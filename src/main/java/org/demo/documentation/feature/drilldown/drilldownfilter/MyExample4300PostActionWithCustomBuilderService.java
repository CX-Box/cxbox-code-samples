package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;

@Service
@RequiredArgsConstructor
public class MyExample4300PostActionWithCustomBuilderService extends
		VersionAwareResponseService<MyExample4300PostActionWithCustomBuilderDTO, MyEntity4300PostActionWithCustomBuilder> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300PostActionWithCustomBuilderMeta> meta = MyExample4300PostActionWithCustomBuilderMeta.class;

	private final MyEntity4300MultivalueRepository multivalueRepository;

	@Override
	protected CreateResult<MyExample4300PostActionWithCustomBuilderDTO> doCreateEntity(final MyEntity4300PostActionWithCustomBuilder entity,
																																										 final BusinessComponent bc) {
		throw new UnsupportedOperationException("doCreateEntity unsupported action");
	}

	@Override
	protected ActionResultDTO<MyExample4300PostActionWithCustomBuilderDTO> doUpdateEntity(final MyEntity4300PostActionWithCustomBuilder entity,
																																												final MyExample4300PostActionWithCustomBuilderDTO data,
																																												final BusinessComponent bc) {
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldPercent, entity::setCustomFieldPercent);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomField4300MultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldHint, entity::setCustomFieldHint);
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultivalue)) {
			entity.setMultivalueList(
					multivalueRepository.findAllById(data.getCustomFieldMultivalue().getValues().stream().map(MultivalueFieldSingleValue::getId)
							.map(Long::valueOf).toList())
			);
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomField4300MultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldPickList)) {
			entity.setMyEntity4300PickList(data.getCustomFieldPickList() != null
					? baseDAO.findById(MyEntity4300PickList.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldInlinePickList)) {
			entity.setMyEntity4300InlinePickList(data.getCustomFieldInlinePickList() != null
					? baseDAO.findById(MyEntity4300InlinePickList.class, data.getCustomFieldInlinePickListId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300PostActionWithCustomBuilderDTO> getActions() {

		return Actions.<MyExample4300PostActionWithCustomBuilderDTO>builder()
				.action(act -> act
						.action("filter", "Filter")
						.scope(ActionScope.RECORD)
						.available(bc -> true)
						.invoker((bc, dto) -> doUpdateEntity(getOneAsEntity(bc), dto, bc)
								.setAction(PostAction.drillDownWithFilter(
										DrillDownType.INNER,
										"screen/MyExample4300/view/MyExample4300PostAction/",
										fc -> fc.add(
												CxboxMyExample4300Controller.myExample4300DrillDown,
												MyExample4300WithDrilldownDTO.class, Custom4300FilterBuilder.type(), fb -> fb
														.customMultiValue(MyExample4300WithDrilldownDTO_.customFieldMultivalue, dto.getCustomFieldMultivalue())
														.customMultipleSelect(MyExample4300WithDrilldownDTO_.customFieldMultipleSelect, dto.getCustomFieldMultipleSelect())
														.customInlinePickList(MyExample4300WithDrilldownDTO_.customFieldInlinePickList, dto.getCustomFieldInlinePickList())
														.customPickList(MyExample4300WithDrilldownDTO_.customFieldPickList, dto.getCustomFieldPickList())
														.customRadio(
																MyExample4300WithDrilldownDTO_.customFieldRadio,
																Optional.ofNullable(dto.getCustomFieldRadio()).map(List::of).orElse(List.of())
														)
														.customMoney(MyExample4300WithDrilldownDTO_.customFieldMoney, dto.getCustomFieldMoney())
														.customPercent(MyExample4300WithDrilldownDTO_.customFieldPercent, dto.getCustomFieldPercent())
														.customNumber(MyExample4300WithDrilldownDTO_.customFieldNumber, dto.getCustomFieldNumber())
														.customFileUpload(MyExample4300WithDrilldownDTO_.customFieldFileUpload, dto.getCustomFieldFileUpload())
														.customDateTime(MyExample4300WithDrilldownDTO_.customFieldDateTimeWithSeconds, dto.getCustomFieldDateTimeWithSeconds())
														.customDate(
																MyExample4300WithDrilldownDTO_.customFieldDate,
																Optional.ofNullable(dto.getCustomFieldDate()).map(LocalDate::from).orElse(null)
														)
														.customCheckbox(MyExample4300WithDrilldownDTO_.customFieldCheckbox, dto.getCustomFieldCheckbox())
														.customDateTime(MyExample4300WithDrilldownDTO_.customFieldDateTime, dto.getCustomFieldDateTime())
														.customText(MyExample4300WithDrilldownDTO_.customFieldText, dto.getCustomFieldText())
														.customInlinePickList(MyExample4300WithDrilldownDTO_.customField, dto.getCustomField())
										)
								)))
				)
				.action(act -> act.action("clear filter", "clear filter")
						.scope(ActionScope.RECORD)
						.available(bc -> true)
						.invoker((bc, dto) -> {
									MyEntity4300PostActionWithCustomBuilder oneAsEntity = getOneAsEntity(bc);
									setAllFieldsToNull(oneAsEntity);
									return new ActionResultDTO<>(entityToDto(bc, oneAsEntity)).setAction(PostAction.refreshBc(bc));
								}
						)
				)
				.build();
	}

	@SneakyThrows
	public static void setAllFieldsToNull(Object obj) {
		if (obj == null) {
			return;
		}

		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			// Construct the setter method name
			if (field.getName().equals("id")) {
				continue;
			}
			String fieldName = field.getName();
			String setterMethodName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
			Method setter = clazz.getMethod(setterMethodName, field.getType());

			if (Collection.class.isAssignableFrom(field.getType())) {
				// Handle collections: set to empty instance
				if (List.class.isAssignableFrom(field.getType())) {
					setter.invoke(obj, new ArrayList<>());
				} else if (Set.class.isAssignableFrom(field.getType())) {
					setter.invoke(obj, new HashSet<>());
				} else if (Map.class.isAssignableFrom(field.getType())) {
					setter.invoke(obj, new HashMap<>()); // Assuming Map is also desired to be emptied
				}
				// Add more collection types as needed
			} else if (!field.getType().isPrimitive()) {
				// Handle reference types: set to null
				setter.invoke(obj, (Object) null);
			}
		}
	}

}