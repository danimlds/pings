package br.com.danimlds.ping.Ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PingService {
    private final PingRepository repo;
    private final ProducerService producer;

    @Autowired
    public PingService(PingRepository repo, ProducerService producer) {
        this.repo = repo;
        this.producer = producer;
    }

    public Ping createPing(Ping ping) {
        try {
            Ping pg = this.repo.save(ping);
            this.producer.emitPingCreatedEvent(pg);
            return pg;
        }catch(Exception e) {
            throw new IllegalArgumentException("Ping creation violates restrictions: " +ping);
        }
    }

    public Optional<Ping> getPingById(Long id){
        return repo.findById(id);
    }

    public void deletePing(Long id) {
        Optional<Ping> ping = getPingById(id);
        if(ping.isPresent()) {
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Unable to delete ping!");
        }
    }

    public Ping replyPing(Ping ping) {
       try {
           Ping pg = this.repo.save(ping);
           this.producer.emitPingCreatedEvent(pg);
           return pg;
       }catch (Exception e) {
           throw new RuntimeException("Invalid Reply!" + ping);
       }
    }

    public Iterable<Ping> getPings() {
        return repo.findAll();
    }

}
