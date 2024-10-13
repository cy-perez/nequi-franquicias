package nequi.franquicias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "sucursales")
@NoArgsConstructor
@AllArgsConstructor
public class SucursalData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_sucursal", nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia")
    private FranquiciaData franquicia;
}
