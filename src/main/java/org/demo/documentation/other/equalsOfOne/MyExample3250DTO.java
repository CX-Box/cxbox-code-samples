package org.demo.documentation.other.equalsOfOne;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider.BaseEnum;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOne;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneManyToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToOne;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3250DTO extends DataResponseDTO {

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToOne.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneOneToOneDictionary;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToOne.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneOneToOneDictionaryRadio;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToOne.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneOneToOneMyExample3250Multivalues;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToOne.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneOneToOneMyExample3250MultivaluesHover;

	public String myExample3250OneToOneOneToOneMyExample3250MultivaluesHoverDisplayedKey;

	public String myExample3250OneToOneOneToOneMyExample3250MultivaluesDisplayedKey;

	@BaseEnum(MyExample3250ElementCollectionData.class)
	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToOne.myExample3250ElementCollectionData", provider = MultiFieldValueProvider.class, multiFieldKey = EnumValueProvider.class)
	private MultivalueField myExample3250OneToOneOneToOneMyExample3250ElementCollectionData;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToManies.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneOneToManiesDictionary;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToManies.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneOneToManiesDictionaryRadio;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToManies.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneOneToManiesMyExample3250Multivalues;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToManies.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneOneToManiesMyExample3250MultivaluesHover;

	public String myExample3250OneToOneOneToManiesMyExample3250MultivaluesDisplayedKey;

	public String myExample3250OneToOneOneToManiesMyExample3250MultivaluesHoverDisplayedKey;

	@BaseEnum(MyExample3250ElementCollectionData.class)
	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneOneToManies.myExample3250ElementCollectionData", provider = MultiFieldValueProvider.class, multiFieldKey = EnumValueProvider.class)
	private MultivalueField myExample3250OneToOneOneToManiesMyExample3250ElementCollectionData;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneManyToMany.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneManyToManyDictionary;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneManyToMany.dictionary", provider = EnumValueProvider.class)
	public MyExample3250Dictionary myExample3250OneToOneManyToManyDictionaryRadio;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneManyToMany.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneManyToManyMyExample3250Multivalues;

	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneManyToMany.myExample3250Multivalues.id", provider = MultiFieldValueProvider.class)
	public MultivalueField myExample3250OneToOneManyToManyMyExample3250MultivaluesHover;

	public String myExample3250OneToOneManyToManyMyExample3250MultivaluesHoverDisplayedKey;

	public String myExample3250OneToOneManyToManyMyExample3250MultivaluesDisplayedKey;

	@BaseEnum(MyExample3250ElementCollectionData.class)
	@SearchParameter(name = "myExample3250OneToOne.myExample3250OneToOneManyToMany.myExample3250ElementCollectionData", provider = MultiFieldValueProvider.class, multiFieldKey = EnumValueProvider.class)
	private MultivalueField myExample3250OneToOneManyToManyMyExample3250ElementCollectionData;

	public MyExample3250DTO(MyExample3250 entity) {
		this.id = entity.getId().toString();
		this.myExample3250OneToOneOneToOneDictionary = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getDictionary).orElse(null);

		this.myExample3250OneToOneOneToOneDictionaryRadio = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getDictionary).orElse(null);

		this.myExample3250OneToOneOneToOneMyExample3250Multivalues = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getMyExample3250Multivalues).stream()
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));

		this.myExample3250OneToOneOneToOneMyExample3250MultivaluesDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getMyExample3250Multivalues).stream()
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneOneToOneMyExample3250MultivaluesHover = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getMyExample3250Multivalues).stream()
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));

		this.myExample3250OneToOneOneToOneMyExample3250MultivaluesHoverDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getMyExample3250Multivalues).stream()
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneOneToOneMyExample3250ElementCollectionData = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToOne)
				.map(MyExample3250OneToOneOneToOne::getMyExample3250ElementCollectionData).stream()
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
								Enum::name,
								MyExample3250ElementCollectionData::getValue
						)
				);

		this.myExample3250OneToOneOneToManiesDictionary = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getDictionary).findFirst().orElse(null);

		this.myExample3250OneToOneOneToManiesDictionaryRadio = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getDictionary).findFirst().orElse(null);

		this.myExample3250OneToOneOneToManiesMyExample3250Multivalues = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));
		this.myExample3250OneToOneOneToManiesMyExample3250MultivaluesHover = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));

		this.myExample3250OneToOneOneToManiesMyExample3250MultivaluesDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneOneToManiesMyExample3250MultivaluesHoverDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneOneToManiesMyExample3250ElementCollectionData = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneOneToManies)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneOneToMany::getMyExample3250ElementCollectionData)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
								Enum::name,
								MyExample3250ElementCollectionData::getValue
						)
				);

		this.myExample3250OneToOneManyToManyDictionary = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getDictionary)
				.findFirst().orElse(null);
		this.myExample3250OneToOneManyToManyDictionaryRadio = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getDictionary)
				.findFirst().orElse(null);

		this.myExample3250OneToOneManyToManyMyExample3250Multivalues = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));

		this.myExample3250OneToOneManyToManyMyExample3250MultivaluesHover = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()),
						e -> String.valueOf(e.getName())
				));

		this.myExample3250OneToOneManyToManyMyExample3250MultivaluesDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneManyToManyMyExample3250MultivaluesHoverDisplayedKey = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getMyExample3250Multivalues)
				.flatMap(Collection::stream)
				.map(MyExample3250Multivalue::getName)
				.collect(Collectors.joining(","));

		this.myExample3250OneToOneManyToManyMyExample3250ElementCollectionData = Optional.of(entity)
				.map(MyExample3250::getMyExample3250OneToOne)
				.map(MyExample3250OneToOne::getMyExample3250OneToOneManyToMany)
				.stream()
				.flatMap(Collection::stream)
				.map(MyExample3250OneToOneManyToMany::getMyExample3250ElementCollectionData)
				.flatMap(Collection::stream)
				.collect(MultivalueField.toMultivalueField(
								Enum::name,
								MyExample3250ElementCollectionData::getValue
						)
				);
	}

}
