package jss.api.wse.controller;

import jss.api.wse.model.Trend;
import jss.api.wse.service.TrendService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("trends")
public class TrendController {

    private final TrendService trendService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Trend> createTrend(@RequestBody Mono<Trend> trend) {
        return trend.flatMap(trendService::create)
                .doOnSuccess(createdTrend -> Mono.just(createdTrend))
                .doOnError(error -> Mono.error(new RuntimeException("Falha ao criar trend")));

    }
}
