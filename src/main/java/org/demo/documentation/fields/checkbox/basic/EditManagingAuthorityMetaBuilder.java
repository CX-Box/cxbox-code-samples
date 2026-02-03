package org.demo.documentation.fields.checkbox.basic;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.checkbox.basic.enums.TypesEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class EditManagingAuthorityMetaBuilder extends FieldMetaBuilder<EditManagingAuthorityDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<EditManagingAuthorityDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(EditManagingAuthorityDTO_.otherType);
		fields.setConcreteValues(EditManagingAuthorityDTO_.types, Arrays.stream(TypesEnum.values())
				.map(TypesEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(EditManagingAuthorityDTO_.types);
		fields.setEnabled(EditManagingAuthorityDTO_.partyInn);
		fields.setEnabled(EditManagingAuthorityDTO_.partyName);
		fields.setEnabled(EditManagingAuthorityDTO_.partyType);
		fields.setEnabled(
				org.demo.documentation.fields.checkbox.basic.EditManagingAuthorityDTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<EditManagingAuthorityDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(EditManagingAuthorityDTO_.otherType);
		fields.setConcreteFilterValues(EditManagingAuthorityDTO_.types, Arrays.stream(TypesEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(EditManagingAuthorityDTO_.types);
		fields.enableFilter(EditManagingAuthorityDTO_.partyInn);
		fields.enableFilter(EditManagingAuthorityDTO_.partyName);
		fields.enableFilter(EditManagingAuthorityDTO_.partyType);
		fields.enableFilter(
				org.demo.documentation.fields.checkbox.basic.EditManagingAuthorityDTO_.id
		);
		fields.enableSort(
				org.demo.documentation.fields.checkbox.basic.EditManagingAuthorityDTO_.id
		);
	}

}
