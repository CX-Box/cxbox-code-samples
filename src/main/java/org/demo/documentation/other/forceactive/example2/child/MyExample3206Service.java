package org.demo.documentation.other.forceactive.example2.child;

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
public class MyExample3206Service extends VersionAwareResponseService<MyExample3206DTO, MyEntity3206> {

	private final MyEntity3206Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3206Meta> meta = MyExample3206Meta.class;

	@Override
	protected CreateResult<MyExample3206DTO> doCreateEntity(MyEntity3206 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3206DTO> doUpdateEntity(MyEntity3206 entity, MyExample3206DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3206DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3206DTO> getActions() {
		return Actions.<MyExample3206DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

