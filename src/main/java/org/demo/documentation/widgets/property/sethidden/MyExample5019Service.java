package org.demo.documentation.widgets.property.sethidden;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5019Service extends VersionAwareResponseService<MyExample5019DTO, MyEntity5019> {

    private final MyEntity5019Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5019Meta> meta = MyExample5019Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample5019DTO> doCreateEntity(MyEntity5019 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5019DTO> doUpdateEntity(MyEntity5019 entity, MyExample5019DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample5019DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity5019Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample5019DTO_.customFieldMV)) {
            entity.getCustomFieldMVList().clear();
            entity.getCustomFieldMVList().addAll(data.getCustomFieldMV().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity5019Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample5019DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample5019DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    private ActionResultDTO<MyExample5019DTO> withApproval() {
        return new ActionResultDTO<>();
    }

    @Override
    public Actions<MyExample5019DTO> getActions() {
        return Actions.<MyExample5019DTO>builder()
                .action(act -> act
                        .action("save-send", "Save and send on approval")
                        .withPreAction(PreAction.confirmWithWidget("MyExample5019Formpopup",  cfw -> cfw
                                        .title("Approval?")
                                        .yesText("Approve and Save")
                                        .noText("Cancel")))
                        .invoker((bc, data) -> withApproval())
                )
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}