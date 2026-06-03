package org.demo.documentation.widgets.funnel.fieldslayoute;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.funnel.data.MyExampleBc5042;
import org.demo.documentation.widgets.funnel.data.MyExampleBc5042Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class MyExampleBc5049DAO extends AbstractAnySourceBaseDAO<MyExampleBc5049DTO> {

	public static final Map<Number, String> COLOR_LIST = Map.ofEntries(
			Map.entry(1, "#E6E6FA"),
			Map.entry(2, "#D8B4FE"),
			Map.entry(3, "#C4B5FD"),
			Map.entry(4, "#A78BFA"),
			Map.entry(5, "#8B5CF6"),
			Map.entry(6, "#7C6AFF")
	);

	@Autowired
	MyExampleBc5042Repository repository;

	@Override
	public String getId(MyExampleBc5049DTO entity) {
		return entity.getId();
	}


	@Override
	public void setId(String id, MyExampleBc5049DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExampleBc5049DTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public Page<MyExampleBc5049DTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExampleBc5049DTO create(BusinessComponent bc, MyExampleBc5049DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExampleBc5049DTO update(BusinessComponent bc, MyExampleBc5049DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExampleBc5049DTO> getStats() {
		long count = repository.count();
		Long sum = repository.customTotal();
		List<MyExampleBc5042> myExampleBc5042 = repository.findAll();
		List<MyExampleBc5049DTO> result = new ArrayList<>();
		AtomicInteger num = new AtomicInteger(1);
		myExampleBc5042.forEach(entity -> {
			int index = num.getAndIncrement() % COLOR_LIST.size();
			if (index > count) {
				index = 1;
			}
			MyExampleBc5049DTO newRow = new MyExampleBc5049DTO()
					.setValue(entity.getCustomFieldNum())
					.setIcon("team")
					.setColor(COLOR_LIST.get(index))
					.setAmount(entity.getCustomFieldNum())
					.setDescription("Count rows in table");
			newRow.setFunnelKey(entity.getId().toString());
			newRow.setId(entity.getId().toString());
			result.add(newRow);
		});

		return result;
	}

}