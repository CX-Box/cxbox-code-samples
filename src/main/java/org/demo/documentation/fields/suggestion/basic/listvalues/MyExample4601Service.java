package org.demo.documentation.fields.suggestion.basic.listvalues;

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
public class MyExample4601Service extends VersionAwareResponseService<MyExample4601DTO, MyEntity4601> {

	private final MyEntity4601Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4601Meta> meta = MyExample4601Meta.class;

	@Override
	protected CreateResult<MyExample4601DTO> doCreateEntity(MyEntity4601 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample4601DTO> doUpdateEntity(MyEntity4601 entity, MyExample4601DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample4601DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	@Override
	public Actions<MyExample4601DTO> getActions() {
		return Actions.<MyExample4601DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

