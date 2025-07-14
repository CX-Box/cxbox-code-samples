package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

// 4300
// SecondEntity

@Service
@RequiredArgsConstructor
public class MyExample4300SecondEntityService extends VersionAwareResponseService<MyExample4300SecondEntityDTO, MyEntity4300SecondEntity> {

	private final MyEntity4300SecondEntityRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300SecondEntityMeta> meta = MyExample4300SecondEntityMeta.class;


	@Override
	protected CreateResult<MyExample4300SecondEntityDTO> doCreateEntity(MyEntity4300SecondEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4300SecondEntityDTO> doUpdateEntity(MyEntity4300SecondEntity entity, MyExample4300SecondEntityDTO data,
																																				 BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300SecondEntityDTO> getActions() {
		return Actions.<MyExample4300SecondEntityDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
