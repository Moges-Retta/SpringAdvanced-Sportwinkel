package be.vdab.sportwinkel.messages;

import be.vdab.sportwinkel.domain.ArtikelGemaaktTable;
import be.vdab.sportwinkel.repositories.ArtikelGemaaktRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
class MessageSender {
    private final ArtikelGemaaktRepository repository;
    private final AmqpTemplate template;

    MessageSender(ArtikelGemaaktRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Scheduled(fixedDelay = 5_000)
    @Transactional
    void verstuurMessages() {
        var artikelsGemaakt = repository.findAll();
        for (ArtikelGemaaktTable gemaakt : artikelsGemaakt) {
            template.convertAndSend("sportartikels", null, gemaakt);
        }
        repository.deleteAll(artikelsGemaakt);
    }
}

