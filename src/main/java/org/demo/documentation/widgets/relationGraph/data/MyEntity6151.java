package org.demo.documentation.widgets.relationGraph.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

/**
 * A company of a sales network: the parent company it sells through and the sum of its sales.
 * All RelationGraph samples build the edges "parent company -> company" from this table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity6151 extends BaseEntity {

	@Column
	private String name;

	@Column
	private String city;

	@Column
	private Long parentId;

	@Column
	private Long sum;

}
