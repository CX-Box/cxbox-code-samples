package org.demo.documentation.fields.dictionary.longvalues;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S113359")
@RequiredArgsConstructor
@Service
public class MyExample3359Service extends VersionAwareResponseService<MyExample3359DTO, MyEntity3359> {

	private final MyEntity3359Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3359Meta> meta = MyExample3359Meta.class;

	@Override
	protected CreateResult<MyExample3359DTO> doCreateEntity(MyEntity3359 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3359DTO> doUpdateEntity(MyEntity3359 entity, MyExample3359DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3359DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		if (data.isFieldChanged(MyExample3359DTO_.comment)) {
			entity.setComment(data.getComment());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3359DTO> getActions() {
		return Actions.<MyExample3359DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}