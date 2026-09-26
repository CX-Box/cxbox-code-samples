package org.demo.documentation.widgets.pie1d.pagelimit;

import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4263Dao extends AbstractAnySourceBaseDAO<MyExample4263DTO> implements
		AnySourceBaseDAO<MyExample4263DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4263DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4263DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4263DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4263DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		// --8<-- [start:getList]
		Pageable pageable = PageRequest.of(queryParameters.getPageNumber(), queryParameters.getPageSize());
		List<MyExample4263DTO> stats = getStats();
		int from = (int) Math.min(pageable.getOffset(), stats.size());
		int to = Math.min(from + pageable.getPageSize(), stats.size());
		return new PageImpl<>(stats.subList(from, to), pageable, stats.size());
		// --8<-- [end:getList]
	}

	@Override
	public MyExample4263DTO update(BusinessComponent bc, MyExample4263DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4263DTO create(final BusinessComponent bc, final MyExample4263DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4263DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4263DTO dto = new MyExample4263DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
