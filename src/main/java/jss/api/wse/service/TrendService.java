package jss.api.wse.service;

import jss.api.wse.model.Trend;
import jss.api.wse.repository.TrendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TrendService {

    private final TrendRepository trendRepository;

    public Mono<Trend> create(Trend trend) {
        return Mono.just(Optional.of(trendRepository.save(trend)).orElseThrow(RuntimeException::new));
    }
}
