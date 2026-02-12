package org.demo.documentation.widgets.list.base.onefield;

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
public class MyExample3189Service extends VersionAwareResponseService<MyExample3189DTO, MyEntity3189> {

	private final MyEntity3189Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3189Meta> meta = MyExample3189Meta.class;

	@Override
	protected CreateResult<MyExample3189DTO> doCreateEntity(MyEntity3189 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3189DTO> doUpdateEntity(MyEntity3189 entity, MyExample3189DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3189DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3189DTO> getActions() {
		return Actions.<MyExample3189DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

