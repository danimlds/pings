package br.com.danimlds.ping.Ping.events;

import br.com.danimlds.ping.Ping.Ping;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PingDeletedEvent {

    @JsonProperty
    private String eventType;

    @JsonProperty
    private Long pingId;

    @JsonProperty
    private Long authorId;

    public PingDeletedEvent(String eventType, Long pingId, Long authorId) {
        this.eventType = eventType;
        this.pingId = pingId;
        this.authorId = authorId;
    }

    public static PingDeletedEvent of(Ping ping) {
        return new PingDeletedEvent("PingDeletedEvent", ping.getId(), ping.getAuthorId());
    }

}
