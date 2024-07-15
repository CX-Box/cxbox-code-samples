package org.demo.documentation.feature.microservice.createmicroservices.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public final class ExternalQueryParameters {
	public static final String FILTER_FIELD_PREFIX = "_filter.field.";


	public static final String PAGE_PARAM = "_page";

	public static final String LIMIT_PARAM = "_limit";

	public static final String SORT_PARAM = "_sort";

	public static final String ORDER_PARAM = "_order";

	private final Map<String, String> parameters;

	public ExternalQueryParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public static ExternalQueryParameters of(final Map<String, String[]> parameters) {
		final Map<String, String> singleValueMap = parameters.entrySet().stream().collect(Collectors.toUnmodifiableMap(
				Entry::getKey,
				entry -> URLDecoder.decode(entry.getValue()[0], StandardCharsets.UTF_8)
		));
		return new ExternalQueryParameters(singleValueMap);
	}

	public Optional<String> getParameter(final String name) {
		return Optional.ofNullable(parameters.get(name));
	}

	public int getPageNum() {
		final Optional<String> pageNumOpt = this.getParameter(PAGE_PARAM);
		final int pageNum = pageNumOpt.map(Integer::parseInt)
				.orElseThrow(() -> new IllegalArgumentException("Параметр _page не заполнен."));
		if (pageNum == 0) {
			throw new IllegalArgumentException("Параметр _page должен быть больше 0.");
		}
		return pageNum;
	}

	public int getLimit() {
		final Optional<String> limitOpt = this.getParameter(LIMIT_PARAM);
		final int limit = limitOpt.map(Integer::parseInt)
				.orElseThrow(() -> new IllegalArgumentException("Параметр _limit не заполнен."));
		if (limit == 0) {
			throw new IllegalArgumentException("Параметр _limit должен быть больше 0.");
		}
		return limit;
	}

	public Map<String, String> parameters() {
		return parameters;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		var that = (ExternalQueryParameters) obj;
		return Objects.equals(this.parameters, that.parameters);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parameters);
	}

	@Override
	public String toString() {
		return "GpnQueryParameters[" +
				"parameters=" + parameters + ']';
	}


}
