package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class InputFiltrationPick0Meta extends FieldMetaBuilder<InputFiltrationPick0DTO> {

    @Override
    public void buildRowDependentMeta(RowDependentFieldsMeta<InputFiltrationPick0DTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
        fields.setEnabled(org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPick0DTO_.id);
        fields.setEnabled(org.demo.documentation.fields.suggestion.color.colorconst.forfield.InputFiltrationPick0DTO_.inn);
    }

    @Override
    public void buildIndependentMeta(FieldsMeta<InputFiltrationPick0DTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

    }

}
