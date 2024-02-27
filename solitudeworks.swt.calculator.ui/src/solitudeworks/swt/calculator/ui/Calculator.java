package solitudeworks.swt.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Calculator {

    private Display display;
    private Shell shell;

    private Text resultText;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.open();
    }

    public void open() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Calculator");
        shell.setLayout(new GridLayout(4, true));

        resultText = new Text(shell, SWT.BORDER | SWT.RIGHT);
        resultText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            Button button = new Button(shell, SWT.PUSH);
            button.setText(label);
            button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

            button.addListener(SWT.Selection, event -> handleButtonClick(label));
        }

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void handleButtonClick(String label) {
        switch (label) {
            case "=":
                // calculateResult();
            	System.out.println("Calculando");
                break;
            default:
                resultText.append(label);
        }
    }

//    private void calculateResult() {
//        try {
//            String expression = resultText.getText();
//            double result = evaluateExpression(expression);
//            resultText.setText(Double.toString(result));
//        } catch (Exception e) {
//            resultText.setText("Error");
//        }
//    }
//
//    private double evaluateExpression(String expression) {
//        return new DoubleEvaluator().evaluate(expression);
//    }
//
//    private static class DoubleEvaluator {
//        public double evaluate(String expression) {
//            return Double.parseDouble(expression);
//        }
//    }

}
