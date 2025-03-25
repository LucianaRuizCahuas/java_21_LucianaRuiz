package guia07;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField pantalla;
    private double num1 = 0, num2 = 0, resultado = 0;
    private String operador = "";

    public Calculadora() {
        // Configuración de la ventana
        setTitle("Calculadora en Java");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pantalla de la calculadora
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 32));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        add(pantalla, BorderLayout.NORTH);

        // Botones de la calculadora
        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setFocusable(false);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) { // Números y punto decimal
            if (command.equals(".") && pantalla.getText().contains(".")) {
                return; // Evita múltiples puntos decimales
            }
            pantalla.setText(pantalla.getText() + command);
        } else if (command.matches("[/*\\-+]")) { // Operadores
            if (!pantalla.getText().isEmpty()) {
                num1 = Double.parseDouble(pantalla.getText());
                operador = command;
                pantalla.setText("");
            }
        } else if (command.equals("=")) { // Calcular resultado
            if (!pantalla.getText().isEmpty() && !operador.isEmpty()) {
                num2 = Double.parseDouble(pantalla.getText());
                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            pantalla.setText("Error");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }
                pantalla.setText(String.valueOf(resultado));
                operador = ""; // Resetear operador para evitar cálculos erróneos
            }
        } else if (command.equals("C")) { // Borrar todo
            pantalla.setText("");
            num1 = num2 = resultado = 0;
            operador = "";
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}