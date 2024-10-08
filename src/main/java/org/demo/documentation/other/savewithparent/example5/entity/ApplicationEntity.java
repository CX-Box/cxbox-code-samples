package org.demo.documentation.other.savewithparent.example5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ApplicationEntity extends BaseEntity {

	@Column
	private String name;

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	@Column(name = "tasks_id")
	private List<Task> tasksId;

}
