package org.demo.documentation.widgets.pie1d.title.withtitle;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.pie1d.data.CustomPrj;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4220Dao extends AbstractAnySourceBaseDAO<MyExample4220DTO> implements
		AnySourceBaseDAO<MyExample4220DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4220DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4220DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4220DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4220DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4220DTO update(BusinessComponent bc, MyExample4220DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4220DTO create(final BusinessComponent bc, final MyExample4220DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4220DTO> getStats() {
		List<CustomPrj> data = repository.getCustomPrj();
		return data.stream()
				.map(entity -> {
					MyExample4220DTO myExample4220DTO = new MyExample4220DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					myExample4220DTO.setId(entity.clientId().toString());
					return myExample4220DTO;
				}).toList();
	}
}
