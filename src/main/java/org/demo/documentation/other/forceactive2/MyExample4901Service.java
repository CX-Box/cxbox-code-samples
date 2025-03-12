package org.demo.documentation.other.forceactive2;

import org.cxbox.constgen.DtoField;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MyExample4901Service extends VersionAwareResponseService<MyExample4901DTO, MyEntity4901> {

    private final MyEntity4901Repository repository;

    public MyExample4901Service(MyEntity4901Repository repository) {
        super(MyExample4901DTO.class, MyEntity4901.class, null, MyExample4901Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4901DTO> doCreateEntity(MyEntity4901 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4901DTO> doUpdateEntity(MyEntity4901 entity, MyExample4901DTO data, BusinessComponent bc) {

        if (data.isFieldChangedCurrentIteration(MyExample4901DTO_.country)) {
            entity.setCountry(data.getCountry());
            entity.setRegion(null);
        }

        if (data.isFieldChanged(MyExample4901DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        setIfChangedCurrentIteration(data, MyExample4901DTO_.descriptionProduct, entity::setDescriptionProduct);
        setIfChangedCurrentIteration(data, MyExample4901DTO_.region, entity::setRegion);
        if (data.isFieldChanged(MyExample4901DTO_.product)) {
            entity.setProduct(data.getProduct());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }



    @Override
    public Actions<MyExample4901DTO> getActions() {
        return Actions.<MyExample4901DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

