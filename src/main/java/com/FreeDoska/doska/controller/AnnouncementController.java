package com.FreeDoska.doska.controller;
import com.FreeDoska.doska.controller.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("announcement")
public class AnnouncementController {
        private int counter = 4;
    private List<Map<String, String>> announcements = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("text", "First announcement");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("text", "Second announcement");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("text", "Third announcement");
        }});

    }};


    @GetMapping
    public List<Map<String, String>> list() {
        return announcements;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getAnnouncement(id);
    }

    private Map<String, String> getAnnouncement(@PathVariable String id) {
        return announcements.stream()
                .filter(announcements -> announcements.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> announcement){
        announcement.put("id", String.valueOf(counter++));
        announcements.add(announcement);
return announcement;
    }
    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> announcement){
        Map<String, String> announcementFromDB = getAnnouncement(id);
        announcementFromDB.putAll(announcement);
        announcementFromDB.put("id", id);
        return announcementFromDB;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> announcement = getAnnouncement(id);
        announcement.remove(announcement);

    }
}
