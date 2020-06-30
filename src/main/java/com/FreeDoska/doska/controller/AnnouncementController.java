package com.FreeDoska.doska.controller;

import com.FreeDoska.doska.Announcement;
import com.FreeDoska.doska.repository.AnnouncementRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("announcements")
public class AnnouncementController {
    private final AnnouncementRepo announcementRepo;

    @Autowired
    public AnnouncementController(AnnouncementRepo announcementRepo) {
        this.announcementRepo = announcementRepo;
    }

    @GetMapping
//    @JsonView(Views.IdName.class)
    public List<Announcement> list() {
        return announcementRepo.findAll();
    }


    @GetMapping("{id}")
//    @JsonView(Views.FullMessage.class)
//    public Announcement getOne(@PathVariable("id") Announcement announcement) {
//        return announcement;
//    }
    public Announcement getOne(@PathVariable("id") String id) {
        Announcement announcement = this.announcementRepo.findById(Integer.parseInt(id)).get();
        return announcement;
    }



    @PostMapping
    public Announcement create(@RequestBody Announcement announcement) {
        announcement.setCreationDate(LocalDateTime.now());
        return announcementRepo.save(announcement);
    }

    @PutMapping("{id}")
    public Announcement update(
            @PathVariable("id") Announcement announcementFromDb,
            @RequestBody Announcement announcement
    ) {
        BeanUtils.copyProperties(announcement, announcementFromDb, "id");
        return announcementRepo.save(announcementFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Announcement announcement) {
        announcementRepo.delete(announcement);

    }
//    @RequestMapping(value = "/products")
//    public String getProductName() {
//        return "Honey";
//
//    }
}


//    private int counter = 4;
//    private List<Map<String, String>> announcements = new ArrayList<Map<String, String>>() {{
//        add(new HashMap<String, String>() {{
//            put("id", "1");
//            put("nameAnnouncement", "name announcement1");
//
//        }});
//        add(new HashMap<String, String>() {{
//            put("id", "2");
//            put("nameAnnouncement", "name announcement2");
//
//        }});
//        add(new HashMap<String, String>() {{
//            put("id", "3");
//            put("nameAnnouncement", "name announcement3");
//
//        }});
//
//    }};
//
//
//    @GetMapping
//    public List<Map<String, String>> list() {
//        return announcements;
//    }
//
//    @GetMapping("{id}")
//    public Map<String, String> getOne(@PathVariable String id) {
//        return getAnnouncement(id);
//    }
//
//    private Map<String, String> getAnnouncement(@PathVariable String id) {
//        return announcements.stream()
//                .filter(announcements -> announcements.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
//
//    @PostMapping
//    public Map<String, String> create(@RequestBody Map<String, String> announcement){
//        announcement.put("id", String.valueOf(counter++));
//        announcements.add(announcement);
//return announcement;
//    }
//    @PutMapping("{id}")
//    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> announcement){
//        Map<String, String> announcementFromDB = getAnnouncement(id);
//        announcementFromDB.putAll(announcement);
//        announcementFromDB.put("id", id);
//        return announcementFromDB;
//    }
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id){
//        Map<String, String> announcement = getAnnouncement(id);
//        announcement.remove(announcement);
//
//    }
//}
