package kr.ac.kumoh.s20220625.w26w11_thymeleaf_java.controller;

import kr.ac.kumoh.s20220625.w26w11_thymeleaf_java.model.Song;
import kr.ac.kumoh.s20220625.w26w11_thymeleaf_java.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SongController {
    private final SongService service;

    @GetMapping("/songs/random")
    String getRandomSong(Model model) {
        model.addAttribute(
                "songTitle",
                service.getRandomSong()
                        .map(Song::title)
                        .orElse("노래 없음")
        );
        return "random";
    }
}
