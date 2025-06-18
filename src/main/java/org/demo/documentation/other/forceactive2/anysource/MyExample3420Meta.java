package org.demo.documentation.other.forceactive2.anysource;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyExample3420Meta extends AnySourceFieldMetaBuilder<MyExample3420DTO> {

    @Override  
   // --8<-- [start:buildRowDependentMeta]
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3420DTO> fields, BcDescription bcDescription,
                                      String id, String parentId) {
        fields.setEnabled(MyExample3420DTO_.street);
        fields.setEnabled(MyExample3420DTO_.money);
        fields.setEnabled(MyExample3420DTO_.descriptionProduct);
        fields.setEnabled(MyExample3420DTO_.product);
        fields.setEnabled(MyExample3420DTO_.country);
        fields.setEnabled(MyExample3420DTO_.region);
        fields.setEnabled(MyExample3420DTO_.customField);
        fields.setEnabled(MyExample3420DTO_.customFieldNew);
        fields.setEnabled(MyExample3420DTO_.customFieldDouble);
        fields.setEnabled(MyExample3420DTO_.customFieldDateTime);
        fields.setPlaceholder(MyExample3420DTO_.customFieldDateTime,"Less sysdate");
        fields.setEnumValues(MyExample3420DTO_.country, CountryEnum.values());
        fields.setEnumValues(MyExample3420DTO_.region, RegionEnum.values());

        if (Objects.equals(fields.getCurrentValue(MyExample3420DTO_.country).orElse(null), CountryEnum.BELARUS)) {
            fields.setEnumValues(MyExample3420DTO_.region, RegionEnum.BREST, RegionEnum.GOMEL, RegionEnum.MINSK);
        } else if (Objects.equals(fields.getCurrentValue(MyExample3420DTO_.country).orElse(null), CountryEnum.RUSSIA)) {
            fields.setEnumValues(MyExample3420DTO_.region, RegionEnum.KOSTROMSKAYA, RegionEnum.MOSCOWSKAYA, RegionEnum.VOLGOGRADSKAYA);
        }
        
        if (fields.isFieldChangedNowFE(fields, MyExample3420DTO_.country)) {
            if (fields.getCurrentValue(MyExample3420DTO_.country).isEmpty()) {
                fields.setCurrentValue(MyExample3420DTO_.region, null);
                fields.setCurrentValue(MyExample3420DTO_.street, null);
                fields.setCurrentValue(MyExample3420DTO_.customField, null);
            } else if (Objects.equals(fields.getCurrentValue(MyExample3420DTO_.country).orElse(null), CountryEnum.BELARUS)) {
                fields.setEnumValues(MyExample3420DTO_.region, RegionEnum.BREST, RegionEnum.GOMEL, RegionEnum.MINSK);
                fields.setCurrentValue(MyExample3420DTO_.region, RegionEnum.MINSK);
                fields.setCurrentValue(MyExample3420DTO_.street, "Avenue Nezavisimosti");
                fields.setCurrentValue(MyExample3420DTO_.customField, "New value for BELARUS");
            } else if (Objects.equals(fields.getCurrentValue(MyExample3420DTO_.country).orElse(null), CountryEnum.RUSSIA)) {
                fields.setEnumValues(MyExample3420DTO_.region, RegionEnum.KOSTROMSKAYA, RegionEnum.MOSCOWSKAYA, RegionEnum.VOLGOGRADSKAYA);
                fields.setCurrentValue(MyExample3420DTO_.region, RegionEnum.MOSCOWSKAYA);
                fields.setCurrentValue(MyExample3420DTO_.street, "Tverskaya street");
                fields.setCurrentValue(MyExample3420DTO_.customField, "New value for RUSSIA");
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample3420DTO_.region)) {
            if ((Objects.equals(fields.getCurrentValue(MyExample3420DTO_.region).orElse(null), RegionEnum.MINSK))) {
                fields.setCurrentValue(MyExample3420DTO_.street, "Avenue Nezavisimosti");
                fields.setCurrentValue(MyExample3420DTO_.customField, "New value Minsk");
            } else if ((Objects.equals(fields.getCurrentValue(MyExample3420DTO_.region).orElse(null), RegionEnum.GOMEL))) {
                fields.setCurrentValue(MyExample3420DTO_.street, "Avenue Nezavisimosti Gomel");
                fields.setCurrentValue(MyExample3420DTO_.customField, "New value Gomel");
            } else if ((Objects.equals(fields.getCurrentValue(MyExample3420DTO_.region).orElse(null), RegionEnum.MOSCOWSKAYA))) {
                fields.setCurrentValue(MyExample3420DTO_.street, "Tverskaya street");
                fields.setCurrentValue(MyExample3420DTO_.customField, "New value");
            }else {
                fields.setCurrentValue(MyExample3420DTO_.street, null);
                fields.setCurrentValue(MyExample3420DTO_.customField, null);
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample3420DTO_.street)) {
            fields.setCurrentValue(MyExample3420DTO_.customField, "New value");
        }

        if (fields.isFieldChangedNowFE(fields, MyExample3420DTO_.customFieldDouble)) {
            fields.setCurrentValue(MyExample3420DTO_.customField, "");
        }

        if (fields.isFieldChangedNowFEForRowMeta(fields, MyExample3420DTO_.country)) {
            fields.setCurrentValue(MyExample3420DTO_.customField, "New value - call /row-meta Post(FA)");
        }
        if (fields.isFieldChangedNowFEForCustomAction(fields, MyExample3420DTO_.customFieldDouble,"customButton")) {
            fields.setCurrentValue(MyExample3420DTO_.customField, "New value - call /customButton");
        }
        if (fields.isFieldChangedNowFEForData(fields, MyExample3420DTO_.customFieldDouble)) {
            fields.setCurrentValue(MyExample3420DTO_.customField, "New value - call /data");
        }


    }
   // --8<-- [end:buildRowDependentMeta]
    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3420DTO> fields, BcDescription bcDescription, String parentId) {

        fields.enableSort(MyExample3420DTO_.customField);
        fields.enableSort(MyExample3420DTO_.customFieldNew);
        fields.enableSort(MyExample3420DTO_.customFieldDateTime);
          fields.enableSort(MyExample3420DTO_.customFieldDouble);

        fields.setForceActive(MyExample3420DTO_.region);
        fields.setForceActive(MyExample3420DTO_.country);
        fields.setForceActive(MyExample3420DTO_.money);
        fields.setForceActive(MyExample3420DTO_.product);
        fields.setForceActive(MyExample3420DTO_.descriptionProduct);
    }

}
