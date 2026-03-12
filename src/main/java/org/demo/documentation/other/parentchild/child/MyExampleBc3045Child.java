package org.demo.documentation.other.parentchild.child;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.parentchild.parent.MyExampleBc3045;


@Entity
@Table(name = "MY_EXAMPLE_BC3045_CHILD")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class MyExampleBc3045Child extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "MY_EXAMPLE_BC3045_ID")
	private MyExampleBc3045 myExampleBc3045;

	@Column
	private String customField;
}