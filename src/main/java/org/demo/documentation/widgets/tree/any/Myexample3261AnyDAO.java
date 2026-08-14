package org.demo.documentation.widgets.tree.any;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class Myexample3261AnyDAO extends AbstractAnySourceBaseDAO<Myexample3261AnyDTO> {

	private final MockExternalService mockExternalService = new MockExternalService();

	@Override
	public String getId(Myexample3261AnyDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(String id, Myexample3261AnyDTO entity) {
		entity.setId(id);
	}

	@Override
	public Myexample3261AnyDTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		return mockExternalService.get(bc).orElse(null);
	}

	@Override
	public Page<Myexample3261AnyDTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(mockExternalService.get(bc, queryParameters));
	}

	@Override
	public Myexample3261AnyDTO create(BusinessComponent bc, Myexample3261AnyDTO entity) {
		return mockExternalService.create(bc, entity);
	}

	@Override
	public Myexample3261AnyDTO update(BusinessComponent bc, Myexample3261AnyDTO entity) {
		return mockExternalService.update(bc, entity);
	}

	@Override
	public void delete(BusinessComponent bc) {
		mockExternalService.delete(bc);
	}

	// TODO: >> plugins >> Add your custom implementation of  service
	// this is simple example using service
	private static class MockExternalService {

		private static final Map<String, Myexample3261AnyDTO> simpleDataProvider = new ConcurrentHashMap<>();

		public static String generateId() {
			return simpleDataProvider.values().stream()
					.max(Comparator.comparingLong(id -> Long.parseLong(id.getId())))
					.map(DataResponseDTO::getId)
					.map(id -> Long.parseLong(id) + 1L)
					.map(String::valueOf)
					.orElse("0");
		}

		public Optional<Myexample3261AnyDTO> get(BusinessComponent bc) {
			return simpleDataProvider.values().stream()
					.filter(dto -> dto.getId().equals(bc.getId()))
					.findFirst();
		}

		public List<Myexample3261AnyDTO> get(BusinessComponent bc, QueryParameters queryParameters) {
			return simpleDataProvider.values().stream()
					.skip((long) (queryParameters.getPage().getPageNo()) * queryParameters.getPageSize())
					.limit(queryParameters.getPageSize())
					.toList();
		}

		public Myexample3261AnyDTO create(BusinessComponent bc, Myexample3261AnyDTO entity) {
			if (entity.getId() == null || "-1".equals(entity.getId())) {
				entity.setId(generateId());
			}
			simpleDataProvider.put(entity.getId(), entity);
			return entity;
		}

		public Myexample3261AnyDTO update(BusinessComponent bc, Myexample3261AnyDTO entity) {
			if (entity.getId() == null || "-1".equals(entity.getId())) {
				entity.setId(generateId());
			}
			simpleDataProvider.put(entity.getId(), entity);
			return entity;
		}

		public void delete(BusinessComponent bc) {
			simpleDataProvider.remove(bc.getId());
		}
	}
}
