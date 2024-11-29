package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    private static final String VISITADOS = "VISITADOS";
    private static final String TODOS = "TODOS";

    private PanelMapaVisualizar panelMapa;
    private JRadioButton radioTodos;
    private JRadioButton radioVisitados;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa(VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes)
    {
        this.ventanaPrincipal = ventanaPrincipal;

        // Configura el panel del mapa
        panelMapa = new PanelMapaVisualizar();
        panelMapa.actualizarMapa(restaurantes);
        add(panelMapa, BorderLayout.CENTER);

        // Configura los botones para mostrar opciones de restaurantes
        JPanel panelRadios = new JPanel();
        radioTodos = new JRadioButton("Todos", true);
        radioTodos.setActionCommand(TODOS);
        radioTodos.addActionListener(this);

        radioVisitados = new JRadioButton("Visitados", false);
        radioVisitados.setActionCommand(VISITADOS);
        radioVisitados.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioTodos);
        grupo.add(radioVisitados);

        panelRadios.add(radioTodos);
        panelRadios.add(radioVisitados);
        add(panelRadios, BorderLayout.SOUTH);

        // Configuración de la ventana
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (TODOS.equals(comando))
        {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(true));
        }
        else if (VISITADOS.equals(comando))
        {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(false));
        }
    }
}
