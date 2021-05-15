package com.codeforgeyt.onetomanywebservice.controller;

import com.codeforgeyt.onetomanywebservice.model.Like;
import com.codeforgeyt.onetomanywebservice.model.dto.LikeDto;
import com.codeforgeyt.onetomanywebservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> addLike(@RequestBody final LikeDto likeDto){
        Like like = likeService.addLike(Like.from(likeDto));
        return new ResponseEntity<>(LikeDto.from(like), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LikeDto>> getLikes(){
        List<Like> likes = likeService.getLikes();
        List<LikeDto> likesDto = likes.stream().map(LikeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(likesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<LikeDto> getLike(@PathVariable final Long id){
        Like like = likeService.getLike(id);
        return new ResponseEntity<>(LikeDto.from(like), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<LikeDto> deleteLike(@PathVariable final Long id){
        Like like = likeService.deleteLike(id);
        return new ResponseEntity<>(LikeDto.from(like), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<LikeDto> editLike(@PathVariable final Long id,
                                                        @RequestBody final LikeDto likeDto){
        Like editedLike = likeService.editLike(id, Like.from(likeDto));
        return new ResponseEntity<>(LikeDto.from(editedLike), HttpStatus.OK);
    }
}
