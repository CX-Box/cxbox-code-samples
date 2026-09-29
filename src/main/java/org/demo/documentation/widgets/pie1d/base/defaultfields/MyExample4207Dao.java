package org.demo.documentation.widgets.pie1d.base.defaultfields;

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
public class MyExample4207Dao extends AbstractAnySourceBaseDAO<MyExample4207DTO> implements
		AnySourceBaseDAO<MyExample4207DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4207DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4207DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4207DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4207DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4207DTO update(BusinessComponent bc, MyExample4207DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4207DTO create(final BusinessComponent bc, final MyExample4207DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4207DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4207DTO dto = new MyExample4207DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
