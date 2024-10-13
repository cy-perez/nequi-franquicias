package nequi.franquicias.domain.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SucursalCreate {
    private int id;
    private String nombre;
    private int franquicia;
}
