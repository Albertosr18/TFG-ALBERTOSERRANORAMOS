package org.alberto.lyricsaplication;

import org.alberto.lyricsaplication.VO.LyricsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricsRepository extends JpaRepository<LyricsVO, Integer> {

}
