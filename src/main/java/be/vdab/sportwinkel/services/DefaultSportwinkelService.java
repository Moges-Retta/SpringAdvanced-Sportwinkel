package be.vdab.sportwinkel.services;

import be.vdab.sportwinkel.domain.Artikel;
import be.vdab.sportwinkel.domain.ArtikelGemaaktTable;
import be.vdab.sportwinkel.events.ArtikelGemaakt;
import be.vdab.sportwinkel.repositories.ArtikelGemaaktRepository;
import be.vdab.sportwinkel.repositories.SportwinkelRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DefaultSportwinkelService implements SportwinkelService{
    private final SportwinkelRepository repository;
    private final ArtikelGemaaktRepository artikelGemaaktRepository;
    //private final AmqpTemplate template;
    public DefaultSportwinkelService(SportwinkelRepository repository, ArtikelGemaaktRepository artikelGemaaktRepository) {
        this.repository = repository;
        this.artikelGemaaktRepository=artikelGemaaktRepository;
        //this.template = template;
    }

    @Override
    public void create(Artikel artikel) {
        repository.save(artikel);
        artikelGemaaktRepository.save(new ArtikelGemaaktTable(artikel));
        //template.convertAndSend("sportartikels",null,new ArtikelGemaakt(artikel));
    }
}
