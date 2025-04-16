package org.demo.documentation.fields.multipleselect.validationconfirm;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.validationconfirm.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample260Service extends VersionAwareResponseService<MyExample260DTO, MyEntity260> {

	private final MyEntity260Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample260Meta> meta = MyExample260Meta.class;

    @Override
	protected CreateResult<MyExample260DTO> doCreateEntity(MyEntity260 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample260DTO> doUpdateEntity(MyEntity260 entity, MyExample260DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample260DTO_.customField)) {
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
	public Actions<MyExample260DTO> getActions() {
		return Actions.<MyExample260DTO>builder()
                .action(act -> act
                        .action("save", "save")
                        .withPreAction(PreAction.confirm("You want to save the value ?"))
                )
				.build();
	}
	// --8<-- [end:getActions]

}