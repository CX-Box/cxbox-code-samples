package org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3126Service extends VersionAwareResponseService<MyExample3126DTO, MyEntity3126> {

    private final MyEntity3126Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3126Meta> meta = MyExample3126Meta.class;

    @Override
    protected CreateResult<MyExample3126DTO> doCreateEntity(MyEntity3126 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected MyExample3126DTO entityToDto(final BusinessComponent bc, final MyEntity3126 entity) {
        final MyExample3126DTO dto = super.entityToDto(bc, entity);
        List<MyEntity3126> entityList = repository.findAll();
        List<MyEntity3126> entityListObjectAll = repository.findAllByObject(entity.getObject());
        dto.setPercentInsuranceAmount( entity.getInsuranceValue() == null && entity.getInsuranceAmount() == null ?
                null :
                (float) Math.round((float)(entityListObjectAll.stream()
                        .filter(f -> f.getInsuranceAmount() != null)
                        .mapToLong(MyEntity3126::getInsuranceAmount).sum())/entityList.stream()
                        .filter(f -> f.getInsuranceAmount() != null)
                        .mapToLong(MyEntity3126::getInsuranceAmount).sum()*100));

        return dto;
    }

    @Override
    protected ActionResultDTO<MyExample3126DTO> doUpdateEntity(MyEntity3126 entity, MyExample3126DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3126DTO_.netAnnualRate, entity::setNetAnnualRate);
        setIfChanged(data, MyExample3126DTO_.insuranceAmount, entity::setInsuranceAmount);
        setIfChanged(data, MyExample3126DTO_.insuranceValue, entity::setInsuranceValue);
        setIfChanged(data, MyExample3126DTO_.object, entity::setObject);
        setIfChanged(data, MyExample3126DTO_.location, entity::setLocation);
        if (data.isFieldChanged(MyExample3126DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3126DTO> getActions() {
        return Actions.<MyExample3126DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

