package org.demo.documentation.widgets.line2d.base;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.line2d.data.MyEntity4240;
import org.demo.documentation.widgets.line2d.data.MyEntity4240Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyExample4240Dao extends AbstractAnySourceBaseDAO<MyExample4240DTO> implements
		AnySourceBaseDAO<MyExample4240DTO> {

	private final MyEntity4240Repository repository;

	@Override
	public String getId(final MyExample4240DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4240DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4240DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4240DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4240DTO update(BusinessComponent bc, MyExample4240DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4240DTO create(final BusinessComponent bc, final MyExample4240DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4240DTO> getStats() {
		return repository.findAll().stream()
				.collect(Collectors.groupingBy(MyEntity4240::getMonth, Collectors.summingLong(MyEntity4240::getSum)))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> {
					MyExample4240DTO dto = new MyExample4240DTO()
							.setMonth(monthName(e.getKey()))
							.setSum(e.getValue());
					dto.setId(e.getKey().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

	private static String monthName(Long month) {
		return Month.of(month.intValue()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

}
