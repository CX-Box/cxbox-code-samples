package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4300PickListService extends VersionAwareResponseService<MyExample4300PickListDTO, MyEntity4300PickList> {

	private final MyEntity4300PickListRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300PickListMeta> meta = MyExample4300PickListMeta.class;


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
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
