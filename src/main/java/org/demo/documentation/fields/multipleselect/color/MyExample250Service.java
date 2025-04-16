package org.demo.documentation.fields.multipleselect.color;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.color.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample250Service extends VersionAwareResponseService<MyExample250DTO, MyEntity250> {

	private final MyEntity250Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample250Meta> meta = MyExample250Meta.class;

    @Override
	protected CreateResult<MyExample250DTO> doCreateEntity(MyEntity250 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample250DTO> doUpdateEntity(MyEntity250 entity, MyExample250DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample250DTO_.customField)) {
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
	public Actions<MyExample250DTO> getActions() {
		return Actions.<MyExample250DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}