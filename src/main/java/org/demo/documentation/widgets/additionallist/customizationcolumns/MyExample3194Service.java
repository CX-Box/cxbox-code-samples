package org.demo.documentation.widgets.additionallist.customizationcolumns;

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
public class MyExample3194Service extends VersionAwareResponseService<MyExample3194DTO, MyEntity3194> {

	private final MyEntity3194Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3194Meta> meta = MyExample3194Meta.class;

	@Override
	protected CreateResult<MyExample3194DTO> doCreateEntity(MyEntity3194 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3194DTO> doUpdateEntity(MyEntity3194 entity, MyExample3194DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3194DTO_.customFieldText, entity::setCustomFieldText);
		if (data.isFieldChanged(MyExample3194DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3194DTO> getActions() {
		return Actions.<MyExample3194DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

