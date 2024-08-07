package org.demo.services.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;


@Getter
@RequiredArgsConstructor
public enum IntegrationURLRules {


	PAGE("_page", (bc, builder) -> builder.queryParam("_page", bc.getParameters().getParameter("_page"))),
	LIMIT("_limit", (bc, builder) -> builder.queryParam("_limit", bc.getParameters().getParameter("_limit"))),
	SORT(
			ExternalQueryParameters.SORT_PARAM,
			(bc, builder) -> {
				Optional<Pair<String, String>> fieldNameToSortType = BcParseHelper.getFieldNameToSortType(bc);
				builder.queryParamIfPresent(
								ExternalQueryParameters.SORT_PARAM,
								fieldNameToSortType.map(pair -> Optional.of(pair.getLeft()))
						)
						.queryParamIfPresent(
								ExternalQueryParameters.ORDER_PARAM,
								fieldNameToSortType.map(pair -> Optional.of(pair.getRight()))
						);
			}
	),
	FILTER(ExternalQueryParameters.FILTER_FIELD_PREFIX, (bc, builder) -> {
		Map<String, String> containsParameters = BcParseHelper.getContainsParameters(bc);
		for (Entry<String, String> entry : containsParameters.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			builder.queryParam(ExternalQueryParameters.FILTER_FIELD_PREFIX + key, value);
		}
	}
	);

	private final String contains;

	private final BiConsumer<BusinessComponent, UriComponentsBuilder> buildURLFunc;


}
