package org.demo.documentation.other.forceactive;

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
public class MyExample3204Service extends VersionAwareResponseService<MyExample3204DTO, MyEntity3204> {

	private final MyEntity3204Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3204Meta> meta = MyExample3204Meta.class;

	@Override
	protected CreateResult<MyExample3204DTO> doCreateEntity(MyEntity3204 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3204DTO> doUpdateEntity(MyEntity3204 entity, MyExample3204DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3204DTO_.customFieldDrillDown, entity::setCustomFieldDrillDown);
		setIfChanged(data, MyExample3204DTO_.customFieldFA, entity::setCustomFieldFA);
		if (data.isFieldChanged(MyExample3204DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3204DTO> getActions() {
		return Actions.<MyExample3204DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

