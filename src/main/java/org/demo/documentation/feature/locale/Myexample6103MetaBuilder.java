package org.demo.documentation.feature.locale;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.locale.enums.FieldOfActivityEnum;
import org.demo.documentation.feature.locale.enums.StatusEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class Myexample6103MetaBuilder extends FieldMetaBuilder<Myexample6103DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample6103DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnumValues(Myexample6103DTO_.status, StatusEnum.values());
		fields.setEnabled(Myexample6103DTO_.status);
		fields.setDictionaryValues(Myexample6103DTO_.importance);
		fields.setEnabled(Myexample6103DTO_.importance);
		fields.setEnabled(Myexample6103DTO_.address);
		fields.setConcreteValues(Myexample6103DTO_.fieldOfActivity, Arrays.stream(FieldOfActivityEnum.values())
				.map(FieldOfActivityEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(Myexample6103DTO_.fieldOfActivity);
		fields.setEnabled(Myexample6103DTO_.fullName);
		fields.setEnabled(
				org.demo.documentation.feature.locale.Myexample6103DTO_.id
		);
		fields.setRequired(Myexample6103DTO_.importance);
		fields.setRequired(Myexample6103DTO_.fullName);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample6103DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, Myexample6103DTO_.status, StatusEnum.values());
		fields.enableFilter(Myexample6103DTO_.status);
		fields.setDictionaryFilterValues(Myexample6103DTO_.importance);
		fields.enableFilter(Myexample6103DTO_.importance);
		fields.enableFilter(Myexample6103DTO_.address);
		fields.setConcreteFilterValues(Myexample6103DTO_.fieldOfActivity, Arrays.stream(FieldOfActivityEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(Myexample6103DTO_.fieldOfActivity);
		fields.enableFilter(Myexample6103DTO_.fullName);
		fields.enableFilter(
				org.demo.documentation.feature.locale.Myexample6103DTO_.id
		);
		fields.enableSort(
				org.demo.documentation.feature.locale.Myexample6103DTO_.id
		);
	}

}
