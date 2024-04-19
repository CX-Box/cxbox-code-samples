package org.demo.documentation.microservice.microservicestoringdata.core.querylang.common;

import lombok.NonNull;

import java.lang.reflect.Field;
import java.util.List;


public interface DtoToEntityFilterParameterMapper {

	/**
	 * @param dtoField DTO field to search or sort by
	 * @param filterParam Filter parameter that defines the type of operation and the values to filter
	 * @return Classify Data Parameters for defining of predicates of searching data in Persistence Layer
	 */
	List<EntityFieldFilterParameter> map(@NonNull Field dtoField, FilterParameters.DtoFieldFilterParameter<?> filterParam, String path,
										 Class<? extends DtoToEntityFilterParameterMapper> provider);

	List<SearchOperation> availableOperations(@NonNull Field dtoField);

}
