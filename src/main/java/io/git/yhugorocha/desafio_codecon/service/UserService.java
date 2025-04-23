package io.git.yhugorocha.desafio_codecon.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.git.yhugorocha.desafio_codecon.dto.ImportResponse;
import io.git.yhugorocha.desafio_codecon.dto.TeamResponse;
import io.git.yhugorocha.desafio_codecon.dto.TopCountries;
import io.git.yhugorocha.desafio_codecon.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final ObjectMapper objectMapper;

    private List<UserEntity> users = new ArrayList<>();

    public UserService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ImportResponse importUsers(MultipartFile file) throws IOException {
        List<UserEntity> userList = objectMapper.readValue(
                file.getInputStream(),
                new TypeReference<List<UserEntity>>() {}
        );

        this.users.addAll(userList);

        return new ImportResponse("Arquivo recebido com sucesso", users.size());
    }

    public List<UserEntity> getSuperUsers(){
        return users.stream()
                .filter(user -> user.getScore() >= 900 && user.getAtivo().equals(true))
                .toList();
    }

    public List<TopCountries> getTopCountries(){
        return users.stream()
                .collect(Collectors.groupingBy(UserEntity::getPais, Collectors.counting()))
                .entrySet()
                .stream()
                .map(v -> new TopCountries(v.getKey(), v.getValue()))
                .sorted(Comparator.comparingLong(TopCountries::value).reversed())
                .limit(5)
                .toList();
    }

    public List<TeamResponse> getTeamInsights(){
        var top = users.stream()
                .collect(Collectors.groupingBy(user-> user.getEquipe().getNome(), Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        return top.stream().map(v -> new TeamResponse(v.getKey(),
                v.getValue(), this.qtdLeadersTeam(v.getKey()), this.qtdProjectsCompletedByTeam(v.getKey()),
                this.percentageActives(v.getKey()))).toList();
    }

    public Long qtdLeadersTeam(String name){
        return users.stream()
                .filter(user -> user.getEquipe().getNome().equals(name) && user.getEquipe().getLider().equals(true))
                .count();
    }

    public Long qtdProjectsCompletedByTeam(String name){
        return users.stream()
                .filter(user -> user.getEquipe().getNome().equals(name))
                .mapToLong(user -> user.getEquipe().getProjetos().stream()
                        .filter(project -> project.getConcluido().equals(true))
                        .count())
                .sum();
    }

    public Double percentageActives(String name){
        var activeUsers = users.stream()
                .filter(user -> user.getEquipe().getNome().equals(name) && user.getAtivo().equals(true))
                .count();

        var totalUsers = users.stream()
                .filter(user -> user.getEquipe().getNome().equals(name))
                .count();

        double percentage = (double) activeUsers / totalUsers * 100;
        return BigDecimal.valueOf(percentage)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
