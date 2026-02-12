package org.demo.documentation.other.equalsOfOne;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneManyToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToMany;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOneOneToOne;

@Getter
@Setter
@Entity
@Table(name = "MY_EXAMPLE3250_LINK_MULTIVALUE")
@SuperBuilder
@NoArgsConstructor
public class MyExample3250LinkMultivalue extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_MULTIVALUE_ID")
	private MyExample3250Multivalue myExample3250Multivalue;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_MANY_TO_MANY_ID")
	private MyExample3250OneToOneManyToMany myExample3250OneToOneManyToMany;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_MANY_ID")
	private MyExample3250OneToOneOneToMany myExample3250OneToOneOneToMany;

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ONE_TO_ONE_ID")
	private MyExample3250OneToOneOneToOne myExample3250OneToOneOneToOne;

}
