package com.FreeDoska.doska.repository;

import com.FreeDoska.doska.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepo extends JpaRepository<Announcement, Integer > {
//    List<Announcement> findById(Long id);
//    public interface AnnouncementRepo extends CrudRepository<Announcement, Integer > {
//        Optional<Announcement> findById(Integer id);

}
