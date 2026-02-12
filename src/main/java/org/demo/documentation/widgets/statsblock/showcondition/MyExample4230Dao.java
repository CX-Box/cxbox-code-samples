package org.demo.documentation.widgets.statsblock.showcondition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.showcondition.data.MyEntity4229Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4230Dao extends AbstractAnySourceBaseDAO<MyExample4230DTO> implements
		AnySourceBaseDAO<MyExample4230DTO> {

	public static final String COUNT_ROW_ID = "0";

	private final MyEntity4229Repository repository;

	@Override
	public String getId(final MyExample4230DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4230DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4230DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4230DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4230DTO update(BusinessComponent bc, MyExample4230DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4230DTO create(final BusinessComponent bc, final MyExample4230DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4230DTO> getStats() {
		List<MyExample4230DTO> result = new ArrayList<>();
		MyExample4230DTO newRow = new MyExample4230DTO()
				.setTitle("All record")
				.setValue(repository.count())
				.setIcon("team")
				.setDescription("Count rows in table")
				.setColor("#edaa")
				.setCustomFieldShowCondition(repository.count() > 3);
		newRow.setId(COUNT_ROW_ID);
		result.add(newRow);

		return result;
	}

}