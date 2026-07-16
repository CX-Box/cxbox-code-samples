package org.demo.documentation.fields.fileupload.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.customization.file.FileService;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_SIZE;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample103Service extends VersionAwareResponseService<MyExample103DTO, MyEntity103> {

	private final MyEntity103Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample103Meta> meta = MyExample103Meta.class;

	private final FileService fileService;

	@Override
	protected CreateResult<MyExample103DTO> doCreateEntity(MyEntity103 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample103DTO> doUpdateEntity(MyEntity103 entity, MyExample103DTO data,
	                                                          BusinessComponent bc) {
		if (data.isFieldChanged(MyExample103DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample103DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (data.getCustomField() != null && fileService.download(data.getCustomFieldId(),null).getLength() < 9 * 1024) {
				throw new BusinessException().addPopup(LESS_SIZE);
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample103DTO> getActions() {
		return Actions.<MyExample103DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}