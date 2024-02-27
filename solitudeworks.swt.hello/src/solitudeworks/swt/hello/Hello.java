package solitudeworks.swt.hello;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class Hello {

	public static void main(String[] args) {
		
		final Display display = new Display();
		final Shell shell = new Shell(display);
		final Label label = new Label(shell, SWT.LEFT);
		final Text text  = new Text(shell, SWT.BORDER | SWT.SINGLE);
		final GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		final Button button = new Button(shell, SWT.PUSH);
		
		shell.setText("Hello there");
		shell.setLayout(new GridLayout(2, false));
		
		label.setText("&Name:");
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	
		data.minimumWidth = 120;
		text.setLayoutData(data);
		
		button.setText("Say Hello");
		shell.setDefaultButton(button);
		button.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false, 2, 1));
		
		final Label output = new Label(shell, SWT.CENTER);
		output.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		button.addListener(SWT.Selection, event -> {
			String name = text.getText().trim();
			if (name.length() == 0) {
				name = "world";
			}
			output.setText("Hello " + name + "!");
		});

		shell.setSize(shell.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
		
	}

}
