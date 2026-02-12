package org.demo.documentation.widgets.statsblock.title.withtitle;

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
public class MyExample4226Dao extends AbstractAnySourceBaseDAO<MyExample4226DTO> implements
		AnySourceBaseDAO<MyExample4226DTO> {

	public static final String COUNT_ROW_ID = "0";

	private final MyEntity4221Repository repository;

	@Override
	public String getId(final MyExample4226DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4226DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4226DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4226DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4226DTO update(BusinessComponent bc, MyExample4226DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4226DTO create(final BusinessComponent bc, final MyExample4226DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4226DTO> getStats() {
		List<MyExample4226DTO> result = new ArrayList<>();
		MyExample4226DTO newRow = new MyExample4226DTO()
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