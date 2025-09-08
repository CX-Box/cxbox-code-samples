package org.demo.documentation.fields.suggestion.filtration;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SdfsdfDAO extends AbstractAnySourceBaseDAO<SdfsdfDTO> {

	private final MockExternalService mockExternalService = new MockExternalService();

	@Override
	public String getId(SdfsdfDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(String id, SdfsdfDTO entity) {
		entity.setId(id);
	}

	@Override
	public SdfsdfDTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		return mockExternalService.get(bc).orElse(null);
	}

	@Override
	public Page<SdfsdfDTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(mockExternalService.get(bc, queryParameters));
	}

	@Override
	public SdfsdfDTO create(BusinessComponent bc, SdfsdfDTO entity) {
		return mockExternalService.create(bc, entity);
	}

	@Override
	public SdfsdfDTO update(BusinessComponent bc, SdfsdfDTO entity) {
		return mockExternalService.update(bc, entity);
	}

	@Override
	public void delete(BusinessComponent bc) {
		mockExternalService.delete(bc);
	}

		// TODO: >> plugins >> Add your custom implementation of  service
		// this is simple example using service
	private static class MockExternalService {

		private static final Map<String, SdfsdfDTO> simpleDataProvider = new ConcurrentHashMap<>();

		public static String generateId() {
			return simpleDataProvider.values().stream()
					.max(Comparator.comparingLong(id -> Long.parseLong(id.getId())))
					.map(DataResponseDTO::getId)
					.map(id -> Long.parseLong(id) + 1L)
					.map(String::valueOf)
					.orElse("0");
		}

		public Optional<SdfsdfDTO> get(BusinessComponent bc) {
			return simpleDataProvider.values().stream()
					.filter(dto -> dto.getId().equals(bc.getId()))
					.findFirst();
		}

		public List<SdfsdfDTO> get(BusinessComponent bc, QueryParameters queryParameters) {
			return simpleDataProvider.values().stream()
					.skip((long) (queryParameters.getPage().getPageNo()) * queryParameters.getPageSize())
					.limit(queryParameters.getPageSize())
					.toList();
		}

		public SdfsdfDTO create(BusinessComponent bc, SdfsdfDTO entity) {
			if (entity.getId() == null || "-1".equals(entity.getId())) {
				entity.setId(generateId());
			}
			simpleDataProvider.put(entity.getId(), entity);
			return entity;
		}

		public SdfsdfDTO update(BusinessComponent bc, SdfsdfDTO entity) {
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
