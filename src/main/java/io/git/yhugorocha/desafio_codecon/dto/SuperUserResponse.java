package io.git.yhugorocha.desafio_codecon.dto;

import io.git.yhugorocha.desafio_codecon.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public record SuperUserResponse(LocalDateTime timestamp, Long executionTimeMs, List<UserEntity> data) {
}
