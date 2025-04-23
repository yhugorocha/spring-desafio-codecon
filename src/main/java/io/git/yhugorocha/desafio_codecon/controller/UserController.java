package io.git.yhugorocha.desafio_codecon.controller;

import io.git.yhugorocha.desafio_codecon.dto.ImportResponse;
import io.git.yhugorocha.desafio_codecon.dto.SuperUserResponse;
import io.git.yhugorocha.desafio_codecon.dto.TeamInsightsResponse;
import io.git.yhugorocha.desafio_codecon.dto.TopCountriesResponse;
import io.git.yhugorocha.desafio_codecon.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@RequestMapping(value="/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ImportResponse> importUsers(@RequestParam("file") MultipartFile file) throws IOException {

        return ResponseEntity.ok(userService.importUsers(file));
    }

    @GetMapping("/superusers")
    public ResponseEntity<SuperUserResponse> getSuperUsers(){
        long start  = System.currentTimeMillis();
        var superUsers = userService.getSuperUsers();
        long elapsed = System.currentTimeMillis() - start;
        return ResponseEntity.ok(new SuperUserResponse(LocalDateTime.now(), elapsed, superUsers));
    }

    @GetMapping("/top-countries")
    public ResponseEntity<TopCountriesResponse> getTopCountries(){
        long start  = System.currentTimeMillis();
        var top = userService.getTopCountries();
        long elapsed = System.currentTimeMillis() - start;
        return ResponseEntity.ok(new TopCountriesResponse(LocalDateTime.now(), elapsed, top));
    }

    @GetMapping("/team-insights")
    public ResponseEntity<TeamInsightsResponse> getTeamInsights(){
        long start  = System.currentTimeMillis();
        var teamInsights = userService.getTeamInsights();
        long elapsed = System.currentTimeMillis() - start;
        var result = new TeamInsightsResponse(LocalDateTime.now(), elapsed, teamInsights);
        return ResponseEntity.ok(result);
    }
}
