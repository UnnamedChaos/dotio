package de.nieder.dotio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jens Bachmann (jens.bachmann@iteratec.de)
 * @since 10.10.2017
 */
@RestController
@RequestMapping("/api/v1/samples")
public class SampleController {
    /** The SLF4J Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);


    @GetMapping

    public String createSample() {

        return "test";
    }

}
