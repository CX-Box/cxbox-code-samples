package org.demo.documentation.other.assoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LegalCaseDocumentsMetaBuilder extends FieldMetaBuilder<LegalCaseDocumentsDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<LegalCaseDocumentsDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(LegalCaseDocumentsDTO_.files);
		fields.setEnabled(LegalCaseDocumentsDTO_.fileNameId);
		fields.setEnabled(LegalCaseDocumentsDTO_.fileName);
		fields.setEnabled(
				org.demo.documentation.other.assoc.LegalCaseDocumentsDTO_.id
		);
		fields.setCurrentValue(LegalCaseDocumentsDTO_.files, new MultivalueField(Collections.emptyList()));
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<LegalCaseDocumentsDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(LegalCaseDocumentsDTO_.files);
		fields.enableFilter(LegalCaseDocumentsDTO_.fileName);
		fields.enableFilter(
				org.demo.documentation.other.assoc.LegalCaseDocumentsDTO_.id
		);
		fields.enableSort(
				org.demo.documentation.other.assoc.LegalCaseDocumentsDTO_.id
		);
	}

}
