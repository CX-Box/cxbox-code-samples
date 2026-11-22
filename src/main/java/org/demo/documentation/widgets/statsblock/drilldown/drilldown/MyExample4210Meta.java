package org.demo.documentation.widgets.statsblock.drilldown.drilldown;

import lombok.NonNull;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.MyExample4208DTO;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.MyExample4208DTO_;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.PlatformMyExample4208Controller;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.demo.documentation.widgets.statsblock.drilldown.drilldown.MyExample4210Dao.*;

@Service
public class MyExample4210Meta extends AnySourceFieldMetaBuilder<MyExample4210DTO> {


	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4210DTO> fields, BcDescription bc,
									  String id, String parentId) {
		fields.setDrilldownWithFilter(
				MyExample4210DTO_.value,
				DrillDownType.INNER,
				"/screen/myexample4210/view/myexample4210list",
				fc -> fc
						.add(PlatformMyExample4208Controller.myExampleBc4208, MyExample4208DTO.class, fb -> fb
								.dictionaryEnum(MyExample4208DTO_.customFieldStatus, getStatusFilterValues(id)))

		);
	}

	private List<CustomFieldEnum> getStatusFilterValues(@NonNull String id) {
		if (ROW_ID_0.equals(id)) {
			return List.of(CustomFieldEnum.NEW);
		} else if (ROW_ID_1.equals(id)) {
			return List.of(CustomFieldEnum.IN_PROGRESS);
		} else if (ROW_ID_2.equals(id)) {
			return List.of(CustomFieldEnum.CLOSE);
		} else if (ROW_ID_3.equals(id)) {
			return List.of(CustomFieldEnum.NEW, CustomFieldEnum.IN_PROGRESS);
		}
		throw new IllegalStateException("Unexpected value: " + id);
	}

	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4210DTO> fields, BcDescription bc, String parentId) {
	}
	// --8<-- [end:buildIndependentMeta]
}