package br.com.danimlds.ping.Ping;

import br.com.danimlds.ping.Ping.events.PingCreatedEvent;
import br.com.danimlds.ping.Ping.events.PingDeletedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value(value = "${topics.pg_created}")
    private String pingCreatedTopic;

    @Value(value = "${topics.pg_deleted")
    private String pingDeletedTopic;

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void emitPingCreatedEvent(Ping pg) {
        this.template.send(this.pingCreatedTopic, PingCreatedEvent.of(pg));
    }


    public void emitPingDeletedEvent(Ping pg) {
        this.template.send(this.pingDeletedTopic, PingDeletedEvent.of(pg));
    }

}
