package org.demo.documentation.fields.input.additionalproperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "MaxInputEntity")
@Getter
@Setter
@NoArgsConstructor
public class MaxInputEntity extends BaseEntity {


	@Column
	private String customField;

}