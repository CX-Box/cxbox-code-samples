package org.demo.documentation.widgets.line2d.tooltip;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.line2d.data.MyEntity4240;
import org.demo.documentation.widgets.line2d.data.MyEntity4240Repository;
import org.demo.documentation.widgets.line2d.data.ProductEnum;
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
public class MyExample4246Dao extends AbstractAnySourceBaseDAO<MyExample4246DTO> implements
		AnySourceBaseDAO<MyExample4246DTO> {

	private final MyEntity4240Repository repository;

	@Override
	public String getId(final MyExample4246DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4246DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4246DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4246DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4246DTO update(BusinessComponent bc, MyExample4246DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4246DTO create(final BusinessComponent bc, final MyExample4246DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4246DTO> getStats() {
		return repository.findAll().stream()
				.collect(Collectors.groupingBy(s -> s.getMonth() + "-" + s.getProductName().name(),
						Collectors.summingLong(MyEntity4240::getSum)))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> {
					String[] key = e.getKey().split("-");
					ProductEnum product = ProductEnum.valueOf(key[1]);
					MyExample4246DTO dto = new MyExample4246DTO()
							.setMonth(monthName(Long.valueOf(key[0])))
							.setProductName(product)
							.setSum(e.getValue())
							.setDescription("Month " + key[0] + ", " + product.getValue());
					dto.setId(e.getKey());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

	private static String monthName(Long month) {
		return Month.of(month.intValue()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

}
