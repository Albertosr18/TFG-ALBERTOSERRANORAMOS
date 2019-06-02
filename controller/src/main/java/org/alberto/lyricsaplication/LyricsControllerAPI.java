package org.alberto.lyricsaplication;

import org.alberto.lyricsaplication.DTO.LyricFilterCriteriaDTO;
import org.alberto.lyricsaplication.DTO.LyricsDTO;
import org.alberto.lyricsaplication.VO.LyricsVO;
import org.alberto.lyricsaplication.constant.EndPointUris;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping(EndPointUris.LYRICS)
public interface LyricsControllerAPI {

    @GetMapping(EndPointUris.SONG)
    ResponseEntity<LyricsVO> selectLyrics(@PathVariable(value="artist") String artist, @PathVariable(value="song") String song);

    @PostMapping
    ResponseEntity<LyricsVO> insert(@RequestBody final LyricsVO lyric);

    @DeleteMapping(EndPointUris.ID)
    ResponseEntity<LyricsVO> delete(@PathVariable(value="id") int id);

    @GetMapping
    ResponseEntity<List<LyricsVO>> findAll(final LyricFilterCriteriaDTO search);


}
