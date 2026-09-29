package org.demo.documentation.widgets.pie1d.filtergroup;

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
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4266Dao extends AbstractAnySourceBaseDAO<MyExample4266DTO> implements
		AnySourceBaseDAO<MyExample4266DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4266DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4266DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4266DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4266DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4266DTO> stats = getStats().stream();
		for (FilterParameter filter : queryParameters.getFilter()) {
			if (MyExample4266DTO_.value.getName().equals(filter.getName())) {
				long bound = filter.getLongValue();
				if (filter.getOperation() == SearchOperation.GREATER_OR_EQUAL_THAN) {
					stats = stats.filter(dto -> dto.getValue() >= bound);
				} else if (filter.getOperation() == SearchOperation.LESS_THAN) {
					stats = stats.filter(dto -> dto.getValue() < bound);
				}
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4266DTO update(BusinessComponent bc, MyExample4266DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4266DTO create(final BusinessComponent bc, final MyExample4266DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4266DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4266DTO dto = new MyExample4266DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
