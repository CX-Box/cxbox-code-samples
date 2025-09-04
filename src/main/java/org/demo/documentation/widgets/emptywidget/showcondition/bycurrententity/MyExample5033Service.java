package org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5033Service extends VersionAwareResponseService<MyExample5033DTO, MyEntity5033> {

    private final MyEntity5033Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5033Meta> meta = MyExample5033Meta.class;

    @Override
    protected CreateResult<MyExample5033DTO> doCreateEntity(MyEntity5033 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5033DTO> doUpdateEntity(MyEntity5033 entity, MyExample5033DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5033DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5033DTO> getActions() {
        return Actions.<MyExample5033DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}