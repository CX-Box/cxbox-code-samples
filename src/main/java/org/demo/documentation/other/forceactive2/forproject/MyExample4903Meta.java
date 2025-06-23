package org.demo.documentation.other.forceactive2.forproject;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.forceactive2.forproject.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyExample4903Meta extends FieldMetaBuilder<MyExample4903DTO> {
    @Autowired
    MyEntity4903PickRepository repositoryPick;

    @Autowired
    MyEntity4903PickOCPRepository repositoryOCP;

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4903DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4903DTO_.nameFileId);
        fields.setEnabled(MyExample4903DTO_.nameFile);
        fields.setEnumValues(MyExample4903DTO_.usersName, UsersNameEnum.values());
        fields.setEnabled(MyExample4903DTO_.usersName);
        fields.setEnumValues(MyExample4903DTO_.channel, ChannelEnum.values());
        fields.setEnabled(MyExample4903DTO_.channel);
        fields.setEnabled(MyExample4903DTO_.fileId);
        fields.setEnabled(MyExample4903DTO_.file);
        fields.setEnabled(MyExample4903DTO_.instanceId);
        fields.setEnabled(MyExample4903DTO_.instance);
        fields.setEnumValues(MyExample4903DTO_.fileType, FileTypeEnum.values());
        fields.setEnabled(MyExample4903DTO_.fileType);
        fields.setEnumValues(MyExample4903DTO_.objectType, ObjectTypeEnum.values());
        fields.setEnabled(MyExample4903DTO_.objectType);
        if (fields.isFieldChangedNowFE(fields, MyExample4903DTO_.placePresentation)) {
            if (fields.getCurrentValue(MyExample4903DTO_.placePresentation).isEmpty()) {
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, null);
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, null);

                fields.setCurrentValue(MyExample4903DTO_.nameFSPP, null);
                fields.setCurrentValue(MyExample4903DTO_.nameFSPPId, null);
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4903DTO_.nameFSPP)) {
            if (fields.getCurrentValue(MyExample4903DTO_.nameFSPP).isEmpty()) {
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, "");
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, null);
            } else if ("FCPP1".equals(fields.getCurrentValue(MyExample4903DTO_.nameFSPP).get())) {
                MyEntity4903OCPPick myEntity4903OCPPick = repositoryOCP.findByCustomField("OCP1");
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, myEntity4903OCPPick.getCustomField());
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, myEntity4903OCPPick.getId());
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4903DTO_.nameOSP)) {
            if (fields.getCurrentValue(MyExample4903DTO_.nameOSP).isPresent() &&
                    "OCP2".equals(fields.getCurrentValue(MyExample4903DTO_.nameOSP).get())) {
                MyEntity4903Pick myEntity4903Pick = repositoryPick.findByCustomField("FCPP2");
                fields.setCurrentValue(MyExample4903DTO_.nameFSPP, myEntity4903Pick.getCustomField());
                fields.setCurrentValue(MyExample4903DTO_.nameFSPPId, myEntity4903Pick.getId());
            }
        }

        if (fields.getCurrentValue(MyExample4903DTO_.objectType).isPresent() &&
                ObjectTypeEnum.OBJECT_TYPE_1.equals(fields.getCurrentValue(MyExample4903DTO_.objectType).get())) {
            fields.setHidden(MyExample4903DTO_.instance);
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4903DTO_.nameFile)) {
            if (fields.getCurrentValue(MyExample4903DTO_.nameFile).isPresent()) {
                if ("File name1".equals(fields.getCurrentValue(MyExample4903DTO_.nameFile).get())) {
                    fields.setCurrentValue(MyExample4903DTO_.usersName, UsersNameEnum.USER_1);
                } else if ("File name2".equals(fields.getCurrentValue(MyExample4903DTO_.nameFile).get())) {
                    fields.setCurrentValue(MyExample4903DTO_.usersName, UsersNameEnum.USER_2);
                } else if ("File name3".equals(fields.getCurrentValue(MyExample4903DTO_.nameFile).get())) {
                    fields.setCurrentValue(MyExample4903DTO_.usersName, UsersNameEnum.USER_3);
                }
            }
        }

        fields.setEnabled(MyExample4903DTO_.nameOSPId);
        fields.setEnabled(MyExample4903DTO_.nameOSP);
        fields.setEnumValues(MyExample4903DTO_.placePresentation, PlacePresentationEnum.values());
        fields.setEnabled(MyExample4903DTO_.placePresentation);
        fields.setEnabled(MyExample4903DTO_.nameFSPPId);
        fields.setEnabled(MyExample4903DTO_.nameFSPP);
        fields.setEnabled(MyExample4903DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4903DTO> fields, InnerBcDescription bcDescription, Long
            parentId) {
        fields.enableFilter(MyExample4903DTO_.nameFile);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.usersName, UsersNameEnum.values());
        fields.enableFilter(MyExample4903DTO_.usersName);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.channel, ChannelEnum.values());
        fields.enableFilter(MyExample4903DTO_.channel);
        fields.enableFilter(MyExample4903DTO_.file);
        fields.enableFilter(MyExample4903DTO_.instance);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.fileType, FileTypeEnum.values());
        fields.enableFilter(MyExample4903DTO_.fileType);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.objectType, ObjectTypeEnum.values());
        fields.enableFilter(MyExample4903DTO_.objectType);
        fields.enableFilter(MyExample4903DTO_.nameOSP);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.placePresentation, PlacePresentationEnum.values());
        fields.enableFilter(MyExample4903DTO_.placePresentation);
        fields.enableFilter(MyExample4903DTO_.nameFSPP);

        fields.setForceActive(MyExample4903DTO_.nameFSPP);
        fields.setForceActive(MyExample4903DTO_.placePresentation);
        fields.setForceActive(MyExample4903DTO_.nameOSP);
        fields.setForceActive(MyExample4903DTO_.nameFile);
        fields.setForceActive(MyExample4903DTO_.objectType);
        fields.setForceActive(MyExample4903DTO_.fileType);
        fields.setForceActive(MyExample4903DTO_.instance);
    }

}