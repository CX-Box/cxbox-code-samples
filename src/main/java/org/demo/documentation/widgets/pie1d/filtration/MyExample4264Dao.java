package org.demo.documentation.widgets.pie1d.filtration;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.controller.param.FilterParameter;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.controller.param.SearchOperation;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4264Dao extends AbstractAnySourceBaseDAO<MyExample4264DTO> implements
		AnySourceBaseDAO<MyExample4264DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4264DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4264DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4264DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4264DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4264DTO> stats = getStats().stream();
		for (FilterParameter filter : queryParameters.getFilter()) {
			if (MyExample4264DTO_.title.getName().equals(filter.getName())
					&& filter.getOperation() == SearchOperation.CONTAINS) {
				stats = stats.filter(dto -> StringUtils.containsIgnoreCase(dto.getTitle(), filter.getStringValue()));
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4264DTO update(BusinessComponent bc, MyExample4264DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4264DTO create(final BusinessComponent bc, final MyExample4264DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4264DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4264DTO dto = new MyExample4264DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
