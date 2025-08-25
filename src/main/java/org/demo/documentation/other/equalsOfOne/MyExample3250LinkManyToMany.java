package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOne;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "MY_EXAMPLE3250LINK_MANY_TO_MANY")
@SuperBuilder
@NoArgsConstructor
public class MyExample3250LinkManyToMany extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ID")
	private MyExample3250OneToOne myExample3250OneToOne;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_MANY_TO_MANY_ID")
	private MyExample3250OneToOneManyToMany myExample3250OneToOneManyToMany;

}
