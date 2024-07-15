package org.demo.documentation.fields.date.drilldown;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "dateDrillDownEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateDrillDownEntity extends BaseEntity {

	private LocalDateTime  customField;

}