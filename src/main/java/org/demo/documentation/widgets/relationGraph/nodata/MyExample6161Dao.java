package org.demo.documentation.widgets.relationGraph.nodata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample6161Dao extends AbstractAnySourceBaseDAO<MyExample6161DTO> implements
		AnySourceBaseDAO<MyExample6161DTO> {

	private final MyEntity6151Repository repository;

	@Override
	public String getId(final MyExample6161DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample6161DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample6161DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getEdges().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample6161DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getEdges());
	}

	@Override
	public MyExample6161DTO update(BusinessComponent bc, MyExample6161DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample6161DTO create(final BusinessComponent bc, final MyExample6161DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getEdges]
	@NonNull
	private List<MyExample6161DTO> getEdges() {
		// the business component has no records: the widget shows "No Data"
		return List.of();
	}
	// --8<-- [end:getEdges]

}
