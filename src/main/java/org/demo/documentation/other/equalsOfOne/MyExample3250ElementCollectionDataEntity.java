package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneManyToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "MY_EXAMPLE3250_ELEMENT_COLLECTION_DATA_ENTITY")
public class MyExample3250ElementCollectionDataEntity extends BaseEntity {

	@Column
	@Enumerated(EnumType.STRING)
	private MyExample3250ElementCollectionData value;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE_3250_ONE_TO_ONE_MANY_TO_MANY_ID")
	private MyExample3250OneToOneManyToMany myExample3250OneToOneManyToMany;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_MANY_ID")
	private MyExample3250OneToOneOneToMany myExample3250OneToOneOneToMany;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE_ID")
	private MyExample3250OneToOneOneToOne myExample3250OneToOneOneToOne;

}
