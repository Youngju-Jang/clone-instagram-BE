package com.hanghae.cloneinstagram.rest.post.controller;

import com.hanghae.cloneinstagram.config.dto.PrivateResponseBody;
import com.hanghae.cloneinstagram.config.errorcode.CommonStatusCode;
import com.hanghae.cloneinstagram.config.security.UserDetailsImpl;
import com.hanghae.cloneinstagram.rest.post.dto.PostRequestDto;
import com.hanghae.cloneinstagram.rest.post.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "게시글 작성 및 파일 업로드")
    @PostMapping("/posts")
    public ResponseEntity<PrivateResponseBody> savePost(@ModelAttribute PostRequestDto postRequestDto) throws IOException {

        return ResponseEntity.ok(new PrivateResponseBody(CommonStatusCode.CREATE_POST,postService.savePost(postRequestDto)));
    }


}
