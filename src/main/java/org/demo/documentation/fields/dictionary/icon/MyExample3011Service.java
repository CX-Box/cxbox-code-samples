package org.demo.documentation.fields.dictionary.icon;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3013;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3011Service extends VersionAwareResponseService<MyExample3011DTO, MyEntity3011> {

    private final MyEntity3011Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3011Service(MyEntity3011Repository repository) {
        super(MyExample3011DTO.class, MyEntity3011.class, null, MyExample3011Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3011DTO> doCreateEntity(MyEntity3011 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3011DTO> doUpdateEntity(MyEntity3011 entity, MyExample3011DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3011DTO_.customFieldMultivalueModeIcon)) {
            entity.getCustomFieldMultivalueModeIconList().clear();
            entity.getCustomFieldMultivalueModeIconList().addAll(data.getCustomFieldMultivalueModeIcon().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3012Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3011DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3011Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3011DTO_.customFieldDictionaryInlinePickListId)) {
            entity.setCustomFieldDictionaryInlinePickListEntity(data.getCustomFieldDictionaryInlinePickListId() != null
                    ? entityManager.getReference(MyEntity3013.class, data.getCustomFieldDictionaryInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3011DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3012.class, data.getCustomFieldPickListId())
                    : null);
        }
        setIfChanged(data, MyExample3011DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3011DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3011DTO> getActions() {
        return Actions.<MyExample3011DTO>builder()
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .build();
    }


}

