package org.demo.documentation.widgets.ringprogress.base.customfields;

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

	@NonNull
	private List<MyExample4211DTO> getStats() {
		List<CustomPrj> data = repository.getCustomPrj();
		return data.stream()
				.map(entity -> {
					MyExample4211DTO myExample4211DTO = new MyExample4211DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					myExample4211DTO.setId(entity.clientId().toString());
					return myExample4211DTO;
				}).toList();
	}
}
