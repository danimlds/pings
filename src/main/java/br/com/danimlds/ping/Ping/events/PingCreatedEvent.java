package br.com.danimlds.ping.Ping.events;

import br.com.danimlds.ping.Ping.Ping;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize
public class PingCreatedEvent {
    @JsonProperty
    private final String eventType;

    @JsonProperty
    private final Long pingId;

    @JsonProperty
    private final String body;

    @JsonProperty
    private final Long authorId;

    @JsonProperty
    private final Map<String, Object> payload;

    public PingCreatedEvent(String eventType, Long pingId, String body, Long authorId, Map<String, Object> payload) {
        this.eventType = eventType;
        this.pingId = pingId;
        this.body = body;
        this.authorId = authorId;
        this.payload = payload;
    }

    public static PingCreatedEvent of(Ping ping) {
        Map<String, Object> pingMapView = new HashMap<>();
        pingMapView.put("id", ping.getId());

        return new PingCreatedEvent("PingCreatedEvent", ping.getId(), ping.getBody(), ping.getAuthorId(), pingMapView);
    }
}
