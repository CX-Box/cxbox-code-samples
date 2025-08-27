package org.demo.documentation.widgets.property.sethidden;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity5019MultiPickService extends VersionAwareResponseService<MyEntity5019MultiPickDTO, MyEntity5019Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5019MultiPickMeta> meta = MyEntity5019MultiPickMeta.class;

    @Override
    protected CreateResult<MyEntity5019MultiPickDTO> doCreateEntity(MyEntity5019Multi entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5019MultiPickDTO> doUpdateEntity(MyEntity5019Multi entity, MyEntity5019MultiPickDTO data,
                                                                       BusinessComponent bc) {
        setIfChanged(data, MyEntity5019MultiPickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyEntity5019MultiPickDTO> getActions() {
        return Actions.<MyEntity5019MultiPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}