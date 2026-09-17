package org.demo.documentation.fields.multipleselect.longvalues;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.multipleselect.longvalues.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3358Service extends VersionAwareResponseService<MyExample3358DTO, MyEntity3358> {

	private final MyEntity3358Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3358Meta> meta = MyExample3358Meta.class;

	@Override
	protected CreateResult<MyExample3358DTO> doCreateEntity(MyEntity3358 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3358DTO> doUpdateEntity(MyEntity3358 entity, MyExample3358DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3358DTO_.customField)) {
			entity.setCustomField(
					data.getCustomField().getValues()
							.stream()
							.map(v -> CustomFieldEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}

		if (data.isFieldChanged(MyExample3358DTO_.comment)) {
			entity.setComment(data.getComment());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3358DTO> getActions() {
		return Actions.<MyExample3358DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}