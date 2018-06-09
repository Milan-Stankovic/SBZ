package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.IstorijaBolestiDTO;
import sbz.projekat.dto.PacijentDTO;
import sbz.projekat.dto.SastojakDTO;
import sbz.projekat.model.Pacijent;
import sbz.projekat.service.PacijentService;

import java.util.List;

@RestController
public class PacijentController {

    @Autowired
    private PacijentService pService;

    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    public List<Pacijent> getAll(){ return pService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{knjizica}")
    public Pacijent getOne(@PathVariable String knjizica){ return pService.getPacijentZdravstvena(knjizica);  }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/get/{id}")
    public Pacijent getOneId(@PathVariable Long id){ return pService.getOne(id);  }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{ime}/{prezime}")
    public List<Pacijent> getImePrezime(@PathVariable String ime, @PathVariable String prezime){ return pService.getAllImePrezime(ime, prezime); }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/monitoring")
    public List<Pacijent> getMonitoring(){ return pService.getAllMonitoring(true); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/patient/{id}")
    public void removeOne(@PathVariable Long id){ pService.removePacijent(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/patient/add")
    public Pacijent add(@RequestBody PacijentDTO p){ return pService.addPacijent(p); }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/edit/{id}")
    public Pacijent edit(@RequestBody PacijentDTO p, @PathVariable Long id){ return pService.editPacijent(p, id); }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/{id}/allergy/")
    public void addAlergija(@RequestBody SastojakDTO s, @PathVariable Long id){  pService.addAlergija(s, id); }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/{id}/allergy/{id2}")
    public void addAlergijaId(@PathVariable Long id, @PathVariable Long id2){  pService.addAlergijaId(id2, id); }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/{id}/history")
    public void addIstorija(@RequestBody IstorijaBolestiDTO i, @PathVariable Long id){  pService.addIstorija(i, id); }

}
