package io.git.yhugorocha.desafio_codecon.dto;

import io.git.yhugorocha.desafio_codecon.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record TopCountriesResponse(LocalDateTime timestamp, Long executionTimeMs, List<TopCountries> countries) {
}
