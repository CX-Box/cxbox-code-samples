package org.demo.documentation.fields.multipleselect.validationannotation;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationannotation.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample345Service extends VersionAwareResponseService<MyExample345DTO, MyEntity345> {

	private final MyEntity345Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample345Meta> meta = MyExample345Meta.class;

    @Override
	protected CreateResult<MyExample345DTO> doCreateEntity(MyEntity345 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample345DTO> doUpdateEntity(MyEntity345 entity, MyExample345DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample345DTO_.customField)) {
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
	public Actions<MyExample345DTO> getActions() {
		return Actions.<MyExample345DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}