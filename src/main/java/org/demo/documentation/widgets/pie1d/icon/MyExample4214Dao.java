package org.demo.documentation.widgets.pie1d.icon;

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
public class MyExample4214Dao extends AbstractAnySourceBaseDAO<MyExample4214DTO> implements
		AnySourceBaseDAO<MyExample4214DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4214DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4214DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4214DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4214DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4214DTO update(BusinessComponent bc, MyExample4214DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4214DTO create(final BusinessComponent bc, final MyExample4214DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4214DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4214DTO dto = new MyExample4214DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum())
							.setIcon("user");
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
