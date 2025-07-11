package org.demo.documentation.fields.multipleselect.placeholder;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.placeholder.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample257Service extends VersionAwareResponseService<MyExample257DTO, MyEntity257> {

	private final MyEntity257Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample257Meta> meta = MyExample257Meta.class;

    @Override
	protected CreateResult<MyExample257DTO> doCreateEntity(MyEntity257 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample257DTO> doUpdateEntity(MyEntity257 entity, MyExample257DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample257DTO_.customField)) {
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
	public Actions<MyExample257DTO> getActions() {
		return Actions.<MyExample257DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}