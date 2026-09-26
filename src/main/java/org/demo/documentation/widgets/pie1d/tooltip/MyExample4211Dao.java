package org.demo.documentation.widgets.pie1d.tooltip;

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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4211Dao extends AbstractAnySourceBaseDAO<MyExample4211DTO> implements
		AnySourceBaseDAO<MyExample4211DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4211DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4211DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4211DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4211DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4211DTO update(BusinessComponent bc, MyExample4211DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4211DTO create(final BusinessComponent bc, final MyExample4211DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4211DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4211DTO dto = new MyExample4211DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum())
							.setDescription(entity.clientName() + ": " + entity.salesCount() + " sales");
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
