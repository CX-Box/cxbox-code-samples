package org.demo.documentation.widgets.line2d.fulltextsearch;

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
import java.util.Optional;
import org.apache.commons.lang3.Strings;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyExample4273Dao extends AbstractAnySourceBaseDAO<MyExample4273DTO> implements
		AnySourceBaseDAO<MyExample4273DTO> {

	private final MyEntity4240Repository repository;

	@Override
	public String getId(final MyExample4273DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4273DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4273DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4273DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Optional<String> text = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		return new PageImpl<>(getStats().stream()
				.filter(dto -> text.map(value -> Strings.CI.contains(dto.getMonth(), value)).orElse(true))
				.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4273DTO update(BusinessComponent bc, MyExample4273DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4273DTO create(final BusinessComponent bc, final MyExample4273DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4273DTO> getStats() {
		return repository.findAll().stream()
				.collect(Collectors.groupingBy(MyEntity4240::getMonth, Collectors.summingLong(MyEntity4240::getSum)))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> {
					MyExample4273DTO dto = new MyExample4273DTO()
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
