package org.demo.documentation.fields.dictionary.filtration;

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
public class MyExample87Service extends VersionAwareResponseService<MyExample87DTO, MyEntity87> {

	private final MyEntity87Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample87Meta> meta = MyExample87Meta.class;

    @Override
	protected CreateResult<MyExample87DTO> doCreateEntity(MyEntity87 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample87DTO> doUpdateEntity(MyEntity87 entity, MyExample87DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample87DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample87DTO> getActions() {
		return Actions.<MyExample87DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}