package org.alberto.lyricsaplication.VO;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LyricsVO {
    @Id
    @GeneratedValue
    private int id;
    private String artist;
    private String title;
    private String lyrics;
}
