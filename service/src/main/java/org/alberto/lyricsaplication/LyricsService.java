package org.alberto.lyricsaplication;

import org.alberto.lyricsaplication.DTO.LyricFilterCriteriaDTO;
import org.alberto.lyricsaplication.DTO.LyricsDTO;
import org.alberto.lyricsaplication.VO.LyricsVO;

import java.util.List;

public interface LyricsService {
    LyricsVO insert(LyricsVO lyrics);

    LyricsVO getLyrics(String artist, String song);

    List<LyricsVO> selectAll(final LyricFilterCriteriaDTO params);

    void delete(int lyricsId);
}
