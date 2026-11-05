package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.dictionary.DictionaryProvider;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample4300PostActionWithCustomBuilderService extends
		VersionAwareResponseService<MyExample4300PostActionWithCustomBuilderDTO, MyEntity4300PostActionWithCustomBuilder> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300PostActionWithCustomBuilderMeta> meta = MyExample4300PostActionWithCustomBuilderMeta.class;

	private final MyEntity4300MultivalueRepository multivalueRepository;
	private final DictionaryProvider dictionaryProvider;

	@Override
	protected MyExample4300PostActionWithCustomBuilderDTO entityToDto(BusinessComponent bc, MyEntity4300PostActionWithCustomBuilder entity) {
		var dto = super.entityToDto(bc, entity);
		dto.setDictionaryValues(entity.getDictionaryValues().stream().sorted(Comparator.comparing(Dictionary::key))
				.collect(MultivalueField.toMultivalueField(
						Dictionary::key, value -> dictionaryProvider.lookupValue(value).getValue())));
		return dto;
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

	@Override
	protected CreateResult<MyExample4300PostActionWithCustomBuilderDTO> doCreateEntity(final MyEntity4300PostActionWithCustomBuilder entity,
																					   final BusinessComponent bc) {
		throw new UnsupportedOperationException("doCreateEntity unsupported action");
	}

	@Override
	protected ActionResultDTO<MyExample4300PostActionWithCustomBuilderDTO> doUpdateEntity(final MyEntity4300PostActionWithCustomBuilder entity,
																						  final MyExample4300PostActionWithCustomBuilderDTO data,
																						  final BusinessComponent bc) {
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.rangeFilters, entity::setRangeFilters);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldNumberTo, entity::setCustomFieldNumberTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldMoneyTo, entity::setCustomFieldMoneyTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldPercentTo, entity::setCustomFieldPercentTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDateTo, entity::setCustomFieldDateTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDateTimeTo, entity::setCustomFieldDateTimeTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldDateTimeWithSecondsTo, entity::setCustomFieldDateTimeWithSecondsTo);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.dictionaryValue, entity::setDictionaryValue);
		setIfChanged(data, MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultifield, entity::setCustomFieldMultifield);
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.checkboxFilter)) {
			entity.setCustomFieldCheckbox("All".equals(data.getCheckboxFilter()) || data.getCheckboxFilter() == null
					? null : "Yes".equals(data.getCheckboxFilter()));
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryValues)) {
			entity.setDictionaryValues(data.getDictionaryValues().getValues().stream()
					.map(value -> Optional.ofNullable(dictionaryProvider.lookupName(
							CustomField4300Dictionary.class,
							value::getValue)).orElseThrow())
					.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.dictionaryEnumValues)) {
			entity.setDictionaryEnumValues(data.getDictionaryEnumValues().getValues().stream()
					.map(value -> CustomField4300DictionaryEnum.getByValue(value.getValue())).collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.radioValues)) {
			entity.setRadioValues(data.getRadioValues().getValues().stream()
					.map(value -> CustomField4300RadioEnum.getByValue(value.getValue())).collect(Collectors.toSet()));
		}
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

		if (data.isFieldChanged(MyExample4300PostActionWithCustomBuilderDTO_.customFieldMultivalueHover)) {
			entity.setMultivalueHoverList(baseDAO.getList(MyEntity4300MultivalueHover.class).stream()
					.filter(value -> data.getCustomFieldMultivalueHover().getValues().stream()
							.anyMatch(picked -> picked.getId().equals(String.valueOf(value.getId()))))
					.toList());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300PostActionWithCustomBuilderDTO> getActions() {

		return Actions.<MyExample4300PostActionWithCustomBuilderDTO>builder()
				.action(act -> act
						.action("filter", "Apply filters")
						.scope(ActionScope.RECORD)
						.available(bc -> true)
						.withAutoSaveBefore()
						.invoker((bc, dto) -> new ActionResultDTO<MyExample4300PostActionWithCustomBuilderDTO>()
								.setAction(MyExample4300DashboardFilters.isEmpty(dto)
										? PostAction.drillDown(DrillDownType.INNER, MyExample4300DashboardFilters.VIEW)
										: PostAction.drillDownWithFilter(
										DrillDownType.INNER, MyExample4300DashboardFilters.VIEW,
										fc -> fc
												.add(CxboxMyExample4300Controller.myExample4300DrillDown,
														MyExample4300WithDrilldownDTO.class,
														fb -> MyExample4300DashboardFilters.apply(fb, dto))
												.add(CxboxMyExample4300Controller.myExample4300DashboardStats,
														MyExample4300WithDrilldownDTO.class,
														fb -> MyExample4300DashboardFilters.apply(fb, dto))
								)))
				)
				.action(act -> act.action("clear filter", "Clear form")
						.scope(ActionScope.RECORD)
						.available(bc -> true)
						.invoker((bc, dto) -> {
									MyEntity4300PostActionWithCustomBuilder oneAsEntity = getOneAsEntity(bc);
									setAllFieldsToNull(oneAsEntity);
									oneAsEntity.setRangeFilters(false);
									return new ActionResultDTO<>(entityToDto(bc, oneAsEntity))
											.setAction(PostAction.refreshBc(bc))
											.setAction(PostAction.refreshBc(CxboxMyExample4300Controller.myExample4300DashboardStats));
								}
						)
				)
				.action(act -> act.action("expand columns", "All columns").scope(ActionScope.RECORD)
						.available(bc -> !getOneAsEntity(bc).isExpandedColumns())
						.invoker((bc, dto) -> setExpandedColumns(bc, true)))
				.action(act -> act.action("compact columns", "Compact columns").scope(ActionScope.RECORD)
						.available(bc -> getOneAsEntity(bc).isExpandedColumns())
						.invoker((bc, dto) -> setExpandedColumns(bc, false)))
				.build();
	}

	private ActionResultDTO<MyExample4300PostActionWithCustomBuilderDTO> setExpandedColumns(BusinessComponent bc, boolean expanded) {
		var entity = getOneAsEntity(bc);
		entity.setExpandedColumns(expanded);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc))
				.setAction(PostAction.refreshBc(CxboxMyExample4300Controller.myExample4300DrillDown));
	}
}
