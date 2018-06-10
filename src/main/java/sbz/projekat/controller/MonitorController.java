package sbz.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import sbz.projekat.dto.MonitorDTO;
import sbz.projekat.model.Pacijent;
import sbz.projekat.repostory.PacijentRepository;

import java.util.List;
import java.util.Random;

@Controller
public class MonitorController {


    @Autowired
    private PacijentRepository pRepo;

    @MessageMapping("/monitorBack")
    @SendTo("/topic/monitor")
    public MonitorDTO greeting(MonitorDTO message) throws Exception {

        List<Pacijent> moguci = pRepo.findByMonitoring(true);

        MonitorDTO m = new MonitorDTO();

        if(moguci.size() >0){
            Random rand = new Random();
            int n = rand.nextInt(moguci.size());
            int tipPoruke = rand.nextInt(3)+1;
            String user= moguci.get(n).getPrezime() + " " + moguci.get(n).getIme();

            String s = "";
            switch(tipPoruke) {
                case 1 :
                    s=" has an Oxygen problem !!!";
                    break;

                case 2 :
                    s=" has an Heart rhythm problem !!!";
                    break;
                case 3 :
                    s=" needs Dialysis !!!";
                    break;

                default :
                    s=" has an Oxygen problem !!!";
            }
            m.setPoruka(user + s);

        }

        return m;
    }

}
