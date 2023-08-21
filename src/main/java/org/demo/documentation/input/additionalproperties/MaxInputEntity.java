package org.demo.documentation.input.additionalproperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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