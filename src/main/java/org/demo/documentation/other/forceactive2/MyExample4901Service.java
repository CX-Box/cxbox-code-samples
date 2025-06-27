package org.demo.documentation.other.forceactive2;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.drilldown.goingbackafterdrilldown.MyExample3620DTO;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyExample4901Service extends VersionAwareResponseService<MyExample4901DTO, MyEntity4901> {

    private final MyEntity4901Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample4901Service(MyEntity4901Repository repository) {
        super(MyExample4901DTO.class, MyEntity4901.class, null, MyExample4901Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4901DTO> doCreateEntity(MyEntity4901 entity, BusinessComponent bc) {
        entity.setCountry(CountryEnum.RUSSIA);
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4901DTO> doUpdateEntity(MyEntity4901 entity, MyExample4901DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample4901DTO_.productType, entity::setProductType);
        setIfChanged(data, MyExample4901DTO_.money, entity::setMoney);
        setIfChanged(data, MyExample4901DTO_.customFieldDouble, entity::setCustomFieldDouble);
        setIfChanged(data, MyExample4901DTO_.street, entity::setStreet);
        setIfChanged(data, MyExample4901DTO_.region, entity::setRegion);
        setIfChanged(data, MyExample4901DTO_.country, entity::setCountry);
        setIfChanged(data, MyExample4901DTO_.customField, entity::setCustomField);
        setIfChanged(data, MyExample4901DTO_.product, entity::setProduct);
        setIfChanged(data, MyExample4901DTO_.descriptionProduct, entity::setDescriptionProduct);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4901DTO> getActions() {
        return Actions.<MyExample4901DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("customSave", "Custom Save")
                        .invoker(this::customSave)
                )
                .action(act -> act
                        .scope(ActionScope.RECORD)
                        .action("goto", "Save and Go to")
                        .withAutoSaveBefore()
                        .invoker((bc, dto) -> {
                            return new ActionResultDTO<MyExample4901DTO>().setAction(
                                    PostAction.drillDown(
                                            DrillDownType.INNER,
                                            "/screen/myexample4901/view/myexample4901form"
                                    ));
                        })
                )
                .build();
    }

    // --8<-- [start:customSave]
    private ActionResultDTO<MyExample4901DTO> customSave(BusinessComponent bc, MyExample4901DTO dto) {
        Optional<MyEntity4901> entity = repository.findById(bc.getIdAsLong());
        if (entity.isEmpty()) {
            return null;
        }
        entity.get()
                .setCountry(dto.getCountry())
                .setCustomField(dto.getCustomField())
                .setRegion(dto.getRegion())
                .setStreet(dto.getStreet())
                .setProduct(dto.getProduct())
                .setMoney(dto.getMoney())
                .setDescriptionProduct(dto.getDescriptionProduct());

        return new ActionResultDTO<>(entityToDto(bc, entity.get()));
    }
    // --8<-- [end:customSave]

}

