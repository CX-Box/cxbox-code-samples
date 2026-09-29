package org.demo.documentation.widgets.column2d.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.widgets.column2d.data.MyEntity4252Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample4258Meta extends AnySourceFieldMetaBuilder<MyExample4258DTO> {

	private final MyEntity4252Repository repository;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4258DTO> fields, BcDescription bc,
			String id, String parentId) {
		String clientName = repository.getReferenceById(Long.parseLong(id)).getClientName();
		fields.setDrilldownWithFilter(
				MyExample4258DTO_.clientName,
				DrillDownType.INNER,
				"/screen/myexample4258/view/myexample4258sales",
				fc -> fc.add(
						PlatformMyExample4258Controller.myExampleBc4258Sale,
						MyExample4258SaleDTO.class,
						fb -> fb.input(MyExample4258SaleDTO_.clientName, clientName)
				)
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4258DTO> fields, BcDescription bc, String parentId) {
	}

}
