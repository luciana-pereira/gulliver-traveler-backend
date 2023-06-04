package com.gullivertravelerbackend.gullivertravelerbackend.controller;

import com.gullivertravelerbackend.gullivertravelerbackend.entity.Hosting;
import com.gullivertravelerbackend.gullivertravelerbackend.repository.HostingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hosting")
@Api(tags = "Hosting")
public class HostingController {
    private HostingRepository hostingRepository;

    public HostingController(HostingRepository hostingRepository) {
        this.hostingRepository = hostingRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ApiOperation("Criar uma nova hospedagem")
    public void createHosting(@RequestBody Hosting hosting) {
        hostingRepository.save(hosting);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ApiOperation("Pega todas as hospedagens cadastradas")
    public List<Hosting> getAllHosting() {
        return hostingRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ApiOperation("Pega hospedagens cadastradas por ID")
    public ResponseEntity<Hosting> getHostingById(@PathVariable int id) {
        Optional<Hosting> hosting = hostingRepository.findById(id);
        if (hosting.isPresent()) {
            return ResponseEntity.ok(hosting.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @ApiOperation("Atualiza a hospedagem cadastrada por ID")
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
    @ApiOperation("Deleta hospedagem cadastrada por ID")
    public void deleteHosting(@PathVariable int id) {
        hostingRepository.deleteById(id);
    }
}
