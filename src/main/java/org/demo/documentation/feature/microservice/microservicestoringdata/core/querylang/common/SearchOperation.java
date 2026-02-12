package org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum SearchOperation {
	/**
	 * Greater or equal
	 */
	GREATER_OR_EQUAL_THAN("greaterOrEqualThan", false),

	/**
	 * Less or equal
	 */
	LESS_OR_EQUAL_THAN("lessOrEqualThan", false),

	/**
	 * Contains
	 */
	CONTAINS("contains", false),

	/**
	 * Equal
	 */
	EQUALS("equals", false),

	/**
	 * Equal to one of the list
	 */
	EQUALS_ONE_OF("equalsOneOf", true),

	/**
	 * Specified
	 */
	SPECIFIED("specified", false);

	/**
	 * Greater
	 * <p>
	 * GREATER_THAN("greaterThan"),
	 * <p>
	 * /**
	 * Less
	 * <p>
	 * LESS_THAN("lessThan"),
	 * <p>
	 * <p>
	 * /**
	 * Boolean value specified, use for sql entities
	 * <p>
	 * SPECIFIED_BOOLEAN_SQL("specifiedBooleanSql"),
	 * <p>
	 * /**
	 * Contains one from the list
	 * <p>
	 * CONTAINS_ONE_OF("containsOneOf"),
	 * <p>
	 * /**
	 * Specified value in intervals
	 * <p>
	 * INTERVALS("intervals");
	 */
	public static final Map<String, SearchOperation> OPERATIONS = EnumSet.allOf(SearchOperation.class).stream()
			.collect(Collectors.toMap(
					(Function<? super SearchOperation, ? extends String>) SearchOperation::getOperationName,
					Function.identity()
			));

	private final String operationName;

	private final boolean isArray;

	public static SearchOperation of(String operationName) {
		if (!OPERATIONS.containsKey(operationName)) {
			throw new RuntimeException("Неизвестная операция поиска: + " + operationName);
		}
		return OPERATIONS.get(operationName);
	}

}
