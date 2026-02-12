package org.demo.documentation.fields.suggestion.sorting.forfield;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3122
// 
// 

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3122 extends BaseEntity {
	@Column
	private String customField;
}