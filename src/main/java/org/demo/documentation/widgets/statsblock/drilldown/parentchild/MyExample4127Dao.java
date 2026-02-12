package org.demo.documentation.widgets.statsblock.drilldown.parentchild;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.MyEntity4216Repository;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyExample4127Dao extends AbstractAnySourceBaseDAO<MyExample4127DTO> {

	public static final String ALL = "1";
	public static final String NOT_STARTED = "2";
	public static final String IN_COMPLETION = "3";
	public static final String IN_PROGRESS = "4";
	public static final String COMPLETED = "5";
	public static final String CANCELLED = "6";
	private final MyEntity4216Repository repository;

	@Override
	public String getId(final MyExample4127DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4127DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4127DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getMeetingStatistics().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4127DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getMeetingStatistics());
	}

	@Override
	public MyExample4127DTO update(BusinessComponent bc, MyExample4127DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4127DTO create(final BusinessComponent bc, final MyExample4127DTO entity) {
		throw new IllegalStateException();
	}

	public List<MyExample4127DTO> getMeetingStatistics() {
		long allCount = repository.count();
		long notStartedCount = countByStatus(ExampleStatus.NOT_STARTED);
		long inCompletionCount = countByStatus(ExampleStatus.IN_COMPLETION);
		long inProgressCount = countByStatus(ExampleStatus.IN_PROGRESS);
		long completedCount = countByStatus(ExampleStatus.COMPLETED);
		long cancelledCount = countByStatus(ExampleStatus.CANCELLED);

		return createMyExample4127List(
				allCount, notStartedCount, inCompletionCount,
				inProgressCount, completedCount, cancelledCount
		);
	}

	private long countByStatus(ExampleStatus status) {
		return repository.findByStatus(status).size();
	}

	private List<MyExample4127DTO> createMyExample4127List(
			long allCount, long notStartedCount, long inCompletionCount,
			long inProgressCount, long completedCount, long cancelledCount) {

		return List.of(
						createMyExample4127DTO("All", allCount, "#779FE9", "team", ALL, "All meetings"),
						createMyExample4127DTO(
								"Not Started",
								notStartedCount,
								"#5F90EA",
								"calendar",
								NOT_STARTED,
								"Not started"
						),
						createMyExample4127DTO(
								"In Completion",
								inCompletionCount,
								"#4D83E7",
								"pie-chart",
								IN_COMPLETION,
								"In completion"
						),
						createMyExample4127DTO("In Progress", inProgressCount, "#3A76E4", "plus-circle", IN_PROGRESS, "In progress"),
						createMyExample4127DTO("Completed", completedCount, "#2769E1", "check", COMPLETED, "Completed"),
						createMyExample4127DTO("Cancelled", cancelledCount, "#145CDE", "stop", CANCELLED, "Cancelled")
				).stream()
				.filter(dto -> dto.getValue() > 0)
				.collect(Collectors.toList());
	}

	private MyExample4127DTO createMyExample4127DTO(String title, long value, String color,
													String icon, String id, String description) {
		MyExample4127DTO meetingStatsDTO = new MyExample4127DTO();
		meetingStatsDTO
				.setTitle(title)
				.setValue(value)
				.setColor(color)
				.setIcon(icon)
				.setDescription(description)
				.setId(id);
		return meetingStatsDTO;
	}

}