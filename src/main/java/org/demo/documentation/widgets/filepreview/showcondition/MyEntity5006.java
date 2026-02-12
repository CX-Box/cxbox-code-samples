package org.demo.documentation.widgets.filepreview.showcondition;

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
public class MyEntity5006 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldId;
}
