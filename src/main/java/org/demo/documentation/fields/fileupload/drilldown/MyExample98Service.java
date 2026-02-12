package org.demo.documentation.fields.fileupload.drilldown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample98Service extends VersionAwareResponseService<MyExample98DTO, MyEntity98> {

	private final MyEntity98Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample98Meta> meta = MyExample98Meta.class;

	@Override
	protected CreateResult<MyExample98DTO> doCreateEntity(MyEntity98 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample98DTO> doUpdateEntity(MyEntity98 entity, MyExample98DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample98DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample98DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample98DTO> getActions() {
		return Actions.<MyExample98DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}