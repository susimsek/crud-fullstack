package com.spring.jpa.service;

import com.spring.jpa.dto.TutorialDTO;
import com.spring.jpa.model.Tutorial;
import com.spring.jpa.repository.TutorialRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    @NonNull TutorialRepository tutorialRepository;

    @NonNull ModelMapper modelMapper;

    @Override
    public List<Tutorial> getAllTutorials(String title) {
        if(title==null){
            return tutorialRepository.findAll();
        }
        else {
            return tutorialRepository.findByTitleContainingIgnoreCase(title);
        }
    }

    @Override
    public Tutorial getTutorialById(long id) {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"This tutorial not found"));
        return tutorial;
    }

    @Override
    public Tutorial createTutorial(TutorialDTO tutorialDTO) {
        Tutorial tutorial=modelMapper.map(tutorialDTO,Tutorial.class);
        tutorial.setPublished(false);
        Tutorial _tutorial=tutorialRepository.save(tutorial);
        return _tutorial;
    }

    @Override
    public Tutorial updateTutorial(long id, TutorialDTO tutorialDTO) {

        Tutorial _tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"This tutorial not found"));


        _tutorial.setTitle(tutorialDTO.getTitle());
        _tutorial.setDescription(tutorialDTO.getDescription());
        _tutorial.setPublished(tutorialDTO.isPublished());

        tutorialRepository.save(_tutorial);
        return _tutorial;
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);

    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished() {
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
        return tutorials;
    }
}
