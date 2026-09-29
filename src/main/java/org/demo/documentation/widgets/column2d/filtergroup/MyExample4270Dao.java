package org.demo.documentation.widgets.column2d.filtergroup;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.FilterParameter;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.controller.param.SearchOperation;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4270Dao extends AbstractAnySourceBaseDAO<MyExample4270DTO> implements
		AnySourceBaseDAO<MyExample4270DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4270DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4270DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4270DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4270DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4270DTO> stats = getStats().stream();
		for (FilterParameter filter : queryParameters.getFilter()) {
			if (MyExample4270DTO_.sum.getName().equals(filter.getName())) {
				long bound = filter.getLongValue();
				if (filter.getOperation() == SearchOperation.GREATER_OR_EQUAL_THAN) {
					stats = stats.filter(dto -> dto.getSum() >= bound);
				} else if (filter.getOperation() == SearchOperation.LESS_THAN) {
					stats = stats.filter(dto -> dto.getSum() < bound);
				}
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4270DTO update(BusinessComponent bc, MyExample4270DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4270DTO create(final BusinessComponent bc, final MyExample4270DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4270DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4270DTO dto = new MyExample4270DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum());
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
