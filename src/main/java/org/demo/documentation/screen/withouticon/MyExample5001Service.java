package org.demo.documentation.screen.withouticon;

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
public class MyExample5001Service extends VersionAwareResponseService<MyExample5001DTO, MyEntity5001> {

	private final MyEntity5001Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample5001Meta> meta = MyExample5001Meta.class;

	@Override
	protected CreateResult<MyExample5001DTO> doCreateEntity(MyEntity5001 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5001DTO> doUpdateEntity(MyEntity5001 entity, MyExample5001DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample5001DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5001DTO> getActions() {
		return Actions.<MyExample5001DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}