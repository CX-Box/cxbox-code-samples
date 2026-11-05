package org.demo.documentation.widgets.relationGraph.incorrectdata;

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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyExample6160Dao extends AbstractAnySourceBaseDAO<MyExample6160DTO> implements
		AnySourceBaseDAO<MyExample6160DTO> {

	private final MyEntity6151Repository repository;

	@Override
	public String getId(final MyExample6160DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample6160DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample6160DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getEdges().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample6160DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getEdges());
	}

	@Override
	public MyExample6160DTO update(BusinessComponent bc, MyExample6160DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample6160DTO create(final BusinessComponent bc, final MyExample6160DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getEdges]
	@NonNull
	private List<MyExample6160DTO> getEdges() {
		var edges = new ArrayList<>(repository.findAll().stream()
				.sorted(Comparator.comparing(MyEntity6151::getId))
				.map(node -> {
					// the root company has no parent: the record only declares the root node
					String sourceId = Optional.ofNullable(node.getParentId()).map(String::valueOf).orElse(null);
					String targetId = String.valueOf(node.getId());
					MyExample6160DTO dto = new MyExample6160DTO()
							.setSourceNodeId(sourceId)
							.setTargetNodeId(targetId)
							.setTargetNodeName(node.getName())
							.setEdgeValue(node.getSum());
					dto.setId(targetId + "_" + Optional.ofNullable(sourceId).orElse(""));
					return dto;
				}).toList());
		// the same edge "source -> target" twice: the graph cannot be drawn, only the table mode is available
		edges.stream().filter(e -> e.getSourceNodeId() != null).findFirst().ifPresent(e -> {
			MyExample6160DTO duplicate = new MyExample6160DTO()
					.setSourceNodeId(e.getSourceNodeId())
					.setTargetNodeId(e.getTargetNodeId())
					.setTargetNodeName(e.getTargetNodeName())
					.setEdgeValue(e.getEdgeValue());
			duplicate.setId(e.getId() + "_duplicate");
			edges.add(duplicate);
		});
		return edges;
	}
	// --8<-- [end:getEdges]

}
