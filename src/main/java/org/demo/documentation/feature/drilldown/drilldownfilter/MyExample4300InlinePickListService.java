package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

// 4300
// InlinePickList

@Service
public class MyExample4300InlinePickListService extends VersionAwareResponseService<MyExample4300InlinePickListDTO, MyEntity4300InlinePickList> {

	private final MyEntity4300InlinePickListRepository repository;

	public MyExample4300InlinePickListService(MyEntity4300InlinePickListRepository repository) {
		super(MyExample4300InlinePickListDTO.class, MyEntity4300InlinePickList.class, null, MyExample4300InlinePickListMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample4300InlinePickListDTO> doCreateEntity(MyEntity4300InlinePickList entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4300InlinePickListDTO> doUpdateEntity(MyEntity4300InlinePickList entity, MyExample4300InlinePickListDTO data,
																																					 BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300InlinePickListDTO> getActions() {
		return Actions.<MyExample4300InlinePickListDTO>builder()
				.create().text("Add").add()
				.save().text("Save").add()
				.cancelCreate().text("Cancel").available(bc -> true).add()
				.delete().text("Delete").add()
				.build();
	}

}
