package org.demo.documentation.widgets.tree.data.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.tree.base.inner.Myexample3261DTO;
import org.demo.documentation.widgets.tree.base.inner.Myexample3261DTO_;
import org.springframework.stereotype.Service;

@Service
public class Myexample3261MetaBuilder extends FieldMetaBuilder<Myexample3261DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3261DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3261DTO_.mnemonic);
		fields.setEnabled(Myexample3261DTO_.code);
		fields.setEnabled(Myexample3261DTO_.description);
		fields.setEnabled(Myexample3261DTO_.department);
		fields.setEnabled(
				Myexample3261DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3261DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3261DTO_.mnemonic);
		fields.enableFilter(Myexample3261DTO_.code);
		fields.enableFilter(Myexample3261DTO_.description);
		fields.enableFilter(Myexample3261DTO_.department);
		fields.enableFilter(Myexample3261DTO_.parentId);
		fields.enableFilter(Myexample3261DTO_.id);
		fields.enableSort(Myexample3261DTO_.mnemonic);
		fields.enableSort(Myexample3261DTO_.code);
		fields.enableSort(Myexample3261DTO_.description);
		fields.enableSort(Myexample3261DTO_.department);
		fields.enableSort(Myexample3261DTO_.parentId);
		fields.enableSort(Myexample3261DTO_.id);
	}

}
