package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.LekDTO;
import sbz.projekat.model.Lek;
import sbz.projekat.service.LekService;

import java.util.List;

@RestController
public class LekController {

    @Autowired
    private LekService lService;

    @RequestMapping(method = RequestMethod.GET, value = "/medicine")
    public List<Lek> getAll(){ return lService.getAll(); }

    @RequestMapping(method = RequestMethod.GET, value = "/medicine/{name}")
    public Lek getOne(@PathVariable String name){ return lService.getLek(name); }

    @RequestMapping(method = RequestMethod.GET, value = "/medicine/get/{id}")
    public Lek getOneId(@PathVariable Long id){ return lService.getLekId(id); }

    @RequestMapping(method = RequestMethod.DELETE, value = "/medicine/{id}")
    public void removeOne(@PathVariable Long id){ lService.removeLek(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/medicine/add")
    public Lek add(@RequestBody LekDTO l){
        return lService.addLek(l);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/medicine/edit/{id}")
    public Lek edit(@RequestBody LekDTO l, @PathVariable Long id){
        return lService.editLek(l, id);
    }

}
