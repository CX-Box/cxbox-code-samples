package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3154Service extends VersionAwareResponseService<MyExample3154DTO, MyEntity3154> {

	private final MyEntity3154Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3154Meta> meta = MyExample3154Meta.class;

	@Override
	protected CreateResult<MyExample3154DTO> doCreateEntity(MyEntity3154 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3154DTO> doUpdateEntity(MyEntity3154 entity, MyExample3154DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3154DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3154DTO> getActions() {
		return Actions.<MyExample3154DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

