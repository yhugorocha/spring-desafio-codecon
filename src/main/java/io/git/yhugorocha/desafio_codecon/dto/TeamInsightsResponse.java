package io.git.yhugorocha.desafio_codecon.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TeamInsightsResponse(LocalDateTime timestamp, Long executionTimeMs, List<TeamResponse> teams) {
}
