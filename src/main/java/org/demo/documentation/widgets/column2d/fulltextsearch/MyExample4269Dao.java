package org.demo.documentation.widgets.column2d.fulltextsearch;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Strings;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4269Dao extends AbstractAnySourceBaseDAO<MyExample4269DTO> implements
		AnySourceBaseDAO<MyExample4269DTO> {

	private final MyEntity4252Repository repository;

	@Override
	public String getId(final MyExample4269DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4269DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4269DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4269DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Optional<String> text = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		return new PageImpl<>(getStats().stream()
				.filter(dto -> text.map(value -> Strings.CI.contains(dto.getClientName(), value)).orElse(true))
				.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4269DTO update(BusinessComponent bc, MyExample4269DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4269DTO create(final BusinessComponent bc, final MyExample4269DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4269DTO> getStats() {
		return repository.getClientSums().stream()
				.map(stat -> {
					MyExample4269DTO dto = new MyExample4269DTO()
							.setClientName(stat.clientName())
							.setSum(stat.sum());
					dto.setId(stat.id().toString());
					return dto;
				}).toList();
	}
	// --8<-- [end:getStats]

}
