package org.demo.documentation.other.forceactive2;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;
import org.springframework.stereotype.Service;
;
import java.util.Objects;

@Service
public class MyExample4901Meta extends FieldMetaBuilder<MyExample4901DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4901DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4901DTO_.customFieldDouble);
        fields.setEnabled(MyExample4901DTO_.street);
        fields.setEnabled(MyExample4901DTO_.money);
        fields.setEnabled(MyExample4901DTO_.descriptionProduct);
        fields.setEnabled(MyExample4901DTO_.product);
        fields.setEnabled(MyExample4901DTO_.country);
        fields.setEnabled(MyExample4901DTO_.region);
        fields.setEnabled(MyExample4901DTO_.customField);

        fields.setEnumValues(MyExample4901DTO_.country, CountryEnum.values());
        fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.values());

        if (Objects.equals(fields.getCurrentValue(MyExample4901DTO_.country).orElse(null), CountryEnum.BELARUS)) {
            fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.BREST, RegionEnum.GOMEL, RegionEnum.MINSK);
        } else if (Objects.equals(fields.getCurrentValue(MyExample4901DTO_.country).orElse(null), CountryEnum.RUSSIA)) {
            fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.KOSTROMSKAYA, RegionEnum.MOSCOWSKAYA, RegionEnum.VOLGOGRADSKAYA);
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4901DTO_.country)) {
            if (fields.getCurrentValue(MyExample4901DTO_.country).isEmpty()) {
                fields.setCurrentValue(MyExample4901DTO_.region, null);
                fields.setCurrentValue(MyExample4901DTO_.street, null);
                fields.setCurrentValue(MyExample4901DTO_.customField, null);
            } else if (Objects.equals(fields.getCurrentValue(MyExample4901DTO_.country).orElse(null), CountryEnum.BELARUS)) {
                fields.setCurrentValue(MyExample4901DTO_.region, RegionEnum.MINSK);
                fields.setCurrentValue(MyExample4901DTO_.street, "Avenue Nezavisimosti");
                fields.setCurrentValue(MyExample4901DTO_.customField, "New value for BELARUS");
            } else if (Objects.equals(fields.getCurrentValue(MyExample4901DTO_.country).orElse(null), CountryEnum.RUSSIA)) {
                //fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.KOSTROMSKAYA, RegionEnum.MOSCOWSKAYA, RegionEnum.VOLGOGRADSKAYA);
                fields.setCurrentValue(MyExample4901DTO_.region, RegionEnum.MOSCOWSKAYA);
                fields.setCurrentValue(MyExample4901DTO_.street, "Tverskaya street");
                fields.setCurrentValue(MyExample4901DTO_.customField, "New value for RUSSIA");
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4901DTO_.region)) {
            if ((Objects.equals(fields.getCurrentValue(MyExample4901DTO_.region).orElse(null), RegionEnum.MINSK))) {
                fields.setCurrentValue(MyExample4901DTO_.street, "Avenue Nezavisimosti");
                fields.setCurrentValue(MyExample4901DTO_.customField, "New value Minsk");
            } else if ((Objects.equals(fields.getCurrentValue(MyExample4901DTO_.region).orElse(null), RegionEnum.GOMEL))) {
                fields.setCurrentValue(MyExample4901DTO_.street, "Avenue Nezavisimosti Gomel");
                fields.setCurrentValue(MyExample4901DTO_.customField, "New value Gomel");
            } else if ((Objects.equals(fields.getCurrentValue(MyExample4901DTO_.region).orElse(null), RegionEnum.MOSCOWSKAYA))) {
                fields.setCurrentValue(MyExample4901DTO_.street, "Tverskaya street");
                fields.setCurrentValue(MyExample4901DTO_.customField, "New value");
            } else {
                fields.setCurrentValue(MyExample4901DTO_.street, null);
                fields.setCurrentValue(MyExample4901DTO_.customField, null);
            }
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4901DTO_.street)) {
            fields.setCurrentValue(MyExample4901DTO_.customField, "New value");
        }

        if (fields.isFieldChangedNowFE(fields, MyExample4901DTO_.customFieldDouble)) {
            fields.setCurrentValue(MyExample4901DTO_.customField, "");
        }

        if (fields.isFieldChangedNowFEForRowMeta(fields, MyExample4901DTO_.country)) {
            fields.setCurrentValue(MyExample4901DTO_.customField, "New value - call /row-meta Post(FA)");
        }
        if (fields.isFieldChangedNowFEForCustomAction(fields, MyExample4901DTO_.customFieldDouble, "customSave")) {
            fields.setCurrentValue(MyExample4901DTO_.customField, "New value - call /customSave");
        }
        if (fields.isFieldChangedNowFEForData(fields, MyExample4901DTO_.customFieldDouble)) {
            fields.setCurrentValue(MyExample4901DTO_.customField, "New value - call /data");
        }


    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4901DTO> fields, InnerBcDescription bcDescription, Long
            parentId) {
        fields.enableFilter(MyExample4901DTO_.customFieldDouble);
        fields.enableFilter(MyExample4901DTO_.street);
        fields.enableFilter(MyExample4901DTO_.money);
        fields.enableFilter(MyExample4901DTO_.descriptionProduct);
        fields.enableFilter(MyExample4901DTO_.product);
        fields.setEnumFilterValues(fields, MyExample4901DTO_.country, CountryEnum.values());
        fields.enableFilter(MyExample4901DTO_.country);
        fields.setEnumFilterValues(fields, MyExample4901DTO_.region, RegionEnum.values());
        fields.enableFilter(MyExample4901DTO_.region);

        fields.setForceActive(MyExample4901DTO_.region);
        fields.setForceActive(MyExample4901DTO_.country);
        fields.setForceActive(MyExample4901DTO_.money);
        fields.setForceActive(MyExample4901DTO_.product);
        fields.setForceActive(MyExample4901DTO_.descriptionProduct);
    }

}