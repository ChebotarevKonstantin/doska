package com.FreeDoska.doska.repo;

import com.FreeDoska.doska.AnnouncementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepo extends JpaRepository<AnnouncementModel, Long> {
//List<AnnouncementModel> findByTag(String tag);
}
