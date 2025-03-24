package org.demo.documentation.other.forceactive2;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service
public class MyExample4901Meta extends FieldMetaBuilder<MyExample4901DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4901DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample4901DTO_.money);
        fields.setEnabled(MyExample4901DTO_.descriptionProduct);
        fields.setEnabled(MyExample4901DTO_.product);
        fields.setEnumValues(MyExample4901DTO_.country, CountryEnum.values());
        if (fields.getCurrentValue(MyExample4901DTO_.country).isPresent()) {
            if (CountryEnum.BELARUS.equals(fields.getCurrentValue(MyExample4901DTO_.country).get())) {
                fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.BREST, RegionEnum.GOMEL, RegionEnum.MINSK);
            } else if (CountryEnum.RUSSIA.equals(fields.getCurrentValue(MyExample4901DTO_.country).get())) {
                fields.setEnumValues(MyExample4901DTO_.region, RegionEnum.KOSTROMSKAYA, RegionEnum.MOSCOWSKAYA, RegionEnum.VOLGOGRADSKAYA);
            }
        }
        fields.setEnabled(MyExample4901DTO_.country);

        fields.setEnabled(MyExample4901DTO_.region);
        fields.setEnabled(MyExample4901DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample4901DTO> fields, InnerBcDescription bcDescription, Long parentId) {
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