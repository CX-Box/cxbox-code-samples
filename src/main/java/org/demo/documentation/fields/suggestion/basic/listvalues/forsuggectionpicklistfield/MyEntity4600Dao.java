package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.services.utils.IntegrationURLBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyEntity4600Dao extends AbstractAnySourceBaseDAO<MyEntity4600OutServiceDTO> implements AnySourceBaseDAO<MyEntity4600OutServiceDTO> {
	private static final String DELIMITER = ",";
	private final IntegrationConfiguration integrationConfig;

	private final RestTemplate restTemplate;

	private final IntegrationURLBuilder integrationURLBuilder;

	@Override
	public String getId(final MyEntity4600OutServiceDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyEntity4600OutServiceDTO entity) {
		entity.setId(id);
	}


	// --8<-- [start:getByIdIgnoringFirstLevelCache]
	@Override
	public MyEntity4600OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getData().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	// --8<-- [end:getByIdIgnoringFirstLevelCache]

	// --8<-- [start:getList]
	@Override
	public Page<MyEntity4600OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		String filterCustomField = getFilterFieldName(queryParameters);
		if (filterCustomField == null) {
			return new PageImpl<>(getData());
		}
		return new PageImpl<>(getData().stream()
				.filter(f -> f.getCustomField().toUpperCase().contains(filterCustomField.toUpperCase()))
				.toList());

	}
	// --8<-- [end:getList]


	@Override
	// --8<-- [start:delete]
	public void delete(BusinessComponent bc) {
		throw new IllegalStateException();
	}
	// --8<-- [end:delete]


	@Override
	// --8<-- [start:create]
	public MyEntity4600OutServiceDTO create(BusinessComponent bc, MyEntity4600OutServiceDTO entity) {
		throw new IllegalStateException();
	}
	// --8<-- [end:create]

	@Override
	// --8<-- [start:update]
	public MyEntity4600OutServiceDTO update(BusinessComponent bc, MyEntity4600OutServiceDTO entity) {
		throw new IllegalStateException();
		// --8<-- [end:update]
	}

	@NonNull
	private List<MyEntity4600OutServiceDTO> getData() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			Path pathUri = Paths.get(classLoader.getResource("db/data/custom/product.csv").toURI());
			return Files.readAllLines(pathUri)
					.stream()
					.map(line -> line.split(DELIMITER))
					.map(parts -> {
						MyEntity4600OutServiceDTO dto = new MyEntity4600OutServiceDTO();
						dto.setId(parts[0]);
						dto.setCustomField(parts[1]);
						return dto;
					})
					.toList();
		} catch (Exception e) {
			return List.of();
		}
	}


	private String getFilterFieldName(QueryParameters queryParameters) {
		return queryParameters.getParameters().entrySet().stream()
				.filter(e -> e.getKey().contains("query"))
				.findFirst()
				.map(Map.Entry::getValue)
				.orElse(null);
	}
}