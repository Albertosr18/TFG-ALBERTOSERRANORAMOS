package org.alberto.lyricsaplication.util;

import org.alberto.lyricsaplication.DTO.LyricsDTO;
import org.alberto.lyricsaplication.VO.LyricsVO;
import org.springframework.beans.factory.annotation.Autowired;

public class Converter {

   public LyricsDTO convertEntityToDTO(LyricsVO lyricsVO) {
        return LyricsDTO.builder()
                .lyrics(lyricsVO.getLyrics())
             .build();
    }

   public LyricsVO convertDTOToEntity(LyricsDTO lyricsDTO) {

        return LyricsVO.builder().
                lyrics(lyricsDTO.getLyrics()).build();
    }
}
