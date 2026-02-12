package org.demo.documentation.fields.datetime.placeholder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class DateTimePlaceholderService extends
		VersionAwareResponseService<DateTimePlaceholderDTO, DateTimePlaceholderEntity> {

	private final DateTimePlaceholderEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimePlaceholderMeta> meta = DateTimePlaceholderMeta.class;

	@Override
	protected CreateResult<DateTimePlaceholderDTO> doCreateEntity(DateTimePlaceholderEntity entity,
																  BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimePlaceholderDTO> doUpdateEntity(DateTimePlaceholderEntity entity,
																	 DateTimePlaceholderDTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimePlaceholderDTO> getActions() {
		return Actions.<DateTimePlaceholderDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}