package org.demo.documentation.widgets.relationGraph;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.relationGraph.Myexample6150DTO_;
import org.demo.documentation.other.relationGraph.enums.TargetNodeTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class Myexample6150MetaBuilder extends FieldMetaBuilder<Myexample6150DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample6150DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample6150DTO_.targetNodeDescription);
		fields.setEnabled(Myexample6150DTO_.edgeValueBgColorKey);
		fields.setEnabled(Myexample6150DTO_.edgeValue);
		fields.setEnabled(Myexample6150DTO_.edgeDescription);
		fields.setEnabled(Myexample6150DTO_.targetNodeName);
		fields.setEnumValues(Myexample6150DTO_.targetNodeType, TargetNodeTypeEnum.values());
		fields.setEnabled(Myexample6150DTO_.targetNodeType);
		fields.setEnabled(Myexample6150DTO_.targetNodeBgColorKey);
		fields.setEnabled(Myexample6150DTO_.targetNodeId);
		fields.setEnabled(Myexample6150DTO_.sourceNodeId);

		fields.setDrilldown(Myexample6150DTO_.edgeValue, DrillDownType.INNER, "/screen/myexample6150/view/myexample6150/" + Myexample6150Controller.myexample6150 + "/" + id);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample6150DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample6150DTO_.targetNodeDescription);
		fields.enableFilter(Myexample6150DTO_.edgeValueBgColorKey);
		fields.enableFilter(Myexample6150DTO_.edgeValue);
		fields.enableFilter(Myexample6150DTO_.edgeDescription);
		fields.enableFilter(Myexample6150DTO_.targetNodeName);
		fields.setEnumFilterValues(fields, Myexample6150DTO_.targetNodeType, TargetNodeTypeEnum.values());
		fields.enableFilter(Myexample6150DTO_.targetNodeType);
		fields.enableFilter(Myexample6150DTO_.targetNodeBgColorKey);
		fields.enableFilter(Myexample6150DTO_.targetNodeId);
		fields.enableFilter(Myexample6150DTO_.sourceNodeId);
	}

}
