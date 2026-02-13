package org.demo.documentation.widgets.relationGraph;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample6150Service extends VersionAwareResponseService<Myexample6150DTO, Myexample6150> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample6150MetaBuilder> meta = Myexample6150MetaBuilder.class;

	private final Myexample6150Repository myexample6150Repository;

	@Override
	protected Specification<Myexample6150> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc)
				.and(((root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(
						root.get(Myexample6150_.targetNodeId)
				)));
	}

	@Override
	protected CreateResult<Myexample6150DTO> doCreateEntity(Myexample6150 entity, BusinessComponent bc) {
		var entitySave = myexample6150Repository.save(entity);
		entitySave.setTargetNodeId(String.valueOf(entitySave.getId()));
		myexample6150Repository.save(entitySave);
		return new CreateResult<>(entityToDto(bc, entitySave));
	}

	@Override
	protected ActionResultDTO<Myexample6150DTO> doUpdateEntity(Myexample6150 entity, Myexample6150DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample6150DTO_.targetNodeDescription, entity::setTargetNodeDescription);
		setIfChanged(data, Myexample6150DTO_.edgeValueBgColorKey, entity::setEdgeValueBgColorKey);
		setIfChanged(data, Myexample6150DTO_.edgeValue, entity::setEdgeValue);
		setIfChanged(data, Myexample6150DTO_.edgeDescription, entity::setEdgeDescription);
		setIfChanged(data, Myexample6150DTO_.targetNodeName, entity::setTargetNodeName);
		setIfChanged(data, Myexample6150DTO_.targetNodeType, entity::setTargetNodeType);
		setIfChanged(data, Myexample6150DTO_.targetNodeBgColorKey, entity::setTargetNodeBgColorKey);
		setIfChanged(data, Myexample6150DTO_.targetNodeId, entity::setTargetNodeId);
		setIfChanged(data, Myexample6150DTO_.sourceNodeId, entity::setSourceNodeId);
		return new ActionResultDTO<>(entityToDto(bc, myexample6150Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample6150DTO> getActions() {
		return Actions.<Myexample6150DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
