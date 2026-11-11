package org.demo.documentation.feature.scheduler.admin.stats;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.scheduler.admin.MyExample5262JobState;
import org.jobrunr.storage.StorageProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample5262JobStatsDao extends AbstractAnySourceBaseDAO<MyExample5262JobStatsDTO> implements
		AnySourceBaseDAO<MyExample5262JobStatsDTO> {

	private final StorageProvider storageProvider;

	@Override
	public String getId(final MyExample5262JobStatsDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample5262JobStatsDTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample5262JobStatsDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public Page<MyExample5262JobStatsDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	// --8<-- [start:getStats]
	private List<MyExample5262JobStatsDTO> getStats() {
		return Arrays.stream(MyExample5262JobState.values())
				.<MyExample5262JobStatsDTO>map(state -> MyExample5262JobStatsDTO.builder()
						.id(state.name())
						.title(state.getTitle())
						.value(storageProvider.countJobs(state.getStateName()))
						.color("#779FE9")
						.description(state.getTitle())
						.icon(state.getIcon())
						.build())
				.toList();
	}
	// --8<-- [end:getStats]

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample5262JobStatsDTO update(BusinessComponent bc, MyExample5262JobStatsDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample5262JobStatsDTO create(final BusinessComponent bc, final MyExample5262JobStatsDTO entity) {
		throw new IllegalStateException();
	}

}
