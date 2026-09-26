package org.demo.documentation.widgets.cardlist.drilldown;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5306 extends BaseEntity {

	@Column
	private String document;

	@Column
	private String documentId;

	@Column
	private String customField;

	@Column
	private String customFieldDescription;

}
