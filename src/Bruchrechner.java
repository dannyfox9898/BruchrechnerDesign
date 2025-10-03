import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Bruchrechner {
    private JPanel mainPanel;
    private JButton deleteBtn;
    private JButton divisionBtn;
    private JButton sevenBtn;
    private JButton nineBtn;
    private JButton multiplicationBtn;
    private JButton eightBtn;
    private JButton fourBtn;
    private JButton sixBtn;
    private JButton subtractionBtn;
    private JButton fiveBtn;
    private JButton threeBtn;
    private JButton additionBtn;
    private JButton twoBtn;
    private JButton oneBtn;
    private JTextField numerator1Txt;
    private JTextField numerator2Txt;
    private JTextField numerator3Txt;
    private JTextField denominator1Txt;
    private JTextField denominator2Txt;
    private JTextField denominator3Txt;
    private JTextField operatorTxt;
    private JButton commaBtn;
    private JButton equalsBtn;
    private JButton zeroBtn;
    private JButton plusMinusBtn;
    private JTextField activeField;

    JButton[] numberButtons;

    public Bruchrechner() {
        numberButtons = new JButton[]{oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, plusMinusBtn};
        activeField = numerator1Txt;

        // Add focus listener
        JTextField[] fields = {numerator1Txt, numerator2Txt, denominator1Txt, denominator2Txt, operatorTxt};
        for (JTextField field : fields) {
            field.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    activeField = field;
                    updateButtonStates();
                }
            });
        }

        // Apply input filters
        setInputFilter(numerator1Txt, true);
        setInputFilter(numerator2Txt, true);
        setInputFilter(denominator1Txt, true);
        setInputFilter(denominator2Txt, true);
        setInputFilter(operatorTxt, false);

        // Number buttons
        oneBtn.addActionListener(e -> appendToActiveField("1"));
        twoBtn.addActionListener(e -> appendToActiveField("2"));
        threeBtn.addActionListener(e -> appendToActiveField("3"));
        fourBtn.addActionListener(e -> appendToActiveField("4"));
        fiveBtn.addActionListener(e -> appendToActiveField("5"));
        sixBtn.addActionListener(e -> appendToActiveField("6"));
        sevenBtn.addActionListener(e -> appendToActiveField("7"));
        eightBtn.addActionListener(e -> appendToActiveField("8"));
        nineBtn.addActionListener(e -> appendToActiveField("9"));
        zeroBtn.addActionListener(e -> appendToActiveField("0"));
        plusMinusBtn.addActionListener(e -> toggleSign());

        // Operator buttons
        additionBtn.addActionListener(e -> operatorTxt.setText("+"));
        subtractionBtn.addActionListener(e -> operatorTxt.setText("-"));
        multiplicationBtn.addActionListener(e -> operatorTxt.setText("*"));
        divisionBtn.addActionListener(e -> operatorTxt.setText("/"));

        deleteBtn.addActionListener(e -> clearActiveField());

        equalsBtn.addActionListener(e -> calculate());

    }

    // Filter for keyboard input
    private void setInputFilter(JTextField field, boolean isNumberField) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isValidInput(string, isNumberField, field)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isValidInput(text, isNumberField, field)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                // Allow all remove operations
                super.remove(fb, offset, length);
            }
        });
    }

    private boolean isValidInput(String text, boolean isNumberField, JTextField field) {
        if (text.isEmpty()) return true; // allow deletion

        if (isNumberField) {
            // Digits and optional minus at start
            return text.matches("-?[0-9]*");
        } else {
            // Only one operator allowed
            if (!field.getText().isEmpty()) return false; // block if already has something
            return text.matches("[+\\-*/]");
        }
    }

    private void appendToActiveField(String text) {
        if (activeField != null) activeField.setText(activeField.getText() + text);
    }

    private void toggleSign() {
        if (activeField != null) {
            String text = activeField.getText();
            if (text.startsWith("-")) activeField.setText(text.substring(1));
            else activeField.setText("-" + text);
        }
    }

    private void clearActiveField() {
        if (activeField != null) activeField.setText("");
    }

    private void updateButtonStates() {
        boolean isOperatorField = (activeField == operatorTxt);
        for (JButton btn : numberButtons) {
            btn.setEnabled(!isOperatorField);
            btn.setBackground(isOperatorField ? Color.LIGHT_GRAY : null);
        }
    }

    private void calculate() {
        try {
            int num1 = Integer.parseInt(numerator1Txt.getText());
            int den1 = Integer.parseInt(denominator1Txt.getText());
            int num2 = Integer.parseInt(numerator2Txt.getText());
            int den2 = Integer.parseInt(denominator2Txt.getText());

            String op = operatorTxt.getText();
            int resultNum = 0, resultDen = 0;

            switch (op) {
                case "+" -> { resultNum = num1 * den2 + num2 * den1; resultDen = den1 * den2; }
                case "-" -> { resultNum = num1 * den2 - num2 * den1; resultDen = den1 * den2; }
                case "*" -> { resultNum = num1 * num2; resultDen = den1 * den2; }
                case "/" -> { resultNum = num1 * den2; resultDen = den1 * num2; }
                default -> throw new IllegalArgumentException("Invalid operator");
            }

            int gcd = gcd(resultNum, resultDen);
            numerator3Txt.setText(String.valueOf(resultNum / gcd));
            denominator3Txt.setText(String.valueOf(resultDen / gcd));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainPanel, "Invalid input: " + ex.getMessage());
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bruchrechner");
        Bruchrechner br = new Bruchrechner();
        frame.setContentPane(br.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        // Set Enter to trigger equals button
        frame.getRootPane().setDefaultButton(br.equalsBtn);

        frame.setVisible(true);
    }
}