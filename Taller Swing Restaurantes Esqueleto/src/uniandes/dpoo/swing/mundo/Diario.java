package uniandes.dpoo.swing.mundo;

import java.util.ArrayList;
import java.util.List;

public class Diario
{
    private List<Restaurante> restaurantes;

    public Diario()
    {
        this.restaurantes = new ArrayList<>();
    }

    public List<Restaurante> getRestaurantes(boolean completos)
    {
        List<Restaurante> seleccion = new ArrayList<>();
        if (completos)
        {
            seleccion.addAll(this.restaurantes);
        }
        else
        {
            for (Restaurante r : this.restaurantes)
            {
                if (r.isVisitado())
                {
                    seleccion.add(r);
                }
            }
        }
        return seleccion;
    }

    public void agregarRestaurante(Restaurante restaurante)
    {
        this.restaurantes.add(restaurante);
    }
}
