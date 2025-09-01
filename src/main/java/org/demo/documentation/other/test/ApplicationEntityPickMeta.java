package org.demo.documentation.other.test;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class ApplicationEntityPickMeta extends FieldMetaBuilder<ApplicationEntityPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<ApplicationEntityPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.other.test.ApplicationEntityPickDTO_.id);
        fields.setEnabled(org.demo.documentation.other.test.ApplicationEntityPickDTO_.name);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<ApplicationEntityPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
