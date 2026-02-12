package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

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
public class MyEntity4903OCPPick extends BaseEntity {
	@Column
	private String customField;
}
