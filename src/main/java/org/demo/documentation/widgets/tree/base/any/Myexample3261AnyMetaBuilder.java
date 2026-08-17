package org.demo.documentation.widgets.tree.base.any;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3261AnyMetaBuilder extends AnySourceFieldMetaBuilder<Myexample3261AnyDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3261AnyDTO> fields, BcDescription bcDescription, String id,
	                                  String parentId) {
		fields.setEnabled(
				org.demo.documentation.widgets.tree.any.Myexample3261AnyDTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3261AnyDTO> fields, BcDescription bcDescription, String parentId) {
		fields.enableFilter(
				org.demo.documentation.widgets.tree.any.Myexample3261AnyDTO_.id);
		fields.enableSort(
				org.demo.documentation.widgets.tree.any.Myexample3261AnyDTO_.id);
	}

}
