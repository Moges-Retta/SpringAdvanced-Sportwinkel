package be.vdab.sportwinkel.controllers;

import be.vdab.sportwinkel.domain.Artikel;
import be.vdab.sportwinkel.services.SportwinkelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/artikels")
public class indexController {
    private final SportwinkelService service;

    public indexController(SportwinkelService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void post(@RequestBody Artikel artikel) {
        service.create(artikel);
    }
}
