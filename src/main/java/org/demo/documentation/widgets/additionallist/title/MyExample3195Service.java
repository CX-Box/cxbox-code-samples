package org.demo.documentation.widgets.additionallist.title;

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
public class MyExample3195Service extends VersionAwareResponseService<MyExample3195DTO, MyEntity3195> {

	private final MyEntity3195Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3195Meta> meta = MyExample3195Meta.class;

	@Override
	protected CreateResult<MyExample3195DTO> doCreateEntity(MyEntity3195 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3195DTO> doUpdateEntity(MyEntity3195 entity, MyExample3195DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3195DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3195DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3195DTO> getActions() {
		return Actions.<MyExample3195DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

