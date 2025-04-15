package org.demo.documentation.fields.percent.additionalproperties.digits;


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
public class MyExample310Service extends VersionAwareResponseService<MyExample310DTO, MyEntity310> {

	private final MyEntity310Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample310Meta> meta = MyExample310Meta.class;

    @Override
	protected CreateResult<MyExample310DTO> doCreateEntity(MyEntity310 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample310DTO> doUpdateEntity(MyEntity310 entity, MyExample310DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample310DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample310DTO> getActions() {
		return Actions.<MyExample310DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}