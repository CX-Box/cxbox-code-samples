package org.demo.documentation.widgets.dualaxes2d.color;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.dualaxes2d.data.MyEntity4280;
import org.demo.documentation.widgets.dualaxes2d.data.ProductEnum;
import org.demo.documentation.widgets.dualaxes2d.data.MyEntity4280Repository;
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
public class MyExample4285Dao extends AbstractAnySourceBaseDAO<MyExample4285DTO> implements
		AnySourceBaseDAO<MyExample4285DTO> {

	private final MyEntity4280Repository repository;

	@Override
	public String getId(final MyExample4285DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4285DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4285DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4285DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4285DTO update(BusinessComponent bc, MyExample4285DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4285DTO create(final BusinessComponent bc, final MyExample4285DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4285DTO> getStats() {
		return repository.findAll().stream()
				.collect(Collectors.groupingBy(s -> s.getMonth() + "-" + s.getProductName().name()))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(e -> {
					String[] key = e.getKey().split("-");
					ProductEnum product = ProductEnum.valueOf(key[1]);
					List<MyEntity4280> sales = e.getValue();
					long sum = sales.stream().mapToLong(MyEntity4280::getSum).sum();
					MyExample4285DTO dto = new MyExample4285DTO()
							.setMonth(monthName(Long.valueOf(key[0])))
							.setProductName(product)
							.setSum(sum)
							.setCount((long) sales.size())
							.setColor(ProductEnum.EQUIPMENT.equals(product) ? "#4D83E7" : "#30BA8F");
					dto.setId(e.getKey());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

	private static String monthName(Long month) {
		return Month.of(month.intValue()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

}
