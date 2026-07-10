package org.demo.documentation.widgets.ringprogress.drilldown.drilldown;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4219Meta extends AnySourceFieldMetaBuilder<MyExample4219DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4219DTO> fields, BcDescription bc,
									  String id, String parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4219DTO> fields, BcDescription bc, String parentId) {
	}
}
