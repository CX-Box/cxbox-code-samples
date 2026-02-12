package org.demo.documentation.widgets.statsblock.icon.withicon;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.icon.data.MyEntity4222Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4223Dao extends AbstractAnySourceBaseDAO<MyExample4223DTO> implements
		AnySourceBaseDAO<MyExample4223DTO> {

	public static final String COUNT_ROW_ID = "0";


	private final MyEntity4222Repository repository;

	@Override
	public String getId(final MyExample4223DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4223DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4223DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4223DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4223DTO update(BusinessComponent bc, MyExample4223DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4223DTO create(final BusinessComponent bc, final MyExample4223DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4223DTO> getStats() {
		List<MyExample4223DTO> result = new ArrayList<>();
		MyExample4223DTO newRow = new MyExample4223DTO()
				.setTitle("All record")
				.setValue(repository.count())
				.setIcon("team")
				.setDescription("Count rows in table")
				.setColor("#edaa");
		newRow.setId(COUNT_ROW_ID);
		result.add(newRow);

		return result;
	}

}