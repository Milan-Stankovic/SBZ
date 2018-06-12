package sbz.projekat.dto;


import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("15m")
public class KiseonikEvent {

    public KiseonikEvent() {
    }
}
