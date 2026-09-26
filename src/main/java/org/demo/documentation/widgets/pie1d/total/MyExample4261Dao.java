package org.demo.documentation.widgets.pie1d.total;

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
public class MyExample4261Dao extends AbstractAnySourceBaseDAO<MyExample4261DTO> implements
		AnySourceBaseDAO<MyExample4261DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4261DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4261DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4261DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4261DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4261DTO update(BusinessComponent bc, MyExample4261DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4261DTO create(final BusinessComponent bc, final MyExample4261DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4261DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4261DTO dto = new MyExample4261DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum())
							.setSalesCount(entity.salesCount());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
