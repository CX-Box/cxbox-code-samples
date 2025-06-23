package org.demo.documentation.other.forceactive2.forproject;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample4903Service extends VersionAwareResponseService<MyExample4903DTO, MyEntity4903> {

    private final MyEntity4903Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample4903Service(MyEntity4903Repository repository) {
        super(MyExample4903DTO.class, MyEntity4903.class, null, MyExample4903Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample4903DTO> doCreateEntity(MyEntity4903 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4903DTO> doUpdateEntity(MyEntity4903 entity, MyExample4903DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4903DTO_.nameOSPId)) {
            entity.setNameOSPEntity(data.getNameOSPId() != null
                    ? entityManager.getReference(MyEntity4903OCPPick.class, data.getNameOSPId())
                    : null);
        }
        setIfChanged(data, MyExample4903DTO_.placePresentation, entity::setPlacePresentation);
        if (data.isFieldChanged(MyExample4903DTO_.nameFSPPId)) {
            entity.setNameFSPPEntity(data.getNameFSPPId() != null
                    ? entityManager.getReference(MyEntity4903Pick.class, data.getNameFSPPId())
                    : null);
        }
        if (data.isFieldChanged(MyExample4903DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4903DTO> getActions() {
        return Actions.<MyExample4903DTO>builder()
                .create().text("Add").add()
                .save().text("Save").add()
                .cancelCreate().text("Cancel").available(bc -> true).add()
                .delete().text("Delete").add()
                .build();
    }

}