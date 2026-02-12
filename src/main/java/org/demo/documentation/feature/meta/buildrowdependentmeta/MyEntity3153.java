package org.demo.documentation.feature.meta.buildrowdependentmeta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3153
// 3153
// 3153

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3153 extends BaseEntity {
	@Column
	private String customField;
}