package org.demo.documentation.other.forceactive2.forproject;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.forceactive2.forproject.enums.PlacePresentationEnum;
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
        if (fields.isFieldChangedNowFE(fields,MyExample4903DTO_.placePresentation)){
            if (fields.getCurrentValue(MyExample4903DTO_.placePresentation).isEmpty()) {
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, null);
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, null);

                fields.setCurrentValue(MyExample4903DTO_.nameFSPP, null);
                fields.setCurrentValue(MyExample4903DTO_.nameFSPPId, null);
            }
        }

        if (fields.isFieldChangedNowFE(fields,MyExample4903DTO_.nameFSPP)){
            if (fields.getCurrentValue(MyExample4903DTO_.nameFSPP).isEmpty()) {
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, "");
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, null);
            }
            else if (fields.getCurrentValue(MyExample4903DTO_.nameFSPP).equals("FCPP1")) {
                MyEntity4903OCPPick  myEntity4903OCPPick = repositoryOCP.findByCustomField("OCP1");
                fields.setCurrentValue(MyExample4903DTO_.nameOSP, myEntity4903OCPPick.getCustomField());
                fields.setCurrentValue(MyExample4903DTO_.nameOSPId, myEntity4903OCPPick.getId());
            }
        }

        if (fields.isFieldChangedNowFE(fields,MyExample4903DTO_.nameOSP)){
            if (fields.getCurrentValue(MyExample4903DTO_.nameOSP).equals("OCP2")) {
                MyEntity4903Pick  myEntity4903Pick = repositoryPick.findByCustomField("FCPP2");
                fields.setCurrentValue(MyExample4903DTO_.nameFSPP, myEntity4903Pick.getCustomField());
                fields.setCurrentValue(MyExample4903DTO_.nameFSPPId, myEntity4903Pick.getId());
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
    public void buildIndependentMeta(FieldsMeta<MyExample4903DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample4903DTO_.nameOSP);
        fields.setEnumFilterValues(fields, MyExample4903DTO_.placePresentation, PlacePresentationEnum.values());
        fields.enableFilter(MyExample4903DTO_.placePresentation);
        fields.enableFilter(MyExample4903DTO_.nameFSPP);

        fields.setForceActive(MyExample4903DTO_.nameFSPP);
        fields.setForceActive(MyExample4903DTO_.placePresentation);
        fields.setForceActive(MyExample4903DTO_.nameOSP);
    }

}