package org.demo.documentation.other.equalsOfOne;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

@Component
@RequiredArgsConstructor
public class MyExample3250Meta extends FieldMetaBuilder<MyExample3250DTO> {

	@Override
	public void buildRowDependentMeta(final RowDependentFieldsMeta<MyExample3250DTO> fields, final InnerBcDescription bcDescription, final Long id,
																		final Long parentId) {

	}

	@Override
	public void buildIndependentMeta(final FieldsMeta<MyExample3250DTO> fields, final InnerBcDescription bcDescription, final Long parentId) {
		fields.enableFilter(
				MyExample3250DTO_.myExample3250OneToOneOneToOneMyExample3250MultivaluesHover,
				MyExample3250DTO_.myExample3250OneToOneOneToOneMyExample3250Multivalues,
				MyExample3250DTO_.myExample3250OneToOneOneToOneMyExample3250ElementCollectionData,
				MyExample3250DTO_.myExample3250OneToOneOneToOneDictionaryRadio,
				MyExample3250DTO_.myExample3250OneToOneOneToOneDictionary,

				MyExample3250DTO_.myExample3250OneToOneOneToManiesMyExample3250MultivaluesHover,
				MyExample3250DTO_.myExample3250OneToOneOneToManiesMyExample3250Multivalues,
				MyExample3250DTO_.myExample3250OneToOneOneToManiesMyExample3250ElementCollectionData,
				MyExample3250DTO_.myExample3250OneToOneOneToManiesDictionaryRadio,
				MyExample3250DTO_.myExample3250OneToOneOneToManiesDictionary,

				MyExample3250DTO_.myExample3250OneToOneManyToManyMyExample3250MultivaluesHover,
				MyExample3250DTO_.myExample3250OneToOneManyToManyMyExample3250Multivalues,
				MyExample3250DTO_.myExample3250OneToOneManyToManyMyExample3250ElementCollectionData,
				MyExample3250DTO_.myExample3250OneToOneManyToManyDictionaryRadio,
				MyExample3250DTO_.myExample3250OneToOneManyToManyDictionary
		);

		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToOneDictionaryRadio, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToOneDictionary, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);

		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToManiesDictionaryRadio, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToManiesDictionary, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);

		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneManyToManyDictionaryRadio, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneManyToManyDictionary, Arrays
						.stream(MyExample3250Dictionary.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);

		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToOneMyExample3250ElementCollectionData, Arrays
						.stream(MyExample3250ElementCollectionData.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneOneToManiesMyExample3250ElementCollectionData, Arrays
						.stream(MyExample3250ElementCollectionData.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);
		fields.setConcreteFilterValues(
				MyExample3250DTO_.myExample3250OneToOneManyToManyMyExample3250ElementCollectionData, Arrays
						.stream(MyExample3250ElementCollectionData.values())
						.map(en -> new SimpleDictionary(en.name(), en.getValue()))
						.toList()
		);

	}

}
