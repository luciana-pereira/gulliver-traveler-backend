package com.gullivertravelerbackend.gullivertravelerbackend.controller;

import com.gullivertravelerbackend.gullivertravelerbackend.entity.Hosting;
import com.gullivertravelerbackend.gullivertravelerbackend.repository.HostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hosting")
public class HostingController {
    @Autowired
    private HostingRepository hostingRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createHosting(@RequestBody Hosting hosting) {
        hostingRepository.save(hosting);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Hosting> getAllHosting() {
        List<Hosting> hostings = hostingRepository.findAll();
        return hostings;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Hosting> getHostingById(@PathVariable int id) {
        Optional<Hosting> hosting = hostingRepository.findById(id);
        if(hosting.isPresent()) {
            return ResponseEntity.ok(hosting.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Hosting> updateHosting(@PathVariable int id, @RequestBody Hosting hosting) {
        Optional<Hosting> existingHosting = hostingRepository.findById(id);
        if (existingHosting.isPresent()) {
            hosting.setId(id);
            return ResponseEntity.ok(hostingRepository.save(hosting));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteHosting(@PathVariable int id) {
        hostingRepository.deleteById(id);
    }
}
