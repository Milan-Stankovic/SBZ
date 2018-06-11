package sbz.projekat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sbz.projekat.dto.DijagnozaDTO;
import sbz.projekat.dto.IzvestajDTO;
import sbz.projekat.dto.ValidacijaDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.service.DijagnozaService;

import java.util.List;

@Controller
public class DijagnozaController {

    private static Logger log = LoggerFactory.getLogger(DijagnozaController.class);

    @Autowired
    private  DijagnozaService dService;


    @RequestMapping(value = "/drools/naj", method = RequestMethod.GET, produces = "application/json")
    public List<Bolest> getNajverovatnije(@RequestBody DijagnozaDTO d)  {

        return dService.najverovatnije(d);

    }

    @RequestMapping(value = "/drools/sve", method = RequestMethod.GET, produces = "application/json")
    public List<Bolest> getSve(@RequestBody DijagnozaDTO d){
        return dService.sve(d);
    }

    @RequestMapping(value = "/drools/validiraj", method = RequestMethod.GET, produces = "application/json")
    public boolean validiraj(@RequestBody ValidacijaDTO d){
        return dService.validiraj(d);
    }

    @RequestMapping(value = "/drools/izvestaj", method = RequestMethod.GET, produces = "application/json")
    public IzvestajDTO izvestaj(){
        return dService.izvestaj();
    }



}
