package org.demo.documentation.widgets.pie1d.fulltextsearch;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4265Dao extends AbstractAnySourceBaseDAO<MyExample4265DTO> implements
		AnySourceBaseDAO<MyExample4265DTO> {

	private final MyEntityRingRepository repository;

	@Override
	public String getId(final MyExample4265DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4265DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4265DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample4265DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		Optional<String> text = FullTextSearchExt.getFullTextSearchFilterParam(bc);
		return new PageImpl<>(getStats().stream()
				.filter(dto -> text.map(value -> StringUtils.containsIgnoreCase(dto.getTitle(), value)).orElse(true))
				.toList());
	}
	// --8<-- [end:getList]

	@Override
	public MyExample4265DTO update(BusinessComponent bc, MyExample4265DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4265DTO create(final BusinessComponent bc, final MyExample4265DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	@NonNull
	private List<MyExample4265DTO> getStats() {
		return repository.getCustomPrj().stream()
				.map(entity -> {
					MyExample4265DTO dto = new MyExample4265DTO()
							.setTitle(entity.clientName())
							.setValue(entity.sum());
					dto.setId(entity.clientId().toString());
					return dto;
				})
				.toList();
	}
	// --8<-- [end:getStats]

}
