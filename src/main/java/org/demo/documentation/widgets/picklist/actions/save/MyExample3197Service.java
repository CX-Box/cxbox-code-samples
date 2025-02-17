package org.demo.documentation.widgets.picklist.actions.save;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup.MyEntity3197Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample3197Service extends VersionAwareResponseService<MyExample3197DTO, MyEntity3197> {

    private final MyEntity3197Repository repository;
  @Autowired
  private EntityManager entityManager;

  public MyExample3197Service(MyEntity3197Repository repository) {
        super(MyExample3197DTO.class, MyEntity3197.class, null, MyExample3197Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3197DTO> doCreateEntity(MyEntity3197 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3197DTO> doUpdateEntity(MyEntity3197 entity, MyExample3197DTO data, BusinessComponent bc) {
      if (data.isFieldChanged(MyExample3197DTO_.customFieldPickListId)) {
        entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                ? entityManager.getReference(MyEntity3197Pick.class, data.getCustomFieldPickListId())
                : null);
      }
      if (data.isFieldChanged(MyExample3197DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3197DTO> getActions() {
        return Actions.<MyExample3197DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

}

