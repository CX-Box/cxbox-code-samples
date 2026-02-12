package org.demo.documentation.fields.datetimewithseconds.filtration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "DateTimeWithSecondsFiltrationEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsFiltrationEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}