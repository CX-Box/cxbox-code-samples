package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class InputFiltrationPickMeta extends FieldMetaBuilder<InputFiltrationPickDTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<InputFiltrationPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPickDTO_.id);
        fields.setEnabled(org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPickDTO_.customField);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<InputFiltrationPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
