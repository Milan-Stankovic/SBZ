package sbz.projekat.controller;

import org.kie.api.runtime.KieSession;
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

    @RequestMapping(value = "/drools/naj/{id}", method = RequestMethod.POST)
    public RezultatBolestiDTO getNajverovatnije(@RequestBody DijagnozaDTO d, @PathVariable Long id)  { return dService.najverovatnije(d, id);}

    @RequestMapping(value = "/drools/sve/{id}", method = RequestMethod.POST)
    public List<Bolest> getSve(@RequestBody DijagnozaDTO d, @PathVariable Long id){
        return dService.sve(d, id);
    }

    @RequestMapping(value = "/drools/validiraj/{id}", method = RequestMethod.POST)
    public RezultatStringDTO validiraj(@RequestBody ValidacijaDTO d, @PathVariable Long id ){ return dService.validiraj(d,id); }

    @RequestMapping(value = "/drools/izvestaj/{id}", method = RequestMethod.GET)
    public RezultatIzvestajaDTO izvestaj(@PathVariable Long id){
        return dService.izvestaj(id);
    }

    @RequestMapping(value = "/drools/monitor", method = RequestMethod.GET)
    public RezultatStringDTO monitor(){
        return dService.monitor();
    }

    @RequestMapping(value = "/drools/session/login/{id}", method = RequestMethod.PUT)
    public void getSession(@PathVariable Long id){  dService.getSession(id); }

    @RequestMapping(value = "/drools/session/logout/{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){  dService.deleteSession(id); }

    @RequestMapping(value = "/drools/bolest/{id}", method = RequestMethod.POST)
    public RezultatSimptomiDTO bolest(@RequestBody SimptomiDTO s, @PathVariable Long id){ return dService.bolest(s,id); }


}
