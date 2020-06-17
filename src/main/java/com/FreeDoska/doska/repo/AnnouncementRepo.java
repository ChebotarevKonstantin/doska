package com.FreeDoska.doska.repo;
import com.FreeDoska.doska.AnnouncementModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepo extends JpaRepository<AnnouncementModel, Integer> {
}
