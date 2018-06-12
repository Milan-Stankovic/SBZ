package sbz.projekat.dto;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("10s")
public class SrceEvent implements Serializable {

    public SrceEvent() {
    }
}
