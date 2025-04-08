package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

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
public class MyExample3869Service extends VersionAwareResponseService<MyExample3869DTO, MyEntity3869> {

    private final MyEntity3869Repository repository;

    public MyExample3869Service(MyEntity3869Repository repository) {
        super(MyExample3869DTO.class, MyEntity3869.class, null, MyExample3869Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3869DTO> doCreateEntity(MyEntity3869 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3869DTO> doUpdateEntity(MyEntity3869 entity, MyExample3869DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3869DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doAssociate]
    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        List<MyEntity3869> myEntityList = addNewRecords(data, bc);
        List<MyExample3869DTO> collect = myEntityList.stream()
                .map(e -> entityToDto(bc, e))
                .toList();
        return new AssociateResultDTO((List) collect);
    }
    // --8<-- [end:doAssociate]

    // --8<-- [start:addNewRecords]
    @SneakyThrows
    private List<MyEntity3869> addNewRecords(List<AssociateDTO> dataIds, BusinessComponent bc) {
        List<MyEntity3869> recordList = new ArrayList<>();
        for (AssociateDTO item : dataIds) {
            MyEntity3869 myEntity3869 = new MyEntity3869().setAnySourceId(item.getId());
            recordList.add(repository.save(myEntity3869));
        }
        return recordList;
    }
    // --8<-- [end:addNewRecords]

    @Override
    public Actions<MyExample3869DTO> getActions() {
        return Actions.<MyExample3869DTO>builder()
                .associate(ast -> ast
                        .text("Popup Assoc")
                )
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

