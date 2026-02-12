package org.demo.documentation.fields.date.validationconfirm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DateConfirmEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateConfirmEntity extends BaseEntity {

	private LocalDateTime customField;

}