package jss.api.wse.controller;

import jss.api.wse.model.Trend;
import jss.api.wse.repository.TrendRepository;
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
    private final TrendRepository trendRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Trend> createTrend(@RequestBody Mono<Trend> trend) {
        return trend.flatMap(trendRepository::save)
                .doOnSuccess(created -> logger.info("Trend created successfully."))
                .doOnError(error -> logger.debug("Fail to create a trend.", error.fillInStackTrace()));
    }
}
