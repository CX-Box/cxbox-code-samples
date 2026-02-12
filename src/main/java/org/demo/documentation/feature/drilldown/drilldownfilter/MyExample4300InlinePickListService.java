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
public class MyExample4300InlinePickListService extends VersionAwareResponseService<MyExample4300InlinePickListDTO, MyEntity4300InlinePickList> {

	private final MyEntity4300InlinePickListRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300InlinePickListMeta> meta = MyExample4300InlinePickListMeta.class;

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
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
