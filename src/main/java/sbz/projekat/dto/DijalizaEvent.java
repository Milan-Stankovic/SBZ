package sbz.projekat.dto;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("12h")
public class DijalizaEvent {
    public DijalizaEvent() {
    }
}
