package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.fields.input.filtration.InputFiltration;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class InputFiltrationPickService extends VersionAwareResponseService<InputFiltrationPickDTO, InputFiltration> {

    @Getter(onMethod_ = @Override)
    private final Class<InputFiltrationPickMeta> meta = InputFiltrationPickMeta.class;

    @Override
    protected CreateResult<InputFiltrationPickDTO> doCreateEntity(InputFiltration entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<InputFiltrationPickDTO> doUpdateEntity(InputFiltration entity, InputFiltrationPickDTO data,
                                                                     BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}