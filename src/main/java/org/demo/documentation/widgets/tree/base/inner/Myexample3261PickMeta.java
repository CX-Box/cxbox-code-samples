package org.demo.documentation.widgets.tree.base.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3261PickMeta extends FieldMetaBuilder<Myexample3261PickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3261PickDTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(Myexample3261PickDTO_.mnemonic);
		fields.setEnabled(Myexample3261PickDTO_.code);
		fields.setEnabled(Myexample3261PickDTO_.description);
		fields.setEnabled(Myexample3261PickDTO_.id);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3261PickDTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {
		fields.enableFilter(Myexample3261PickDTO_.mnemonic);
		fields.enableFilter(Myexample3261PickDTO_.code);
		fields.enableFilter(Myexample3261PickDTO_.description);
		fields.enableFilter(Myexample3261PickDTO_.parentId);
		fields.enableFilter(Myexample3261PickDTO_.id);
		fields.enableFilter(Myexample3261PickDTO_.isLeaf);
		fields.enableFilter(Myexample3261PickDTO_.department);
	}

}
