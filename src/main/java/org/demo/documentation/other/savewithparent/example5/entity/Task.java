package org.demo.documentation.other.savewithparent.example5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example5.enums.ImportanceEnum;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task extends BaseEntity {

	@Column
	private String name;

	@ManyToOne
	private ApplicationEntity applicationEntityId;

	@Enumerated(value = EnumType.STRING)
	@Column
	private ImportanceEnum importance;

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;

	@Column
	private String comment;

	@JoinColumn(name = "executor_id")
	@ManyToOne
	private Executor executorId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
	private List<TaskDocument> documents;
}
