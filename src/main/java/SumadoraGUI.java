import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * SumadoraGUI es una aplicación de calculadora simple con una interfaz gráfica de usuario (GUI)
 * construida con Swing. Permite al usuario ingresar dos números, sumarlos y ver el resultado.
 * Maneja entradas inválidas mostrando un mensaje de error.
 */
public class SumadoraGUI extends JFrame {

    // Campos de texto para la entrada de los números y para mostrar el resultado
    private JTextField numField1; // Campo para el primer número
    private JTextField numField2; // Campo para el segundo número
    private JTextField resultField; // Campo para mostrar el resultado de la suma (no editable)
    private JButton sumButton; // Botón para activar la operación de suma

    /**
     * Constructor de la clase SumadoraGUI.
     * Configura la ventana principal (JFrame), inicializa los componentes de la GUI,
     * los organiza en un panel y establece el manejo de eventos para el botón de suma.
     */
    public SumadoraGUI() {
        // Configuración básica de la ventana principal (JFrame)
        setTitle("Sumadora GUI"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Asegura que la aplicación se cierre al cerrar la ventana

        // Creación del panel principal que contendrá todos los componentes
        JPanel mainPanel = new JPanel();
        // Se utiliza GridLayout para organizar los componentes en una cuadrícula de 4 filas y 2 columnas,
        // con espacios de 5 píxeles horizontal y verticalmente entre componentes.
        mainPanel.setLayout(new GridLayout(4, 2, 5, 5));

        // Inicialización y adición de componentes a mainPanel
        // Fila 1: Etiqueta y campo de texto para el primer número
        mainPanel.add(new JLabel("Número 1:")); // Etiqueta para el primer número
        numField1 = new JTextField(10); // Campo de texto con 10 columnas de ancho
        mainPanel.add(numField1);

        // Fila 2: Etiqueta y campo de texto para el segundo número
        mainPanel.add(new JLabel("Número 2:")); // Etiqueta para el segundo número
        numField2 = new JTextField(10); // Campo de texto con 10 columnas de ancho
        mainPanel.add(numField2);

        // Fila 3: Botón de suma y una etiqueta vacía para mantener la estructura de la cuadrícula
        sumButton = new JButton("Sumar"); // Botón que dispara la acción de suma
        mainPanel.add(sumButton);
        mainPanel.add(new JLabel()); // Espacio vacío para equilibrar la cuadrícula

        // Fila 4: Etiqueta y campo de texto para mostrar el resultado
        mainPanel.add(new JLabel("Resultado:")); // Etiqueta para el resultado
        resultField = new JTextField(10); // Campo de texto para el resultado
        resultField.setEditable(false); // Se hace no editable ya que solo muestra la salida
        mainPanel.add(resultField);

        // Añade el panel principal al JFrame
        add(mainPanel);

        // Ajusta el tamaño de la ventana automáticamente según el tamaño de sus componentes
        pack();

        // Configuración del ActionListener para el botón 'sumButton'
        // Esto define qué sucede cuando el usuario hace clic en el botón.
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Bloque try-catch para manejar posibles errores de formato numérico
                try {
                    // Obtiene el texto de los campos de entrada
                    String num1Text = numField1.getText();
                    String num2Text = numField2.getText();

                    // Convierte el texto de los campos a números de tipo double
                    double num1 = Double.parseDouble(num1Text);
                    double num2 = Double.parseDouble(num2Text);

                    // Realiza la suma
                    double sum = num1 + num2;

                    // Muestra el resultado de la suma en el campo 'resultField'
                    resultField.setText(String.valueOf(sum));

                } catch (NumberFormatException ex) {
                    // Si ocurre un error al convertir los números (e.g., entrada no numérica),
                    // se limpia el campo de resultado y se muestra un diálogo de error.
                    resultField.setText(""); // Limpia el campo de resultado
                    JOptionPane.showMessageDialog(SumadoraGUI.this, // Contexto del diálogo
                            "Por favor, ingrese números válidos.", // Mensaje de error
                            "Error de Entrada", // Título del diálogo de error
                            JOptionPane.ERROR_MESSAGE); // Tipo de mensaje de error
                }
            }
        });
    }

    // Métodos getter para los componentes (útiles para pruebas o acceso externo si es necesario)
    public JTextField getNumField1() {
        return numField1;
    }

    public JTextField getNumField2() {
        return numField2;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getSumButton() {
        return sumButton;
    }

    public static void main(String[] args) {
        // El método main es el punto de entrada de la aplicación.
        // SwingUtilities.invokeLater se utiliza para asegurar que la creación y manipulación
        // de componentes Swing se realice en el Event Dispatch Thread (EDT),
        // lo cual es crucial para la seguridad de hilos en Swing.
        SwingUtilities.invokeLater(() -> {
            SumadoraGUI sumadora = new SumadoraGUI(); // Crea una instancia de la GUI
            sumadora.setVisible(true); // Hace visible la ventana de la GUI
        });
    }
}
