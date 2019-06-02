package org.alberto.lyricsaplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor

public class LyricFilterCriteriaDTO {
    private String artist;
    private String title;
}
