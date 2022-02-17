package br.com.danimlds.ping.Ping;

import javax.persistence.*;

@Entity
@Table
public class Ping {

    @Id
    @SequenceGenerator(
            name = "ping_seq_generator",
            sequenceName = "ping_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ping_seq_generator"
    )
    private Long id;

    private String body;

    private Long authorId;

    public Ping() {

    }

    public Ping(Long id, String body, Long authorId) {
        this.id = id;
        this.body = body;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Ping{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
