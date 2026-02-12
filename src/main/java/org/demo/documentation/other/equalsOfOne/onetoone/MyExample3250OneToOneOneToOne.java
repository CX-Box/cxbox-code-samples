package org.demo.documentation.other.equalsOfOne.onetoone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.equalsOfOne.MyExample3250Dictionary;
import org.demo.documentation.other.equalsOfOne.MyExample3250ElementCollectionData;
import org.demo.documentation.other.equalsOfOne.MyExample3250Multivalue;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE")
@SuperBuilder
@NoArgsConstructor
public class MyExample3250OneToOneOneToOne extends BaseEntity {

	@OneToOne(mappedBy = "myExample3250OneToOneOneToOne")
	public MyExample3250OneToOne myExample3250OneToOne;

	@Enumerated(EnumType.STRING)
	private MyExample3250Dictionary dictionary;

	@ElementCollection(targetClass = MyExample3250ElementCollectionData.class)
	@CollectionTable(name = "MY_EXAMPLE3250_ELEMENT_COLLECTION_DATA_ENTITY", joinColumns = @JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE_ID"))
	@Column(name = "VALUE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<MyExample3250ElementCollectionData> myExample3250ElementCollectionData = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "MY_EXAMPLE3250_LINK_MULTIVALUE",
			joinColumns = @JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_EXAMPLE3250_MULTIVALUE_ID")
	)
	private Set<MyExample3250Multivalue> myExample3250Multivalues = new LinkedHashSet<>();

}