package com.spring.jpa.service;

import com.spring.jpa.dto.TutorialDTO;
import com.spring.jpa.model.Tutorial;

import java.util.List;

public interface TutorialService {

    List<Tutorial> getAllTutorials(String title);
    Tutorial getTutorialById(long id);
    Tutorial createTutorial(TutorialDTO tutorialDTO);
    Tutorial updateTutorial(long id,TutorialDTO tutorialDTO);
    void deleteTutorial(long id);
    void deleteAllTutorials();
    List<Tutorial> findByPublished();
}
