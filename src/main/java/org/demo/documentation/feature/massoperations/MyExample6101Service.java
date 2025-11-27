package org.demo.documentation.feature.massoperations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.*;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample6101Service extends VersionAwareResponseService<MyExample6101DTO, MyEntity6101> {

    private final MyEntity6101Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample6101Meta> meta = MyExample6101Meta.class;

    @Override
    protected CreateResult<MyExample6101DTO> doCreateEntity(MyEntity6101 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample6101DTO> doUpdateEntity(MyEntity6101 entity, MyExample6101DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample6101DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample6101DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample6101DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample6101DTO> getActions() {
        return Actions.<MyExample6101DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))

                // --8<-- [start:massEdit]
                .action(act -> act
                        .action("massEdit", "Mass Edit")
                        .withPreAction(PreAction.confirmWithWidget("myexample6101Form",
                                cfw -> cfw))
                        .scope(ActionScope.MASS)
                        .massInvoker((bc, data, ids) -> {
                            var massResult = ids.stream()
                                    .map(id -> {
                                        try {
                                            MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
                                            myEntity6101.setCustomFieldDictionary(data.getCustomFieldDictionary());
                                            myEntity6101.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
                                            return MassDTO.success(id);
                                        } catch (Exception e) {
                                            return MassDTO.fail(id, "cannot update");
                                        }
                                    })
                                    .collect(Collectors.toSet());
                            return new MassActionResultDTO<MyExample6101DTO>(massResult)
                                    .setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
                        })
                )
                // --8<-- [end:massEdit]

                // --8<-- [start:massCheckboxTrue]
                .action(act -> act
                        .action("massCheckboxTrue", "Mass Set Checkbox true")
                        .scope(ActionScope.MASS)
                        .massInvoker((bc, data, ids) -> {
                            var massResult = ids.stream()
                                    .map(id -> {
                                        try {
                                            MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
                                            myEntity6101.setCustomFieldCheckbox(true);
                                            return MassDTO.success(id);
                                        } catch (Exception e) {
                                            return MassDTO.fail(id, "Cannot update CustomFieldCheckbox");
                                        }
                                    })
                                    .collect(Collectors.toSet());
                            return new MassActionResultDTO<MyExample6101DTO>(massResult)
                                    .setAction(PostAction.showMessage(MessageType.INFO, "The CustomFieldCheckbox mass operation was completed!"));
                        })
                )

                // --8<-- [start:massEditCustomTitle]
                .action(act -> act
                        .action("massEditCustomTitle", "Mass Edit With Custom Text")
                        .withPreAction(PreAction.confirmWithWidget("myexample6101Form",
                                cfw -> cfw.noText("It is text no")
                                        .title("Mass Edit Title")
                                        .yesText("It is text yes")))
                        .scope(ActionScope.MASS)
                        .massInvoker((bc, data, ids) -> {
                            var massResult = ids.stream()
                                    .map(id -> {
                                        try {
                                            MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
                                            myEntity6101.setCustomFieldDictionary(data.getCustomFieldDictionary());
                                            myEntity6101.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
                                            return MassDTO.success(id);
                                        } catch (Exception e) {
                                            return MassDTO.fail(id, "cannot update");
                                        }
                                    })
                                    .collect(Collectors.toSet());
                            return new MassActionResultDTO<MyExample6101DTO>(massResult)
                                    .setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
                        })
                )
                // --8<-- [end:massEditCustomTitle]

                // --8<-- [start:massEditWithoutTitle]
                .action(act -> act
                        .action("massEditWithoutTitle", "Mass Edit Without Custom Text")
                        .withPreAction(PreAction.confirmWithWidget("myexample6101Form",
                                cfw -> cfw.withoutTitle()))
                        .scope(ActionScope.MASS)
                        .massInvoker((bc, data, ids) -> {
                            var massResult = ids.stream()
                                    .map(id -> {
                                        try {
                                            MyEntity6101 myEntity6101 = repository.getReferenceById(Long.parseLong(id));
                                            myEntity6101.setCustomFieldDictionary(data.getCustomFieldDictionary());
                                            myEntity6101.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
                                            return MassDTO.success(id);
                                        } catch (Exception e) {
                                            return MassDTO.fail(id, "cannot update");
                                        }
                                    })
                                    .collect(Collectors.toSet());
                            return new MassActionResultDTO<MyExample6101DTO>(massResult)
                                    .setAction(PostAction.showMessage(MessageType.INFO, "The fields mass operation was completed!"));
                        })
                )
                // --8<-- [end:massEditWithoutTitle]

                .build();
    }

}