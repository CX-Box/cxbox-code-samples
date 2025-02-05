package org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3125Meta extends FieldMetaBuilder<MyExample3125DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3125DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(MyExample3125DTO_.underinsurancePercentage);
        fields.setEnabled(MyExample3125DTO_.annualPremium);
        fields.setEnabled(MyExample3125DTO_.grossAnnualRate);
        fields.setEnabled(MyExample3125DTO_.acquisition);
        fields.setEnabled(MyExample3125DTO_.netAnnualRate);
        fields.setEnabled(MyExample3125DTO_.insuranceAmount);
        fields.setEnabled(MyExample3125DTO_.insuranceValue);
        fields.setEnabled(MyExample3125DTO_.object);
        fields.setEnabled(MyExample3125DTO_.location);
        fields.setEnabled(MyExample3125DTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<MyExample3125DTO> fields, InnerBcDescription bcDescription, Long parentId) {
        fields.enableFilter(MyExample3125DTO_.underinsurancePercentage);
        fields.enableFilter(MyExample3125DTO_.annualPremium);
        fields.enableFilter(MyExample3125DTO_.grossAnnualRate);
        fields.enableFilter(MyExample3125DTO_.acquisition);
        fields.enableFilter(MyExample3125DTO_.netAnnualRate);
        fields.enableFilter(MyExample3125DTO_.insuranceAmount);
        fields.enableFilter(MyExample3125DTO_.insuranceValue);
        fields.enableFilter(MyExample3125DTO_.object);
        fields.enableFilter(MyExample3125DTO_.location);
    }

}