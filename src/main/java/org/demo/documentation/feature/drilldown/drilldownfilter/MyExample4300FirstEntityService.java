package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

@Service
@RequiredArgsConstructor
public class MyExample4300FirstEntityService extends VersionAwareResponseService<MyExample4300FirstEntityDTO, MyEntity4300FirstEntity> {

	private final MyEntity4300FirstEntityRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300FirstEntityMeta> meta = MyExample4300FirstEntityMeta.class;


	@Override
	protected CreateResult<MyExample4300FirstEntityDTO> doCreateEntity(MyEntity4300FirstEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4300FirstEntityDTO> doUpdateEntity(MyEntity4300FirstEntity entity, MyExample4300FirstEntityDTO data,
																																				BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4300FirstEntityDTO> getActions() {
		return Actions.<MyExample4300FirstEntityDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}
