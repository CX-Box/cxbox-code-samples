package org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3125Service extends VersionAwareResponseService<MyExample3125DTO, MyEntity3125> {

    private final MyEntity3125Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3125Meta> meta = MyExample3125Meta.class;

    @Override
    protected CreateResult<MyExample3125DTO> doCreateEntity(MyEntity3125 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3125DTO> doUpdateEntity(MyEntity3125 entity, MyExample3125DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3125DTO_.underinsurancePercentage, entity::setUnderinsurancePercentage);
        setIfChanged(data, MyExample3125DTO_.annualPremium, entity::setAnnualPremium);
        setIfChanged(data, MyExample3125DTO_.grossAnnualRate, entity::setGrossAnnualRate);
        setIfChanged(data, MyExample3125DTO_.acquisition, entity::setAcquisition);
        setIfChanged(data, MyExample3125DTO_.netAnnualRate, entity::setNetAnnualRate);
        setIfChanged(data, MyExample3125DTO_.insuranceAmount, entity::setInsuranceAmount);
        setIfChanged(data, MyExample3125DTO_.insuranceValue, entity::setInsuranceValue);
        setIfChanged(data, MyExample3125DTO_.object, entity::setObject);
        setIfChanged(data, MyExample3125DTO_.location, entity::setLocation);
        if (data.isFieldChanged(MyExample3125DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3125DTO> getActions() {
        return Actions.<MyExample3125DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

