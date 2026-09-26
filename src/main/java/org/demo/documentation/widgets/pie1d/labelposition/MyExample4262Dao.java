package org.demo.documentation.widgets.pie1d.labelposition;

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
public class MyExample4262Dao extends AbstractAnySourceBaseDAO<MyExample4262DTO> implements
		AnySourceBaseDAO<MyExample4262DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4262DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4262DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4262DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4262DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4262DTO update(BusinessComponent bc, MyExample4262DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4262DTO create(final BusinessComponent bc, final MyExample4262DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4262DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4262DTO dto = new MyExample4262DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
