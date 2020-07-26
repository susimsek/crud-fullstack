package com.spring.jpa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TutorialDTO {

    private String title;

    private String description;

    private boolean published=false;

}
