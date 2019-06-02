package org.alberto.lyricsaplication.impl;

import org.alberto.lyricsaplication.DTO.LyricFilterCriteriaDTO;
import org.alberto.lyricsaplication.DTO.LyricsDTO;
import org.alberto.lyricsaplication.LyricsRepository;
import org.alberto.lyricsaplication.LyricsService;
import org.alberto.lyricsaplication.VO.LyricsVO;
import org.alberto.lyricsaplication.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LyricsServiceImpl implements LyricsService {

    private final String uri = "https://api.lyrics.ovh/v1/{artist}/{song}";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LyricsRepository lyricsRepository;

    private Converter converter;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public LyricsVO insert(LyricsVO lyrics) {
            return lyricsRepository.save(lyrics);
    }

    @Override
    public LyricsVO getLyrics(String artist, String song) {
        Map<String, String> params = new HashMap<>();
        params.put("artist", artist);
        params.put("song", song);
        return converter.convertDTOToEntity(restTemplate.getForObject(uri, LyricsDTO.class, params));
    }

    @Override
    public List<LyricsVO> selectAll(final LyricFilterCriteriaDTO params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LyricsVO> query = builder.createQuery(LyricsVO.class);
        Root r = query.from(LyricsVO.class);

        final String paramsArtist = params.getArtist();
        final String paramsTitle = params.getTitle();


        Predicate artist = builder.equal(r.get("artist"), paramsArtist);
        Predicate title =   builder.equal(r.get("title"), paramsTitle);

        List<Predicate> predicates = new ArrayList<>();

        if(paramsArtist!=null){
            predicates.add(builder.and(artist));
        }if(paramsTitle!=null){
            predicates.add(builder.and(title));
        }
        query.select(r).where(predicates.toArray(new Predicate[0]));
        TypedQuery<LyricsVO> q = entityManager.createQuery(query);
        List<LyricsVO> result = q.getResultList();

        return result;

    }

    @Override
    public void delete(int lyricsId) {
        lyricsRepository.deleteById(lyricsId);
    }
}
