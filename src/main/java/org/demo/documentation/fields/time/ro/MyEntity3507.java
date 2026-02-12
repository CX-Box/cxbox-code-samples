package org.demo.documentation.fields.time.ro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

// 3507
// 6009
//  Time readonly",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3507 extends BaseEntity {

	@Column
	private LocalDateTime customField;
}