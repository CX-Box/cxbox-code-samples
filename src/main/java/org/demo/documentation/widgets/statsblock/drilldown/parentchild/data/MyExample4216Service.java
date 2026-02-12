package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4216Service extends VersionAwareResponseService<MyExample4216DTO, MyEntity4216> {

	private final MyEntity4216Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4216Meta> meta = MyExample4216Meta.class;

	// --8<-- [start:getParentSpecification]
	@Override
	protected Specification<MyEntity4216> getParentSpecification(BusinessComponent bc) {

		return switch (bc.getParentId()) {
			case "2" -> createStatusSpecification(bc, ExampleStatus.NOT_STARTED);
			case "3" -> createStatusSpecification(bc, ExampleStatus.IN_COMPLETION);
			case "4" -> createStatusSpecification(bc, ExampleStatus.IN_PROGRESS);
			case "5" -> createStatusSpecification(bc, ExampleStatus.COMPLETED);
			case "6" -> createStatusSpecification(bc, ExampleStatus.CANCELLED);
			default -> (root, cq, cb) -> cb.and();
		};

	}

	private Specification<MyEntity4216> createStatusSpecification(BusinessComponent bc, ExampleStatus status) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(MyEntity4216_.status), status)
		);
	}

	// --8<-- [end:getParentSpecification]
	@Override
	protected CreateResult<MyExample4216DTO> doCreateEntity(MyEntity4216 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4216DTO> doUpdateEntity(MyEntity4216 entity, MyExample4216DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample4216DTO_.status, entity::setStatus);
		setIfChanged(data, MyExample4216DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4216DTO> getActions() {
		return Actions.<MyExample4216DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}