package com.codecool.springbootdrinks.RestController;

import com.codecool.springbootdrinks.Model.Liquor;
import com.codecool.springbootdrinks.Service.LiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LiquorRestController {
    @Autowired
    LiquorService liquorService;

    @GetMapping("/liquors")
    public List<Liquor> getLiquors() {
        return liquorService.getAllLiquors();
    }

    @GetMapping("/liquors/{liquorId}")
    public Liquor getLiquor(@PathVariable Long liquorId) {
        return liquorService.getLiquorById(liquorId);
    }

    @PostMapping("/liquors")
    public Liquor createLiquor(@Valid @RequestBody Liquor liquor) {
        return liquorService.createLiquor(liquor);
    }
    @DeleteMapping("/liquors/{liquorId}")
    public Liquor deleteLiquor(@PathVariable Long liquorId) {
        return liquorService.deleteLiquor(liquorId);
    }

    @PutMapping("/liquors/{liquorId}")
    public Liquor updateLiquor(@PathVariable Long liquorId,
                               @Valid @RequestBody Liquor liquorRequest) {
        return liquorService.updateLiquor(liquorId, liquorRequest);
    }
}
