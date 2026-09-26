package org.demo.documentation.widgets.cardcarousellist.status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.demo.documentation.widgets.cardcarousellist.status.enums.StatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5065 extends BaseEntity {

	@Column
	private String document;

	@Column
	private String documentId;

	@Column
	private String customField;

	@Column
	private String customFieldDescription;

	@Enumerated(EnumType.STRING)
	@Column
	private StatusEnum status;

}
