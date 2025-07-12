package org.demo.documentation.fields.multipleselect.sorting;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.sorting.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample258Service extends VersionAwareResponseService<MyExample258DTO, MyEntity258> {

	private final MyEntity258Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample258Meta> meta = MyExample258Meta.class;

    @Override
	protected CreateResult<MyExample258DTO> doCreateEntity(MyEntity258 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample258DTO> doUpdateEntity(MyEntity258 entity, MyExample258DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample258DTO_.customField)) {
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
	public Actions<MyExample258DTO> getActions() {
		return Actions.<MyExample258DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}