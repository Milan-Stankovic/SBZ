package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.SimptomiDTO;
import sbz.projekat.model.Simptom;
import sbz.projekat.service.SimptomService;

import java.util.List;

@RestController
public class SimptomController {


    @Autowired
    private SimptomService sService;

    @RequestMapping(method = RequestMethod.GET, value = "/symptom")
    public List<Simptom> getAll(){ return sService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/symptom/{name}")
    public Simptom getOne(@PathVariable String name){ return sService.getSimptom(name); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/symptom/{id}")
    public void removeOne(@PathVariable Long id){ sService.removeSimptom(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/symptom/add")
    public Simptom add(@RequestBody SimptomiDTO s){
        return sService.addSimptom(s);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/symptom/edit/{id}")
    public Simptom edit(@RequestBody SimptomiDTO s, @PathVariable Long id){
        return sService.editSimptom(s, id);
    }
}
