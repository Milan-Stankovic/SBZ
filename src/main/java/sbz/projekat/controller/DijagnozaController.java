package sbz.projekat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.*;
import sbz.projekat.model.Bolest;
import sbz.projekat.service.DijagnozaService;

import java.util.List;

@RestController
public class DijagnozaController {

    @Autowired
    private  DijagnozaService dService;

    @RequestMapping(value = "/drools/naj", method = RequestMethod.POST)
    public RezultatBolestiDTO getNajverovatnije(@RequestBody DijagnozaDTO d)  { return dService.najverovatnije(d);}

    @RequestMapping(value = "/drools/sve", method = RequestMethod.POST)
    public List<Bolest> getSve(@RequestBody DijagnozaDTO d){
        return dService.sve(d);
    }

    @RequestMapping(value = "/drools/validiraj", method = RequestMethod.POST)
    public RezultatStringDTO validiraj(@RequestBody ValidacijaDTO d){
        return dService.validiraj(d);
    }

    @RequestMapping(value = "/drools/izvestaj", method = RequestMethod.GET)
    public RezultatIzvestajaDTO izvestaj(){
        return dService.izvestaj();
    }

    @RequestMapping(value = "/drools/monitor", method = RequestMethod.GET)
    public RezultatStringDTO monitor(){
        return dService.monitor();
    }

    @RequestMapping(value = "/drools/bolest", method = RequestMethod.POST)
    public RezultatSimptomiDTO bolest(@RequestBody SimptomiDTO id){ return dService.bolest(id);
    }


}
