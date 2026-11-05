package org.demo.documentation.widgets.relationGraph.drilldown;

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
public class MyExample6158Dao extends AbstractAnySourceBaseDAO<MyExample6158DTO> implements
		AnySourceBaseDAO<MyExample6158DTO> {

	private final MyEntity6151Repository repository;

	@Override
	public String getId(final MyExample6158DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample6158DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample6158DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getEdges().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample6158DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getEdges());
	}

	@Override
	public MyExample6158DTO update(BusinessComponent bc, MyExample6158DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample6158DTO create(final BusinessComponent bc, final MyExample6158DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getEdges]
	@NonNull
	private List<MyExample6158DTO> getEdges() {
		return repository.findAll().stream()
				.sorted(Comparator.comparing(MyEntity6151::getId))
				.map(node -> {
					// the root company has no parent: the record only declares the root node
					String sourceId = Optional.ofNullable(node.getParentId()).map(String::valueOf).orElse(null);
					String targetId = String.valueOf(node.getId());
					MyExample6158DTO dto = new MyExample6158DTO()
							.setSourceNodeId(sourceId)
							.setTargetNodeId(targetId)
							.setTargetNodeName(node.getName())
							.setEdgeValue(node.getSum());
					dto.setId(targetId + "_" + Optional.ofNullable(sourceId).orElse(""));
					return dto;
				}).toList();
	}
	// --8<-- [end:getEdges]

}
