package org.demo.documentation.fields.multipleselect.ro;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.ro.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample253Service extends VersionAwareResponseService<MyExample253DTO, MyEntity253> {

	private final MyEntity253Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample253Meta> meta = MyExample253Meta.class;

    @Override
	protected CreateResult<MyExample253DTO> doCreateEntity(MyEntity253 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample253DTO> doUpdateEntity(MyEntity253 entity, MyExample253DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample253DTO_.customField)) {
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
	public Actions<MyExample253DTO> getActions() {
		return Actions.<MyExample253DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}