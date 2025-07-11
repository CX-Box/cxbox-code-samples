package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

// 4300
// PickList

@Service
public class MyExample4300PickListService extends VersionAwareResponseService<MyExample4300PickListDTO, MyEntity4300PickList> {

	private final MyEntity4300PickListRepository repository;

	public MyExample4300PickListService(MyEntity4300PickListRepository repository) {
		super(MyExample4300PickListDTO.class, MyEntity4300PickList.class, null, MyExample4300PickListMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample4300PickListDTO> doCreateEntity(
			MyEntity4300PickList entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4300PickListDTO> doUpdateEntity(
			MyEntity4300PickList entity, MyExample4300PickListDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300PickListDTO> getActions() {
		return Actions.<MyExample4300PickListDTO>builder()
				.create().text("Add").add()
				.save().text("Save").add()
				.cancelCreate().text("Cancel").available(bc -> true).add()
				.delete().text("Delete").add()
				.build();
	}

}
