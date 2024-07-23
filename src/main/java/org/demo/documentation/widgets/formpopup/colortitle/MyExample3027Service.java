package org.demo.documentation.widgets.formpopup.colortitle;

import jakarta.persistence.EntityManager;
import lombok.NonNull;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.action.ActionsExt;
import org.demo.documentation.widgets.formpopup.base.MyExample3400DTO;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3041;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3043;
import org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3044;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3027Service extends VersionAwareResponseService<MyExample3027DTO, MyEntity3027> {

    private final MyEntity3027Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3027Service(MyEntity3027Repository repository) {
        super(MyExample3027DTO.class, MyEntity3027.class, null, MyExample3027Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3027DTO> doCreateEntity(MyEntity3027 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3027DTO> doUpdateEntity(MyEntity3027 entity, MyExample3027DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorInput)) {
            entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorText)) {
            entity.setCustomFieldColorText(data.getCustomFieldColorText());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorDateTime)) {
            entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorCheckbox)) {
            entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorDate)) {
            entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorDateTimeWithSeconds)) {
            entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorDictionary)) {
            entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorNumber)) {
            entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorPercent)) {
            entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorMoney)) {
            entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorRadio)) {
            entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorPicklistId)) {
            entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
                    ? entityManager.getReference(MyEntity3044.class, data.getCustomFieldColorPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorInlinePicklistId)) {
            entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3043.class, data.getCustomFieldColorInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3042.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3027DTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3041.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3027DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    private static PreAction confirmWithComment(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText + "?", "MyExample3027Formpopup", "Done", "Cancel");
    }

    private static PreAction confirmWithCommentColorConst(@NonNull String actionText) {
        return ActionsExt.confirmWithCustomWidget(actionText + "?", "MyExample3027FormPopupColorConst", "Done", "Cancel");
    }

    @Override
    public Actions<MyExample3027DTO> getActions() {
        return Actions.<MyExample3027DTO>builder()
                .newAction()
                .action("save-send-color-const", "Save and send on approval")
                .withPreAction(confirmWithCommentColorConst("Save and send on approval"))
                .invoker((bc, data) -> withApproval())
                .add()
                .newAction()
                .action("save-send-color", "Save and send on approval")
                .withPreAction(confirmWithComment("Save and send on approval"))
                .invoker((bc, data) -> withApproval())
                .add()
                .build();

    }

    private ActionResultDTO<MyExample3027DTO> withApproval() {
        return new ActionResultDTO<>();
    }

}

