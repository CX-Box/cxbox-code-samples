package org.demo.documentation.fields.multipleselect.drilldown;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.drilldown.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample255Service extends VersionAwareResponseService<MyExample255DTO, MyEntity255> {

	private final MyEntity255Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample255Meta> meta = MyExample255Meta.class;

    @Override
	protected CreateResult<MyExample255DTO> doCreateEntity(MyEntity255 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample255DTO> doUpdateEntity(MyEntity255 entity, MyExample255DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample255DTO_.customField)) {
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
	public Actions<MyExample255DTO> getActions() {
		return Actions.<MyExample255DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}