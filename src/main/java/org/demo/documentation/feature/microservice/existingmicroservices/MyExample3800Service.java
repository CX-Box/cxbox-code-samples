package org.demo.documentation.feature.microservice.existingmicroservices;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3800Service extends AnySourceVersionAwareResponseService<MyExample3800DTO, MyEntity3800OutServiceDTO> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExample3800Meta> meta = MyExample3800Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3800Dao> dao = MyEntity3800Dao.class;

    @Override
    protected CreateResult<MyExample3800DTO> doCreateEntity(MyEntity3800OutServiceDTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3800DTO> doUpdateEntity(MyEntity3800OutServiceDTO entity, MyExample3800DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3800DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3800DTO> getActions() {
        return Actions.<MyExample3800DTO>builder()
                .create(crt -> crt.text("Add"))
                .addGroup(
                        "actions",
                        "Actions",
                        0,
                        Actions.<MyExample3800DTO>builder()
                                .action(act -> act
                                        .action("delete", "delete")
                                )
                                .action(act -> act
                                        .action("save", "save")
                                )
                                .build()).
                build();
    }

}