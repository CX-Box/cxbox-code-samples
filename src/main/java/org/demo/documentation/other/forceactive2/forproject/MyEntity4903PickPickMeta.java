package org.demo.documentation.other.forceactive2.forproject;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4903PickPickMeta extends FieldMetaBuilder<MyEntity4903PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity4903PickPickDTO> fields, InnerBcDescription bcDescription,
                                      Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.other.forceactive2.forproject.MyEntity4903PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.other.forceactive2.forproject.MyEntity4903PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity4903PickPickDTO> fields, InnerBcDescription bcDescription,
                                     Long parentId) {

	}

}
