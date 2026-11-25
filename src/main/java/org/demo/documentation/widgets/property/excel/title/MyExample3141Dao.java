package org.demo.documentation.widgets.property.excel.title;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
public class MyExample3141Dao extends AbstractAnySourceBaseDAO<MyExample3141DTO> implements
		AnySourceBaseDAO<MyExample3141DTO> {

	@Override
	public String getId(final MyExample3141DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample3141DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample3141DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getSales().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample3141DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getSales());
	}

	@Override
	public MyExample3141DTO update(BusinessComponent bc, MyExample3141DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample3141DTO create(final BusinessComponent bc, final MyExample3141DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getSales]
	private List<MyExample3141DTO> getSales() {
		LocalDateTime period = LocalDateTime.of(2026, 10, 31, 0, 0);
		return List.of(
				sale("1", "AcademWeb Holding", 2600.0, period),
				sale("2", "Info Trust", 5400.0, period),
				sale("3", "Trade Prof Media", 4800.0, period)
		);
	}

	private static MyExample3141DTO sale(String id, String client, Double sum, LocalDateTime period) {
		MyExample3141DTO sale = new MyExample3141DTO()
				.setClient(client)
				.setSum(sum)
				.setPeriod(period);
		sale.setId(id);
		return sale;
	}
	// --8<-- [end:getSales]

}
