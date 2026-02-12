package org.demo.documentation.other.equalsOfOne.onetoone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MY_EXAMPLE3250_ONE_TO_ONE")
@SuperBuilder
@NoArgsConstructor
public class MyExample3250OneToOne extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE_ID")
	public MyExample3250OneToOneOneToOne myExample3250OneToOneOneToOne;

	@OneToMany(mappedBy = "myExample3250OneToOne")
	private Set<MyExample3250OneToOneOneToMany> myExample3250OneToOneOneToManies = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "MY_EXAMPLE3250LINK_MANY_TO_MANY",
			joinColumns = @JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_MANY_TO_MANY_ID")
	)
	private Set<MyExample3250OneToOneManyToMany> myExample3250OneToOneManyToMany = new HashSet<>();

}
