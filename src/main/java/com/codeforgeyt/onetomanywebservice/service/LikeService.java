package com.codeforgeyt.onetomanywebservice.service;

import com.codeforgeyt.onetomanywebservice.model.Like;
import com.codeforgeyt.onetomanywebservice.model.exception.LikeNotFoundException;
import com.codeforgeyt.onetomanywebservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Like addLike(Like like){
        return likeRepository.save(like);
    }

    public List<Like> getLikes(){
        return StreamSupport
                .stream(likeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Like getLike(Long id){
        return likeRepository.findById(id).orElseThrow(() ->
                new LikeNotFoundException(id));
    }

    public Like deleteLike(Long id){
        Like like = getLike(id);
        likeRepository.delete(like);
        return like;
    }

    @Transactional
    public Like editLike(Long id, Like like){
        Like likeToEdit = getLike(id);
        likeToEdit.setLike(like.getLike());
        return likeToEdit;
    }
}
