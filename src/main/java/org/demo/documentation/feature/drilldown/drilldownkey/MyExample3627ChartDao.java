package org.demo.documentation.feature.drilldown.drilldownkey;

import java.util.List;
import java.util.Objects;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
public class MyExample3627ChartDao extends AbstractAnySourceBaseDAO<MyExample3627ChartDTO> {

	@Override
	public String getId(final MyExample3627ChartDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample3627ChartDTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample3627ChartDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return records().stream().filter(r -> Objects.equals(r.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample3627ChartDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(records());
	}

	@Override
	public MyExample3627ChartDTO update(BusinessComponent bc, MyExample3627ChartDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample3627ChartDTO create(final BusinessComponent bc, final MyExample3627ChartDTO entity) {
		throw new IllegalStateException();
	}

	private List<MyExample3627ChartDTO> records() {
		var withLink = new MyExample3627ChartDTO().setName("With drill-down").setAmount(30L);
		withLink.setId("1");
		var withoutLink = new MyExample3627ChartDTO().setName("Without drill-down").setAmount(20L);
		withoutLink.setId("2");
		return List.of(withLink, withoutLink);
	}

}
