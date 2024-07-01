package tr.ogu.edu.school.schoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.ogu.edu.school.schoolapp.model.Yemekhane;
import tr.ogu.edu.school.schoolapp.service.YemekhaneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/yemekhane")
public class YemekhaneController {

    @Autowired
    private YemekhaneService yemekhaneService;

    @GetMapping
    public List<Yemekhane> getAllYemekhaneEntries() {
        return yemekhaneService.getAllYemekhaneEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Yemekhane> getYemekhaneEntryById(@PathVariable Long id) {
        Optional<Yemekhane> yemekhane = yemekhaneService.getYemekhaneEntryById(id);
        return yemekhane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Yemekhane> createYemekhaneEntry(@RequestBody Yemekhane yemekhane) {
        Yemekhane createdYemekhane = yemekhaneService.createYemekhaneEntry(yemekhane);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdYemekhane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Yemekhane> updateYemekhaneEntry(
            @PathVariable Long id, @RequestBody Yemekhane yemekhaneDetails) {
        Yemekhane updatedYemekhane = yemekhaneService.updateYemekhaneEntry(id, yemekhaneDetails);
        return ResponseEntity.ok(updatedYemekhane);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYemekhaneEntry(@PathVariable Long id) {
        yemekhaneService.deleteYemekhaneEntry(id);
        return ResponseEntity.noContent().build();
    }
}
