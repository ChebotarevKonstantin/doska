package com.FreeDoska.doska.repo;

import com.FreeDoska.doska.AnnouncementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnouncementRepo extends JpaRepository<AnnouncementModel, Integer > {
//List<AnnouncementModel> findById(Long id);
}
