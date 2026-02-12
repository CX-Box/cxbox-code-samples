package org.demo.services.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


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

	private final String operationName;

	private final boolean isArray;

}
