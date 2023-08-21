package org.demo.conf.cxbox.resp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.CoreDictionaries;
import org.cxbox.core.config.cache.CacheConfig;
import org.cxbox.model.core.dao.JpaDao;
import org.cxbox.model.ui.navigation.NavigationView;
import org.cxbox.model.ui.navigation.NavigationView_;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdditionalCache {

	private final JpaDao jpaDao;

	@Cacheable(cacheResolver = CacheConfig.CXBOX_CACHE_RESOLVER, cacheNames = {
			CacheConfig.UI_CACHE}, key = "{#root.methodName}")
	public Map<String, Set<String>> getAllScreenViewsReferencedInNavigation() {
		return jpaDao.getList(NavigationView.class, (root, query, cb) -> cb.and(
						cb.equal(
								root.get(NavigationView_.typeCd),
								CoreDictionaries.ViewGroupType.NAVIGATION
						))).stream()
				.collect(groupingBy(NavigationView::getScreenName, mapping(NavigationView::getViewName, Collectors.toSet())));
	}


}
