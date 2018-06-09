package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.BolestDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.service.BolestService;

import java.util.List;

@RestController
public class BolestController {

    @Autowired
    private BolestService bService;

    @RequestMapping(method = RequestMethod.GET, value = "/illness")
    public List<Bolest> getAll(){
        return bService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/illness/{name}")
    public Bolest getOne(@PathVariable String name){
        return bService.getOne(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/illness/get/{id}")
    public Bolest getOneId(@PathVariable Long id){
        return bService.getOneId(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/illness/{id}")
    public void removeOne(@PathVariable Long id){
        bService.removeBolest(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/illness/add")
    public Bolest add(@RequestBody BolestDTO b){
         return bService.addBolest(b);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/illness/edit/{id}")
    public Bolest edit(@RequestBody BolestDTO b, @PathVariable Long id){
        return bService.editBolest(b, id);
    }


}
