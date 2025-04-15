package org.demo.documentation.fields.hint.filtration;

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
public class MyExample162Service extends VersionAwareResponseService<MyExample162DTO, MyEntity162> {

	private final MyEntity162Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample162Meta> meta = MyExample162Meta.class;

    @Override
	protected CreateResult<MyExample162DTO> doCreateEntity(MyEntity162 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample162DTO> doUpdateEntity(MyEntity162 entity, MyExample162DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample162DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample162DTO> getActions() {
		return Actions.<MyExample162DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}