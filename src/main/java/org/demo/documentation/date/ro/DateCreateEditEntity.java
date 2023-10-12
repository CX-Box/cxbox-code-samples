package org.demo.documentation.date.ro;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "DateCreateEditEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateCreateEditEntity extends BaseEntity {

	private LocalDateTime  customField;

}