package org.demo.documentation.widgets.dualaxes2d.nodata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.dualaxes2d.data.MyEntity4280Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4289Dao extends AbstractAnySourceBaseDAO<MyExample4289DTO> implements
		AnySourceBaseDAO<MyExample4289DTO> {

	private final MyEntity4280Repository repository;

	@Override
	public String getId(final MyExample4289DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4289DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4289DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4289DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4289DTO update(BusinessComponent bc, MyExample4289DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4289DTO create(final BusinessComponent bc, final MyExample4289DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4289DTO> getStats() {
		// the business component has no records: the widget shows "No Data"
		return List.of();
	}
	// --8<-- [end:getStats]

}
