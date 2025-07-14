package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.type.TypeReference;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.constgen.DtoField;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.service.drilldown.filter.FB;
import org.cxbox.dictionary.Dictionary;

import jakarta.validation.constraints.NotNull;

/**
 * Example of extending the {@link FB} class to add custom field types.
 * <p>
 * This class demonstrates how to inherit from the base filter and implement
 * additional filtering fields specific to your business requirements.
 * </p>
 *
 * <p>Usage example:</p>
 * <pre>{@code
 *     Custom4300FilterBuilder<D> builder = new Custom4300FilterBuilder<>()
 *         .customField1(DTOField.customField1, valueCustomField1)
 *         .customFieldWithCollection(DTOField.customField2, List.of(valueCustomField2, valueCustomField3))
 *      }
 * </pre>
 *
 * @param <D> the type of DTO extending {@link DataResponseDTO}
 */
@Slf4j
public class Custom4300FilterBuilder<D extends DataResponseDTO> extends FB<D, Custom4300FilterBuilder<D>> {

	public static final String LOG_MESSAGE = "{}:{}";

	public static final String LOG_MESSAGE_RANGE = "{}:{} {}";

	/**
	 * Returns a {@link TypeReference} for {@link Custom4300FilterBuilder} with the specified DTO type.
	 *
	 * @param <D> the type of DTO extending {@link DataResponseDTO}
	 * @return a {@link TypeReference} for {@link Custom4300FilterBuilder} with the specified DTO type
	 */
	public static <D extends DataResponseDTO> TypeReference<Custom4300FilterBuilder<D>> type() {
		return new TypeReference<>() {
		};
	}

	public <T extends Dictionary> Custom4300FilterBuilder<D> customDictionary(@NotNull final DtoField<? super D, T> field, final T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dictionary(field, value));
	}

	public Custom4300FilterBuilder<D> customInput(@NotNull final DtoField<? super D, String> field, final String value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().input(field, value));
	}

	public <T extends Dictionary> Custom4300FilterBuilder<D> customDictionary(@NonNull DtoField<? super D, T> field, Collection<T> values) {
		log.info(
				LOG_MESSAGE,
				field.getName(),
				Optional.ofNullable(values).orElse(List.of()).stream().map(Dictionary::key).collect(Collectors.joining(","))
		);
		if (values == null || values.isEmpty()) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dictionary(field, values));

	}

	public <T extends Enum<?>> Custom4300FilterBuilder<D> customDictionaryEnum(@NonNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dictionaryEnum(field, value));
	}

	public <T extends Enum<?>> Custom4300FilterBuilder<D> customDictionaryEnum(@NonNull DtoField<? super D, T> field, Collection<T> values) {
		log.info(LOG_MESSAGE, field.getName(), Optional.ofNullable(values).orElse(List.of()).stream().map(Enum::name).collect(Collectors.joining(",")));
		if (values == null || values.isEmpty()) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dictionaryEnum(field, values));
	}

	public Custom4300FilterBuilder<D> customDate(@NonNull DtoField<? super D, LocalDateTime> field, LocalDate value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().date(field, value));
	}

	public Custom4300FilterBuilder<D> customDateFromTo(@NonNull DtoField<? super D, LocalDateTime> field, LocalDate from, LocalDate to) {
		log.info(LOG_MESSAGE_RANGE, field.getName(), from, to);

		if (from == null && to == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dateFromTo(field, from, to));
	}

	public Custom4300FilterBuilder<D> customDateTime(@NonNull DtoField<? super D, LocalDateTime> field, LocalDateTime value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dateTime(field, value));
	}

	public Custom4300FilterBuilder<D> customDateTimeFromTo(@NonNull DtoField<? super D, LocalDateTime> field, LocalDateTime from, LocalDateTime to) {
		log.info(LOG_MESSAGE_RANGE, field.getName(), from, to);
		if (from == null && to == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().dateTimeFromTo(field, from, to));
	}

	public Custom4300FilterBuilder<D> customMultiValue(@NonNull DtoField<? super D, MultivalueField> field, MultivalueField value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().multiValue(field, value));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customNumber(@NonNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().number(field, value));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customNumberFromTo(@NonNull DtoField<? super D, T> field, T from, T to) {
		log.info(LOG_MESSAGE_RANGE, field.getName(), from, to);
		if (from == null && to == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().numberFromTo(field, from, to));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customPercent(@NonNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().percent(field, value));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customPercentFromTo(@NonNull DtoField<? super D, T> field, T from, T to) {
		log.info(LOG_MESSAGE_RANGE, field.getName(), from, to);
		if (from == null && to == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().percentFromTo(field, from, to));
	}

	public <T extends Enum<?>> Custom4300FilterBuilder<D> customRadio(@NotNull DtoField<? super D, T> field, Collection<T> values) {
		log.info(LOG_MESSAGE, field.getName(), Optional.ofNullable(values).orElse(List.of()).stream().map(Enum::name).collect(Collectors.joining(",")));
		if (values == null || values.isEmpty()) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().radio(field, values));
	}

	public Custom4300FilterBuilder<D> customCheckbox(@NotNull DtoField<? super D, Boolean> field, Boolean value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().checkbox(field, value));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customMoney(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().money(field, value));
	}

	public <T extends Number> Custom4300FilterBuilder<D> customMoneyFromTo(@NotNull DtoField<? super D, T> field, T from, T to) {
		log.info(LOG_MESSAGE_RANGE, field.getName(), from, to);
		if (from == null && to == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().moneyFromTo(field, from, to));

	}

	public <T extends Serializable> Custom4300FilterBuilder<D> customFileUpload(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().fileUpload(field, value));
	}

	public <T extends Serializable> Custom4300FilterBuilder<D> customPickList(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().pickList(field, value));
	}

	public <T extends Serializable> Custom4300FilterBuilder<D> customInlinePickList(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().inlinePickList(field, value));
	}

	public <T extends Serializable> Custom4300FilterBuilder<D> customMultifield(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().multifield(field, value));
	}

	public <T extends Serializable> Custom4300FilterBuilder<D> customSuggestionPickList(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().suggestionPickList(field, value));
	}

	public <T extends MultivalueField> Custom4300FilterBuilder<D> customMultivalueHover(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().multivalueHover(field, value));
	}

	public <T extends MultivalueField> Custom4300FilterBuilder<D> customMultipleSelect(@NotNull DtoField<? super D, T> field, T value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return self();
		}
		return this.add(getPlatformDrilldownFilterService().multipleSelect(field, value));
	}

	public Custom4300FilterBuilder<D> customText(@NonNull DtoField<? super D, String> field, String value) {
		log.info(LOG_MESSAGE, field.getName(), value);
		if (value == null) {
			return this.self();
		}
		return this.add(getPlatformDrilldownFilterService().text(field, value));
	}

}
