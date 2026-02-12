package org.demo.documentation.widgets.property.collapse;

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
public class MyExample3022Service extends VersionAwareResponseService<MyExample3022DTO, MyEntity3022> {

	private final MyEntity3022Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3022Meta> meta = MyExample3022Meta.class;

	@Override
	protected CreateResult<MyExample3022DTO> doCreateEntity(MyEntity3022 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3022DTO> doUpdateEntity(MyEntity3022 entity, MyExample3022DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3022DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3022DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3022DTO> getActions() {
		return Actions.<MyExample3022DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

