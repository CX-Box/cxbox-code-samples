package org.demo.documentation.date.validationconfirm;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
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