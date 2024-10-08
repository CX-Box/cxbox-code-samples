package org.demo.conf.cxbox.extention.notification;

import org.demo.conf.cxbox.meta.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	@Modifying
	@Query("UPDATE Notification n SET n.isRead = true WHERE n.id IN :ids")
	void markAsRead(@Param("ids") List<Long> ids);

	Page<Notification> findAllByUser(User user, Pageable pageable);

	Long countByUser(User user);

	Long countByUserAndIsRead(User user, Boolean isRead);

}
