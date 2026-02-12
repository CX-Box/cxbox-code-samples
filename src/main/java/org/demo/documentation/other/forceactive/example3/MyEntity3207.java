package org.demo.documentation.other.forceactive.example3;

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
public class MyEntity3207 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private Boolean customFieldCheckBox;
}