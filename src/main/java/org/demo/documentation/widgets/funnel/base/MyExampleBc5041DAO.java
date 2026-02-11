package org.demo.documentation.widgets.funnel.base;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MyExampleBc5041DAO extends AbstractAnySourceBaseDAO<MyExampleBc5041DTO> {

	@Autowired
	MyExampleBc5042Repository repository;

	public static final String COUNT_ROW_ID = "0";

	public static final String SUM_CUSTOM_FIELD_NUM = "1";

	@Override
	public String getId(MyExampleBc5041DTO entity) {
		return entity.getId();
	}


	@Override
	public void setId(String id, MyExampleBc5041DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExampleBc5041DTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public Page<MyExampleBc5041DTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(getStats());}

	@Override
	public MyExampleBc5041DTO create(BusinessComponent bc, MyExampleBc5041DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExampleBc5041DTO update(BusinessComponent bc, MyExampleBc5041DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExampleBc5041DTO> getStats() {
		List<MyExampleBc5041DTO> result = new ArrayList<>();
		MyExampleBc5041DTO newRow = new MyExampleBc5041DTO()
				.setTitle("All record")
				.setValue(repository.count())
				.setIcon("team")
				.setDescription("Count rows in table");
		newRow.setId(COUNT_ROW_ID);
		result.add(newRow);
		MyExampleBc5041DTO newSum = new MyExampleBc5041DTO()
				.setTitle("Custom Field Num Total")
				.setValue(repository.customTotal())
				.setIcon("team")
				.setDescription("Custom Field Num Total");
		newRow.setId(COUNT_ROW_ID);
		newSum.setId(SUM_CUSTOM_FIELD_NUM);
		result.add(newSum);

		return result;
	}

}