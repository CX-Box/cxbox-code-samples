package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

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
public class MyExample3296Service extends VersionAwareResponseService<MyExample3296DTO, MyEntity3296> {

	private final MyEntity3296Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3296Meta> meta = MyExample3296Meta.class;

	@Override
	protected CreateResult<MyExample3296DTO> doCreateEntity(MyEntity3296 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3296DTO> doUpdateEntity(MyEntity3296 entity, MyExample3296DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3296DTO_.customFieldDictionaryLevelTwo, entity::setCustomFieldDictionaryLevelTwo);
		setIfChanged(data, MyExample3296DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		if (data.isFieldChanged(MyExample3296DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3296DTO> getActions() {
		return Actions.<MyExample3296DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

