package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent;

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
public class MyExample3169Service extends VersionAwareResponseService<MyExample3169DTO, MyEntity3169> {

    private final MyEntity3169Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3169Meta> meta = MyExample3169Meta.class;

    @Override
    protected CreateResult<MyExample3169DTO> doCreateEntity(MyEntity3169 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3169DTO> doUpdateEntity(MyEntity3169 entity, MyExample3169DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3169DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3169DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3169DTO> getActions() {
        return Actions.<MyExample3169DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

