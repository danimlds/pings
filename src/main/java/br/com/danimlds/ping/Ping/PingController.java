package br.com.danimlds.ping.Ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pings")
public class PingController {

    private final PingService service;


    @Autowired
    public PingController(PingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ping createOnePing(@RequestBody Ping ping) {
        System.out.println(ping);
        return this.service.createPing(ping);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deletePing(id);
        return "Ping successfully deleted!";
    }

    @PostMapping("/{id}/replies")
    @ResponseStatus(HttpStatus.CREATED)
    public Ping replyPing(@RequestBody Ping ping) {
        System.out.println(ping);
        return this.service.createPing(ping);
    }

    @GetMapping
    public Iterable<Ping> get() {
        return service.getPings();
    }

}
