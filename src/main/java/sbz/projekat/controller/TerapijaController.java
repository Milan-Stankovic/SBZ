package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.TerapijaDTO;
import sbz.projekat.model.Terapija;
import sbz.projekat.service.TerapijaService;

import java.util.List;

@RestController
public class TerapijaController {

    @Autowired
    private TerapijaService tService;

    @RequestMapping(method = RequestMethod.GET, value = "/therapy")
    public List<Terapija> getAll(){ return tService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/therapy/doctor/{id}")
    public List<Terapija> getByDoctor(@PathVariable Long id){ return tService.getTerapijaByLekar(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/therapy{id}")
    public Terapija getOne(@PathVariable Long id){ return tService.getOne(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/therapy/patient/{id}")
    public List<Terapija> getByPatient(@PathVariable Long id){ return tService.getTerapijaByPacijent(id); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/therapy/{id}")
    public void removeOne(@PathVariable Long id){ tService.removeTerapija(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/therapy/add")
    public Terapija add(@RequestBody TerapijaDTO t){ return tService.addTerapija(t); }

    @RequestMapping(method = RequestMethod.PUT, value = "/therapy/edit/{id}")
    public Terapija edit(@RequestBody TerapijaDTO t, @PathVariable Long id){ return tService.editTerapija(t, id); }
}
