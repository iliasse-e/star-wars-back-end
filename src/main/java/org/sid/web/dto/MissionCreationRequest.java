package org.sid.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Data
public class MissionCreationRequest {
    @NotBlank
    private String name;

    @NotEmpty
    private List<Long> pilotesId;

    // constructeur, getters et setters
}
