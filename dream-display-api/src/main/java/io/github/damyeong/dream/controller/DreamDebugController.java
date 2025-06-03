package io.github.damyeong.dream.controller;

import io.github.damyeong.dream.controller.dto.request.CreateChatReq;
import io.github.damyeong.dream.service.DreamDebugAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DreamDebugController {

    private final DreamDebugAppService dreamDebugAppService;

    @GetMapping("/v1/debug")
    public String debug() {
        return "Dream Debug API is working!";
    }

    @PostMapping("/v1/debug/chat-completion")
    public String getChatCompletion(@RequestBody CreateChatReq req) {
        return dreamDebugAppService.getChatCompletion(req);
    }
}
