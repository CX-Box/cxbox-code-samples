package org.demo.documentation.fields.date.placeholder;

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
public class DatePlaceholderService extends VersionAwareResponseService<DatePlaceholderDTO, DatePlaceholderEntity> {

	private final DatePlaceholderEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DatePlaceholderMeta> meta = DatePlaceholderMeta.class;

    @Override
	protected CreateResult<DatePlaceholderDTO> doCreateEntity(DatePlaceholderEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DatePlaceholderDTO> doUpdateEntity(DatePlaceholderEntity entity, DatePlaceholderDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DatePlaceholderDTO> getActions() {
		return Actions.<DatePlaceholderDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}