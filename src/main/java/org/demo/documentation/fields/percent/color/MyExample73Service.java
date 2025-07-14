package org.demo.documentation.fields.percent.color;

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
public class MyExample73Service extends VersionAwareResponseService<MyExample73DTO, MyEntity73> {

	private final MyEntity73Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample73Meta> meta = MyExample73Meta.class;

    @Override
	protected CreateResult<MyExample73DTO> doCreateEntity(MyEntity73 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample73DTO> doUpdateEntity(MyEntity73 entity, MyExample73DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample73DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample73DTO> getActions() {
		return Actions.<MyExample73DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}