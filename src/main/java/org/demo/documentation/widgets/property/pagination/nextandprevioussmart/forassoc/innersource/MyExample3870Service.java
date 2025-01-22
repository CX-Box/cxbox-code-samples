package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forassoc.innersource;

import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyExample3870Service extends VersionAwareResponseService<MyExample3870DTO, MyEntity3870> {

    private final MyEntity3870Repository repository;

    public MyExample3870Service(MyEntity3870Repository repository) {
        super(MyExample3870DTO.class, MyEntity3870.class, null, MyExample3870Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3870DTO> doCreateEntity(MyEntity3870 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3870DTO> doUpdateEntity(MyEntity3870 entity, MyExample3870DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3870DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doAssociate]
    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        List<MyEntity3870> myEntityList = addNewRecords(data, bc);
        List<MyExample3870DTO> collect = myEntityList.stream()
                .map(e -> entityToDto(bc, e))
                .toList();
        return new AssociateResultDTO((List) collect);
    }
    // --8<-- [end:doAssociate]

    // --8<-- [start:addNewRecords]
    @SneakyThrows
    private List<MyEntity3870> addNewRecords(List<AssociateDTO> dataIds, BusinessComponent bc) {
        List<MyEntity3870> recordList = new ArrayList<>();
        for (AssociateDTO item : dataIds) {
            MyEntity3870 myEntity3870 = new MyEntity3870().setAnySourceId(item.getId());
            recordList.add(repository.save(myEntity3870));
        }
        return recordList;
    }
    // --8<-- [end:addNewRecords]

    @Override
    public Actions<MyExample3870DTO> getActions() {
        return Actions.<MyExample3870DTO>builder()
                .associate(ast -> ast
                        .text("Popup Assoc")
                )
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}

