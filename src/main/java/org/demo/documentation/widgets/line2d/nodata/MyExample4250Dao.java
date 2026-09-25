package org.demo.documentation.widgets.line2d.nodata;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.line2d.data.MyEntity4240Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4250Dao extends AbstractAnySourceBaseDAO<MyExample4250DTO> implements
		AnySourceBaseDAO<MyExample4250DTO> {

	private final MyEntity4240Repository repository;

	@Override
	public String getId(final MyExample4250DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4250DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4250DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4250DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4250DTO update(BusinessComponent bc, MyExample4250DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4250DTO create(final BusinessComponent bc, final MyExample4250DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4250DTO> getStats() {
		return List.of();
	}
	// --8<-- [end:getStats]

	private static String monthName(Long month) {
		return Month.of(month.intValue()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

}
