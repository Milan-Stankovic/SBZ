package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.SastojakDTO;
import sbz.projekat.model.Sastojak;
import sbz.projekat.service.SastojakService;

import java.util.List;

@RestController
public class SastojakController {

    @Autowired
    private SastojakService sService;

    @RequestMapping(method = RequestMethod.GET, value = "/ingredient")
    public List<Sastojak> getAll(){ return sService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/ingredient/{name}")
    public Sastojak getOne(@PathVariable String name){ return sService.getSastojak(name); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/ingredient/{id}")
    public void removeOne(@PathVariable Long id){ sService.removeSastojak(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/ingredient/add")
    public Sastojak add(@RequestBody SastojakDTO s){
        return sService.addSastojak(s);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/ingredient/edit/{id}")
    public Sastojak edit(@RequestBody SastojakDTO s, @PathVariable Long id){
        return sService.editSastojak(s, id);
    }
}
