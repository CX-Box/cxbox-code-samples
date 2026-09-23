package org.demo.documentation.fields.richtext.ro;

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
public class MyExample427Service extends VersionAwareResponseService<MyExample427DTO, MyEntity427> {

	private final MyEntity427Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample427Meta> meta = MyExample427Meta.class;

	@Override
	protected CreateResult<MyExample427DTO> doCreateEntity(MyEntity427 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample427DTO> doUpdateEntity(MyEntity427 entity, MyExample427DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample427DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample427DTO> getActions() {
		return Actions.<MyExample427DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}