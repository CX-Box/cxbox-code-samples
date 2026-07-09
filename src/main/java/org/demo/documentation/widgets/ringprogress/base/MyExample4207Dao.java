package org.demo.documentation.widgets.ringprogress.base;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.ringprogress.MyEntityRingRepository;
import org.demo.documentation.widgets.statsblock.color.data.MyEntity4204Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyExample4207Dao extends AbstractAnySourceBaseDAO<MyExample4207DTO> implements
		AnySourceBaseDAO<MyExample4207DTO> {

	public static final String COUNT_ROW_ID = "0";

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4207DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4207DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4207DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4207DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4207DTO update(BusinessComponent bc, MyExample4207DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4207DTO create(final BusinessComponent bc, final MyExample4207DTO entity) {
		throw new IllegalStateException();
	}

	@NonNull
	private List<MyExample4207DTO> getStats() {
		List<MyExample4207DTO> result = new ArrayList<>();
		MyExample4207DTO newRow = new MyExample4207DTO()
				.setTitle("All record")
				.setValue(repository.count())
				.setIcon("team")
				.setDescription("Count rows in table")
				.setColor("#779FE9");
		newRow.setId(COUNT_ROW_ID);
		result.add(newRow);

		return result;
	}

}