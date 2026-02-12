package org.demo.documentation.fields.multipleselect.colorconst;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.colorconst.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample254Service extends VersionAwareResponseService<MyExample254DTO, MyEntity254> {

	private final MyEntity254Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample254Meta> meta = MyExample254Meta.class;

	@Override
	protected CreateResult<MyExample254DTO> doCreateEntity(MyEntity254 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample254DTO> doUpdateEntity(MyEntity254 entity, MyExample254DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample254DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample254DTO> getActions() {
		return Actions.<MyExample254DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}