package org.demo.documentation.other.forceactive2;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

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

        // int intPosProduct = new ArrayList<>(data.getSequenceChangedFields()).indexOf(MyExample4901DTO_.product.getName());
        // int intPosPrice = new ArrayList<>(data.getSequenceChangedFields()).indexOf(MyExample4901DTO_.money.getName());
        // int intPosDescriptionProduct = new ArrayList<>(data.getSequenceChangedFields()).indexOf(MyExample4901DTO_.descriptionProduct.getName());

        //  int intPosCountry = new ArrayList<>(data.getSequenceChangedFields()).indexOf(MyExample4901DTO_.country.getName());
        //  int intPosRegion = new ArrayList<>(data.getSequenceChangedFields()).indexOf(MyExample4901DTO_.region.getName());

        if (data.isFieldChanged(MyExample4901DTO_.region)) {
            entity.setRegion(data.getRegion());
        }
        if (data.isFieldChanged(MyExample4901DTO_.country)) {
            entity.setCountry(data.getCountry());
         /*   if (intPosCountry > intPosRegion) {
                entity.setRegion(null);
            }*/
        }

        if (data.isFieldChanged(MyExample4901DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        setIfChanged(data, MyExample4901DTO_.product, entity::setProduct);
        setIfChanged(data, MyExample4901DTO_.descriptionProduct, entity::setDescriptionProduct);

        if (data.isFieldChanged(MyExample4901DTO_.product)) {
            entity.setProduct(data.getProduct());
      /*       if (intPosProduct > intPosDescriptionProduct) {
                entity.setDescriptionProduct(null);
            }
            if (intPosProduct > intPosPrice) {
                entity.setMoney(null);
            }*/
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

