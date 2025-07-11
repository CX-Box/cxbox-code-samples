package org.demo.documentation.fields.dictionary.placeholder;

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
public class MyExample88Service extends VersionAwareResponseService<MyExample88DTO, MyEntity88> {

	private final MyEntity88Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample88Meta> meta = MyExample88Meta.class;

    @Override
	protected CreateResult<MyExample88DTO> doCreateEntity(MyEntity88 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample88DTO> doUpdateEntity(MyEntity88 entity, MyExample88DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample88DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample88DTO> getActions() {
		return Actions.<MyExample88DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}