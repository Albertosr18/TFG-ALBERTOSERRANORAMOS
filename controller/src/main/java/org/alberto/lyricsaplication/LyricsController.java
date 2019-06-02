package org.alberto.lyricsaplication;

import org.alberto.lyricsaplication.DTO.LyricFilterCriteriaDTO;
import org.alberto.lyricsaplication.DTO.LyricsDTO;
import org.alberto.lyricsaplication.VO.LyricsVO;
import org.alberto.lyricsaplication.impl.LyricsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LyricsController implements LyricsControllerAPI{
    @Autowired
    private LyricsService lyricsService;

    @Override
    public ResponseEntity<LyricsVO> selectLyrics(String artist, String song) {
        return ResponseEntity.ok(lyricsService.getLyrics(artist, song));
    }

    @Override
    public ResponseEntity<LyricsVO> insert(LyricsVO lyric) {
        return ResponseEntity.ok(lyricsService.insert(lyric));
    }

    @Override
    public ResponseEntity<LyricsVO> delete(int id) {
        lyricsService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<List<LyricsVO>> findAll(final LyricFilterCriteriaDTO search) {

        return ResponseEntity.ok(lyricsService.selectAll(search));
    }

}
