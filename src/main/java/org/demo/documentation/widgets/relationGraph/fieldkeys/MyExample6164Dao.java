package org.demo.documentation.widgets.relationGraph.fieldkeys;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyExample6164Dao extends AbstractAnySourceBaseDAO<MyExample6164DTO> implements
		AnySourceBaseDAO<MyExample6164DTO> {

	private final MyEntity6151Repository repository;

	@Override
	public String getId(final MyExample6164DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample6164DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample6164DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getEdges().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample6164DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getEdges());
	}

	@Override
	public MyExample6164DTO update(BusinessComponent bc, MyExample6164DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample6164DTO create(final BusinessComponent bc, final MyExample6164DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getEdges]
	@NonNull
	private List<MyExample6164DTO> getEdges() {
		return repository.findAll().stream()
				.sorted(Comparator.comparing(MyEntity6151::getId))
				.map(node -> {
					// the root company has no parent: the record only declares the root node
					String sourceId = Optional.ofNullable(node.getParentId()).map(String::valueOf).orElse(null);
					String targetId = String.valueOf(node.getId());
					MyExample6164DTO dto = new MyExample6164DTO()
							.setParentCompanyId(sourceId)
							.setCompanyId(targetId)
							.setTargetNodeName(node.getName())
							.setTargetNodeExpanded(true)
							.setEdgeValue(node.getSum());
					dto.setId(targetId + "_" + Optional.ofNullable(sourceId).orElse(""));
					return dto;
				}).toList();
	}
	// --8<-- [end:getEdges]

}
