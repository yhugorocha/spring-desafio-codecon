package io.git.yhugorocha.desafio_codecon.dto;

public record TeamResponse(String team,
                           Long totalMembers,
                           Long leaders,
                           Long completedProjects,
                           Double percentageActive) {
}
