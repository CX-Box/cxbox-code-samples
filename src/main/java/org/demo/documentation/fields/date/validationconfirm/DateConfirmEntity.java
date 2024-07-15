package org.demo.documentation.fields.date.validationconfirm;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateConfirmEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateConfirmEntity extends BaseEntity {

	private LocalDateTime  customField;

}