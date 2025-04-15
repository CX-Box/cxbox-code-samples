package org.demo.documentation.fields.radio.placeholder;

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
public class MyExample26Service extends VersionAwareResponseService<MyExample26DTO, MyEntity26> {

	private final MyEntity26Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample26Meta> meta = MyExample26Meta.class;

    @Override
	protected CreateResult<MyExample26DTO> doCreateEntity(MyEntity26 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample26DTO> doUpdateEntity(MyEntity26 entity, MyExample26DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample26DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample26DTO> getActions() {
		return Actions.<MyExample26DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}