package org.demo.documentation.fields.multipleselect.filtration;

import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.filtration.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample256Service extends VersionAwareResponseService<MyExample256DTO, MyEntity256> {

	private final MyEntity256Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample256Meta> meta = MyExample256Meta.class;

    @Override
	protected CreateResult<MyExample256DTO> doCreateEntity(MyEntity256 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample256DTO> doUpdateEntity(MyEntity256 entity, MyExample256DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample256DTO_.customField)) {
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
	public Actions<MyExample256DTO> getActions() {
		return Actions.<MyExample256DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}