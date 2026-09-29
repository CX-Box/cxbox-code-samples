package org.demo.documentation.widgets.column2d.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.controller.param.SortParameter;
import org.cxbox.core.controller.param.SortType;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4271Dao extends AbstractAnySourceBaseDAO<MyExample4271DTO> implements
		AnySourceBaseDAO<MyExample4271DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4271DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4271DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4271DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4271DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4271DTO> stats = getStats().stream();
		for (SortParameter sort : queryParameters.getSort()) {
			if (MyExample4271DTO_.sum.getName().equals(sort.getName())) {
				Comparator<MyExample4271DTO> byValue = Comparator.comparing(MyExample4271DTO::getSum);
				stats = stats.sorted(sort.getType() == SortType.DESC ? byValue.reversed() : byValue);
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4271DTO update(BusinessComponent bc, MyExample4271DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4271DTO create(final BusinessComponent bc, final MyExample4271DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4271DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4271DTO dto = new MyExample4271DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum());
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
