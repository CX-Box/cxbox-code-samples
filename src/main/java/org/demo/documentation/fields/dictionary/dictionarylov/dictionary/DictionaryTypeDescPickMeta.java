package org.demo.documentation.fields.dictionary.dictionarylov.dictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DictionaryTypeDescPickMeta extends FieldMetaBuilder<DictionaryTypeDescPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DictionaryTypeDescPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
		fields.setEnabled(DictionaryTypeDescPickDTO_.id);
		fields.setEnabled(DictionaryTypeDescPickDTO_.type);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<DictionaryTypeDescPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

	}

}
