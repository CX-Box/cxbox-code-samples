package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

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
public class MyEntity4902PickInline extends BaseEntity {
	@Column
	private String customField;

}
