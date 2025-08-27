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
public class MyEntity5019PickPickService extends VersionAwareResponseService<MyEntity5019PickPickDTO, MyEntity5019Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity5019PickPickMeta> meta = MyEntity5019PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity5019PickPickDTO> doCreateEntity(MyEntity5019Pick entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity5019PickPickDTO> doUpdateEntity(MyEntity5019Pick entity, MyEntity5019PickPickDTO data,
                                                                      BusinessComponent bc) {
		setIfChanged(data, MyEntity5019PickPickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    @Override
    public Actions<MyEntity5019PickPickDTO> getActions() {
        return Actions.<MyEntity5019PickPickDTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}