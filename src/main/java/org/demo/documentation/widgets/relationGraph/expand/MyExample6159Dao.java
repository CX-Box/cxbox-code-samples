package org.demo.documentation.widgets.relationGraph.expand;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151;
import org.demo.documentation.widgets.relationGraph.data.MyEntity6151Repository;
import org.demo.documentation.widgets.relationGraph.enums.TargetNodeTypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyExample6159Dao extends AbstractAnySourceBaseDAO<MyExample6159DTO> implements
		AnySourceBaseDAO<MyExample6159DTO> {

	private static final String MAIN_NODE = "North branch";

	private static final String COLLAPSED_NODE = "South branch";

	private final MyEntity6151Repository repository;

	@Override
	public String getId(final MyExample6159DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample6159DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample6159DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getEdges().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample6159DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getEdges());
	}

	@Override
	public MyExample6159DTO update(BusinessComponent bc, MyExample6159DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample6159DTO create(final BusinessComponent bc, final MyExample6159DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getEdges]
	@NonNull
	private List<MyExample6159DTO> getEdges() {
		return repository.findAll().stream()
				.sorted(Comparator.comparing(MyEntity6151::getId))
				.map(node -> {
					// the root company has no parent: the record only declares the root node
					String sourceId = Optional.ofNullable(node.getParentId()).map(String::valueOf).orElse(null);
					String targetId = String.valueOf(node.getId());
					MyExample6159DTO dto = new MyExample6159DTO()
							.setSourceNodeId(sourceId)
							.setTargetNodeId(targetId)
							.setTargetNodeName(node.getName())
							.setTargetNodeType(Objects.equals(node.getName(), MAIN_NODE) ? TargetNodeTypeEnum.MAIN : null)
							.setTargetNodeExpanded(!Objects.equals(node.getName(), COLLAPSED_NODE))
							.setEdgeValue(node.getSum());
					dto.setId(targetId + "_" + Optional.ofNullable(sourceId).orElse(""));
					return dto;
				}).toList();
	}
	// --8<-- [end:getEdges]

}
