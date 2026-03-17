package org.demo.documentation.other.parentchild.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExampleBc3045ChildMetaBuilder extends FieldMetaBuilder<MyExampleBc3045ChildDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExampleBc3045ChildDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExampleBc3045ChildDTO_.customField);
		fields.setEnabled(
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.id,
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.myExampleBc3045Id

		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExampleBc3045ChildDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExampleBc3045ChildDTO_.customField);
		fields.enableFilter(
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.id,
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.myExampleBc3045Id

		);
		fields.enableSort(
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.id,
				org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildDTO_.myExampleBc3045Id

		);
	}

}
