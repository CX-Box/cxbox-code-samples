package org.demo.documentation.fields.datetime.drilldown;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "DateTimeDrilldown")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeDrilldown extends BaseEntity {

	private LocalDateTime customField;

}