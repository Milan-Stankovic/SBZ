package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbz.projekat.dto.KorisnikDTO;
import sbz.projekat.model.Korisnik;
import sbz.projekat.service.KorisnikService;

import java.util.List;

@RestController
public class KorisnikController {

    @Autowired
    private KorisnikService korService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<Korisnik> getAll(){
        return korService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{name}")
    public Korisnik getOne(@PathVariable String name){
        return korService.getByUsernameKorisnik(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public Korisnik getOneId(@PathVariable Long id){
        return korService.getById(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{last}")
    public List<Korisnik> getOneLast(@PathVariable String last){
        return korService.getByLastName(last);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{first}/{last}")
    public List<Korisnik> getOneLastAndFirst(@PathVariable String first, @PathVariable String last){
        return korService.getByFirstNameAndLastName(first,last);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void removeOne(@PathVariable Long id){
        korService.removeKorisnik(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    public Korisnik add(@RequestBody KorisnikDTO k){
        return korService.addKorisnik(k);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/edit/{id}")
    public Korisnik edit(@RequestBody KorisnikDTO k, @PathVariable Long id){
        return korService.edit(k, id);
    }

}
