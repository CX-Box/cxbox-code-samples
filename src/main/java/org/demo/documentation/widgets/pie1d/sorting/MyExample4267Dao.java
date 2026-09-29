package org.demo.documentation.widgets.pie1d.sorting;

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
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4267Dao extends AbstractAnySourceBaseDAO<MyExample4267DTO> implements
		AnySourceBaseDAO<MyExample4267DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4267DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4267DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4267DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4267DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Stream<MyExample4267DTO> stats = getStats().stream();
		for (SortParameter sort : queryParameters.getSort()) {
			if (MyExample4267DTO_.value.getName().equals(sort.getName())) {
				Comparator<MyExample4267DTO> byValue = Comparator.comparing(MyExample4267DTO::getValue);
				stats = stats.sorted(sort.getType() == SortType.DESC ? byValue.reversed() : byValue);
			}
		}
		return new PageImpl<>(stats.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4267DTO update(BusinessComponent bc, MyExample4267DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4267DTO create(final BusinessComponent bc, final MyExample4267DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4267DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4267DTO dto = new MyExample4267DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
