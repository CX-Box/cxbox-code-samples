package org.demo.documentation.other.ingosexample;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.ingosexample.enums.AssignedUsers22Enum;
import org.demo.documentation.other.ingosexample.enums.AssignedUsers2Enum;
import org.demo.documentation.other.ingosexample.enums.AssignedUsersDisplayKeyEnum;
import org.demo.documentation.other.ingosexample.enums.AssignedUsersEnum;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6001Service extends VersionAwareResponseService<MyExample6001DTO, MyEntity6001> {

    private final MyEntity6001Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample6001Meta> meta = MyExample6001Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample6001DTO> doCreateEntity(MyEntity6001 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample6001DTO> doUpdateEntity(MyEntity6001 entity, MyExample6001DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample6001DTO_.assignedUsers22)) {
            entity.setAssignedUsers22(
                    data.getAssignedUsers22().getValues()
                            .stream()
                            .map(v -> AssignedUsers22Enum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample6001DTO_.assignedUsers2)) {
            entity.setAssignedUsers2(
                    data.getAssignedUsers2().getValues()
                            .stream()
                            .map(v -> AssignedUsers2Enum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample6001DTO_.businessUnitName2Id)) {
            entity.setBusinessUnitName2Entity(data.getBusinessUnitName2Id() != null
                    ? entityManager.getReference(ApplicationEntity.class, data.getBusinessUnitName2Id())
                    : null);
        }
        if (data.isFieldChanged(MyExample6001DTO_.assignedUsersDisplayKey)) {
            entity.setAssignedUsersDisplayKey(
                    data.getAssignedUsersDisplayKey().getValues()
                            .stream()
                            .map(v -> AssignedUsersDisplayKeyEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample6001DTO_.assignedUsers)) {
            entity.setAssignedUsers(
                    data.getAssignedUsers().getValues()
                            .stream()
                            .map(v -> AssignedUsersEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        setIfChanged(data, MyExample6001DTO_.territorialAffiliation, entity::setTerritorialAffiliation);
        setIfChanged(data, MyExample6001DTO_.requestType, entity::setRequestType);
        setIfChanged(data, MyExample6001DTO_.requestCategory, entity::setRequestCategory);
        setIfChanged(data, MyExample6001DTO_.businessUnitName, entity::setBusinessUnitName);
        setIfChanged(data, MyExample6001DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample6001DTO> getActions() {
        return Actions.<MyExample6001DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}