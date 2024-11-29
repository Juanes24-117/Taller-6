package uniandes.dpoo.swing.interfaz.principal;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    private JLabel labNombre;
    private JLabel labCalificacion;
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante()
    {
        setLayout(new GridLayout(3, 1));

        // Nombre
        labNombre = new JLabel("Nombre: ");
        add(labNombre);

        // Calificación
        labCalificacion = new JLabel("Calificación: ");
        add(labCalificacion);

        // Visitado
        chkVisitado = new JCheckBox("Visitado");
        chkVisitado.setEnabled(false);
        add(chkVisitado);
    }

    public void actualizarRestaurante(Restaurante r)
    {
        actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }

    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado)
    {
        labNombre.setText("Nombre: " + nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setSelected(visitado);
    }

    private ImageIcon buscarIconoCalificacion(int calificacion)
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon(imagen);
    }
}
