package jss.api.wse.controller;

import jss.api.wse.model.Trend;
import jss.api.wse.service.TrendService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("trends")
public class TrendController {

    private static final Logger logger = LoggerFactory.getLogger(TrendController.class);
    private final TrendService trendService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Trend> createTrend(@RequestBody Mono<Trend> trend) {
        return trend.flatMap(trendService::create)
                .doOnSuccess(created -> logger.info(created.toString()))
                .doOnError(error -> logger.debug("Fail to create a trend", error.fillInStackTrace()));
    }
}
