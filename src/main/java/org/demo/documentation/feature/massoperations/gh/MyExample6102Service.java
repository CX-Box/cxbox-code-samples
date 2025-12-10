package org.demo.documentation.feature.massoperations.gh;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.MassActionResultDTO;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.massoperations.enums.CustomFieldDictionaryEnum;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6102Service extends VersionAwareResponseService<MyExample6102DTO, MyEntity6102> {

    private final MyEntity6102Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample6102Meta> meta = MyExample6102Meta.class;

    @Override
    protected CreateResult<MyExample6102DTO> doCreateEntity(MyEntity6102 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample6102DTO> doUpdateEntity(MyEntity6102 entity, MyExample6102DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample6102DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample6102DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample6102DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample6102DTO> getActions() {
        return Actions.<MyExample6102DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("massEdit", "Mass Edit")
                        .scope(ActionScope.MASS)
                        .available(bc -> { return true;})
                        .massInvoker((bc, data, ids) -> {
                            var massResult = getMassDTO(data, ids, false);
                            return new MassActionResultDTO<MyExample6102DTO>(massResult)
                                    .setAction(PostAction.showMessage(MessageType.INFO, "The bulk field processing operation is complete"));
                        })
                )
                .build();
    }

    @NotNull
    private Set<MassDTO> getMassDTO(@NonNull MyExample6102DTO data, Set<String> ids, boolean onlyCheckboxChange) {
        return ids.stream()
                .map(id -> {
                    try {
                        MyEntity6102 myEntity6102BD = repository.findById(Long.parseLong(id)).orElseThrow();
                        if (myEntity6102BD.getCustomFieldDictionary() != null

                                && Objects.equals(myEntity6102BD.getCustomFieldDictionary().getValue(), CustomFieldDictionaryEnum.ERROR.getValue())) {
                            return MassDTO.fail(id, "cannot update Error");
                        }
                        MyEntity6102 myEntity6102 = repository.getReferenceById(Long.parseLong(id));
                        if (!onlyCheckboxChange) {
                            myEntity6102.setCustomFieldDictionary(data.getCustomFieldDictionary());
                        }
                        myEntity6102.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
                        return MassDTO.success(id);
                    } catch (Exception e) {
                        return MassDTO.fail(id, "cannot update");
                    }
                })
                .collect(Collectors.toSet());
    }

}