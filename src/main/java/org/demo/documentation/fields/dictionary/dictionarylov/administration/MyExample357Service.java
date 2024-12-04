package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import jakarta.persistence.EntityManager;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.dictionary.entity.DictionaryItem;
import org.cxbox.model.dictionary.entity.DictionaryItem_;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MyExample357Service extends VersionAwareResponseService<MyExample357DTO, MyEntity357> {

    @Autowired
    private DictionaryCache dictionaryCache;

    private final MyEntity357Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample357Service(MyEntity357Repository repository) {
        super(MyExample357DTO.class, MyEntity357.class, null, MyExample357Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample357DTO> doCreateEntity(MyEntity357 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample357DTO> doUpdateEntity(MyEntity357 entity, MyExample357DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample357DTO_.active, entity::setActive);
        setIfChanged(data, MyExample357DTO_.description, entity::setDescription);
        setIfChanged(data, MyExample357DTO_.displayOrder, entity::setDisplayOrder);
        setIfChanged(data, MyExample357DTO_.value, entity::setValue);
        setIfChanged(data, MyExample357DTO_.key, entity::setKey);
        if (data.isFieldChanged(MyExample357DTO_.typeId)) {
            entity.setTypeEntity(data.getTypeId() != null
                    ? entityManager.getReference(DictionaryTypeDesc.class, data.getTypeId())
                    : null);
        }
        if (data.isFieldChanged(MyExample357DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample357DTO> getActions() {
        return Actions.<MyExample357DTO>builder()
                .action(act -> act
                        .action("reload-cache", "Clear Cache")
                        .scope(ActionScope.BC)
                        .invoker((bc, data) -> {
                            // This will not work in cluster (>1 app nodes).
                            // Please, add scheduler or other mechanism to clear cache in cluster
                            dictionaryCache.reload();
                            return new ActionResultDTO<>();
                        }))
                .create(crt -> crt.text("Create"))
                .cancelCreate(ccr -> ccr.text("Cancel"))
                .save(sv -> sv.text("Save"))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:validate]
    private void validate(BusinessComponent bc, ActionResultDTO<MyExample357DTO> result) {
        try {
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException uniqEx) {
                if (DictionaryItem.CONSTRAINT_UNIQ_TYPE_KEY.equalsIgnoreCase(uniqEx.getConstraintName())) {
                    throw new BusinessException(e).setEntity(new BusinessError.Entity(bc).addField(
                            DictionaryItem_.key.getName(),
                            "Key already exists for type " + result.getRecord().getType()));
                }
                if (DictionaryItem.CONSTRAINT_UNIQ_TYPE_VALUE.equalsIgnoreCase(uniqEx.getConstraintName())) {
                    throw new BusinessException(e).setEntity(new BusinessError.Entity(bc).addField(
                            DictionaryItem_.value.getName(),
                            "Value already exists for type " + result.getRecord().getType()));
                }
            }
            throw e;
        }
    }
    // --8<-- [end:validate]

}
