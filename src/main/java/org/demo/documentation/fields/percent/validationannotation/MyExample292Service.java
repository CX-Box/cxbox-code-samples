package org.demo.documentation.fields.percent.validationannotation;

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
public class MyExample292Service extends VersionAwareResponseService<MyExample292DTO, MyEntity292> {

	private final MyEntity292Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample292Meta> meta = MyExample292Meta.class;

    @Override
	protected CreateResult<MyExample292DTO> doCreateEntity(MyEntity292 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample292DTO> doUpdateEntity(MyEntity292 entity, MyExample292DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample292DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample292DTO> getActions() {
		return Actions.<MyExample292DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}