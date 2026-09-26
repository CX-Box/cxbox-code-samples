package org.demo.documentation.widgets.column2d.limit;

import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4259Dao extends AbstractAnySourceBaseDAO<MyExample4259DTO> implements
		AnySourceBaseDAO<MyExample4259DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4259DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4259DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4259DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4259DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		// --8<-- [start:getList]
		Pageable pageable = PageRequest.of(queryParameters.getPageNumber(), queryParameters.getPageSize());
		List<MyExample4259DTO> stats = getStats();
		int from = (int) Math.min(pageable.getOffset(), stats.size());
		int to = Math.min(from + pageable.getPageSize(), stats.size());
		return new PageImpl<>(stats.subList(from, to), pageable, stats.size());
		// --8<-- [end:getList]
	}

	@Override
	public MyExample4259DTO update(BusinessComponent bc, MyExample4259DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4259DTO create(final BusinessComponent bc, final MyExample4259DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4259DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4259DTO dto = new MyExample4259DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum());
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
