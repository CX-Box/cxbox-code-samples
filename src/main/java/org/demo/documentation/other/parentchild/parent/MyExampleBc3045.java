package org.demo.documentation.other.parentchild.parent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "MY_EXAMPLE_BC3045")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class MyExampleBc3045 extends BaseEntity {


	@Column
	private Long customField = 0L;

	@Column
	private String customFieldDrilldown;
}