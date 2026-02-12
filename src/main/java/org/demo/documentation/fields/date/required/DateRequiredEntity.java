package org.demo.documentation.fields.date.required;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DateRequiredEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateRequiredEntity extends BaseEntity {

	private LocalDateTime customField;

}