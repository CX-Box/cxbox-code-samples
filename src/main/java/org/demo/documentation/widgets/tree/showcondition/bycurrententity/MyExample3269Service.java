package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3269Service extends VersionAwareResponseService<MyExample3269DTO, MyEntity3269> {

	private final MyEntity3269Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3269Meta> meta = MyExample3269Meta.class;

	@Override
	protected CreateResult<MyExample3269DTO> doCreateEntity(MyEntity3269 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3269DTO> doUpdateEntity(MyEntity3269 entity, MyExample3269DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3269DTO_.parentId, entity::setParentId);
		setIfChanged(data, MyExample3269DTO_.customFieldInput, entity::setCustomFieldInput);
		if (data.isFieldChanged(MyExample3269DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		MyExample3269DTO dto = entityToDto(bc, repository.save(entity));
		dto.setIsLeaf(!repository.existsByParentId(String.valueOf(entity.getId())));

		return new ActionResultDTO<>(dto)
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3269DTO> getActions() {
		return Actions.<MyExample3269DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}