package org.demo.documentation.widgets.ringprogress.drilldown.drilldown;

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
public class MyExample4219Dao extends AbstractAnySourceBaseDAO<MyExample4219DTO> implements
		AnySourceBaseDAO<MyExample4219DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4219DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4219DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4219DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4219DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4219DTO update(BusinessComponent bc, MyExample4219DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4219DTO create(final BusinessComponent bc, final MyExample4219DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4219DTO> getStats() {
		List<CustomPrj> data = repository.getCustomPrj();
		return data.stream()
				.map(entity -> {
					MyExample4219DTO myExample4219DTO = new MyExample4219DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					myExample4219DTO.setId(entity.clientId().toString());
					return myExample4219DTO;
				}).toList();
	}
}
