package org.demo.documentation.widgets.statsblock.title.withouttitle;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.title.data.MyEntity4221Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4225Dao extends AbstractAnySourceBaseDAO<MyExample4225DTO> implements
		AnySourceBaseDAO<MyExample4225DTO> {

	public static final String COUNT_ROW_ID = "0";


	private final MyEntity4221Repository repository;

	@Override
	public String getId(final MyExample4225DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4225DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4225DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4225DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4225DTO update(BusinessComponent bc, MyExample4225DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4225DTO create(final BusinessComponent bc, final MyExample4225DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4225DTO> getStats() {
		List<MyExample4225DTO> result = new ArrayList<>();
		MyExample4225DTO newRow = new MyExample4225DTO()
				.setValue(repository.count())
				.setIcon("team")
				.setDescription("Count rows in table")
				.setColor("#edaa");
		newRow.setId(COUNT_ROW_ID);
		result.add(newRow);

		return result;
	}

}