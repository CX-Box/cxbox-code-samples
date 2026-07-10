package org.demo.documentation.widgets.ringprogress.base.defaultfields;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.ringprogress.data.CustomPrj;
import org.demo.documentation.widgets.ringprogress.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

	@NonNull
	private List<MyExample4207DTO> getStats() {
		List<CustomPrj> data = repository.getCustomPrj();
		return data.stream()
				.map(entity -> {
					MyExample4207DTO myExample4207DTO = new MyExample4207DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					myExample4207DTO.setId(entity.clientId().toString());
					return myExample4207DTO;
				}).toList();
	}
}
