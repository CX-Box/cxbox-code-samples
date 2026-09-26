package org.demo.documentation.widgets.column2d.tooltip;

import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4256Dao extends AbstractAnySourceBaseDAO<MyExample4256DTO> implements
		AnySourceBaseDAO<MyExample4256DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4256DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4256DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4256DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4256DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4256DTO update(BusinessComponent bc, MyExample4256DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4256DTO create(final BusinessComponent bc, final MyExample4256DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4256DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4256DTO dto = new MyExample4256DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum())
							.setDescription(stat.clientName() + ": " + stat.count() + " sales");
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
