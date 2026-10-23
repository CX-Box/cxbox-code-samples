package org.demo.documentation.widgets.column2d.filtration;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Strings;
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
public class MyExample4268Dao extends AbstractAnySourceBaseDAO<MyExample4268DTO> implements
		AnySourceBaseDAO<MyExample4268DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4268DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4268DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4268DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4268DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4268DTO> stats = getStats().stream();
		for (FilterParameter filter : queryParameters.getFilter()) {
			if (MyExample4268DTO_.clientName.getName().equals(filter.getName())
					&& filter.getOperation() == SearchOperation.CONTAINS) {
				stats = stats.filter(dto -> Strings.CI.contains(dto.getClientName(), filter.getStringValue()));
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4268DTO update(BusinessComponent bc, MyExample4268DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4268DTO create(final BusinessComponent bc, final MyExample4268DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4268DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4268DTO dto = new MyExample4268DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum());
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
