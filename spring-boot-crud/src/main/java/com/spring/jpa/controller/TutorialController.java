package com.spring.jpa.controller;


import com.spring.jpa.dto.TutorialDTO;
import com.spring.jpa.model.Tutorial;
import com.spring.jpa.service.TutorialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="/versions/1/tutorials",produces ="application/json")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
@RequestMapping("/versions/1/tutorials")
public class TutorialController {

    @NonNull TutorialService tutorialService;

    @ApiOperation(value = "Get List of Tutorials",response = Iterable.class )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
        List<Tutorial> tutorials=tutorialService.getAllTutorials(title);
        return tutorials;
    }

    @ApiOperation(value = "Retrieve a Tutorial by id",response = Tutorial.class )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tutorial getTutorialById(@PathVariable("id") long id) {
        return tutorialService.getTutorialById(id);

    }

    @ApiOperation(value = "Create new Tutorial",response = Tutorial.class )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutorial createTutorial(@RequestBody TutorialDTO tutorialDTO) {
        return tutorialService.createTutorial(tutorialDTO);
    }

    @ApiOperation(value = "Update a Tutorial by id",response = Tutorial.class )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tutorial updateTutorial(@PathVariable("id") long id, @RequestBody TutorialDTO tutorialDTO) {
        return tutorialService.updateTutorial(id,tutorialDTO);

    }

    @ApiOperation(value = "Delete a Tutorial by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTutorial(@PathVariable("id") long id) {
        tutorialService.deleteTutorial(id);

    }

    @ApiOperation(value = "Delete all Tutorials")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
    }

    @ApiOperation(value = "Find all published Tutorials",response = Iterable.class )
    @GetMapping("/published")
    @ResponseStatus(HttpStatus.OK)
    public List<Tutorial> findByPublished() {
        List<Tutorial> tutorials=tutorialService.findByPublished();
        return tutorials;
    }


}
