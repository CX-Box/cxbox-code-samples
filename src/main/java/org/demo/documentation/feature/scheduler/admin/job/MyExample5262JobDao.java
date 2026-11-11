package org.demo.documentation.feature.scheduler.admin.job;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.scheduler.admin.MyExample5262JobState;
import org.jobrunr.jobs.Job;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.navigation.OffsetBasedPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample5262JobDao extends AbstractAnySourceBaseDAO<MyExample5262JobDTO> implements
		AnySourceBaseDAO<MyExample5262JobDTO> {

	private static final int LIMIT = 50;

	private final StorageProvider storageProvider;

	@Override
	public String getId(final MyExample5262JobDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample5262JobDTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample5262JobDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return map(storageProvider.getJobById(UUID.fromString(bc.getId())));
	}

	// --8<-- [start:getList]
	@Override
	public Page<MyExample5262JobDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		MyExample5262JobState state = MyExample5262JobState.getById(bc.getParentId());
		if (state == null) {
			return new PageImpl<>(List.of());
		}
		List<MyExample5262JobDTO> jobs = storageProvider.getJobs(
						state.getStateName(),
						new OffsetBasedPageRequest(null, OffsetBasedPageRequest.DEFAULT_OFFSET, LIMIT)
				).getItems()
				.stream()
				.<MyExample5262JobDTO>map(this::map)
				.toList();
		return new PageImpl<>(jobs);
	}
	// --8<-- [end:getList]

	// --8<-- [start:actions]
	public void requeue(UUID id) {
		Job job = storageProvider.getJobById(id);
		job.enqueue();
		storageProvider.save(job);
	}

	public void deleteJob(UUID id) {
		Job job = storageProvider.getJobById(id);
		job.delete("Job deleted by administrator");
		storageProvider.save(job);
	}
	// --8<-- [end:actions]

	private MyExample5262JobDTO map(Job job) {
		ZoneId zone = ZoneId.systemDefault();
		return MyExample5262JobDTO.builder()
				.id(job.getId().toString())
				.jobName(job.getJobName())
				.state(job.getState().name())
				.createdAt(LocalDateTime.ofInstant(job.getCreatedAt(), zone))
				.updatedAt(LocalDateTime.ofInstant(job.getUpdatedAt(), zone))
				.recurringJobId(job.getRecurringJobId().orElse(null))
				.jobSignature(job.getJobSignature())
				.build();
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample5262JobDTO update(BusinessComponent bc, MyExample5262JobDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample5262JobDTO create(final BusinessComponent bc, final MyExample5262JobDTO entity) {
		throw new IllegalStateException();
	}

}
