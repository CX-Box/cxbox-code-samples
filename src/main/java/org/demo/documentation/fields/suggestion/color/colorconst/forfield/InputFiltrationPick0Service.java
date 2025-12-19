package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.input.filtration.InputFiltration;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPick0Meta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class InputFiltrationPick0Service extends VersionAwareResponseService<InputFiltrationPick0DTO, InputFiltration> {

    @Getter(onMethod_ = @Override)
    private final Class<InputFiltrationPick0Meta> meta = InputFiltrationPick0Meta.class;

    @Override
    protected CreateResult<InputFiltrationPick0DTO> doCreateEntity(InputFiltration entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<InputFiltrationPick0DTO> doUpdateEntity(InputFiltration entity, InputFiltrationPick0DTO data,
                                                                      BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}