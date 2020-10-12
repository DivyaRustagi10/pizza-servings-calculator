package pizzaservingscalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaServingsCalculator extends JFrame {

    private final JPanel contentPane; // main content panel
    private final JLabel lblTitle; // title  
    private final JPanel inputPanel; // user components panel
    private final JLabel lblUsrInstruction; // user instruction
    private JTextField tfUsrInput; // user input 
    private final JButton btnCalculate; // calculate button
    private final JLabel lblServingsResult; // servings size result

    public PizzaServingsCalculator() {

        // set first grid for title 
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 1));
        setContentPane(contentPane);

        // set title properties
        lblTitle = new JLabel("Pizza Serving Calculator");
        lblTitle.setForeground(Color.RED);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // set jpanel in second grid for user instruction and input
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        contentPane.add(inputPanel);

        // set user instruction properties
        lblUsrInstruction = new JLabel("Enter the size of the pizza in inches: ", 4);
        lblUsrInstruction.setFont(new Font("Arial", Font.BOLD, 11));

        // set user input field properties
        tfUsrInput = new JTextField();
        tfUsrInput.setColumns(5);

        // set third grid for calculate button on click         
        btnCalculate = new JButton("Calculate Servings");
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 11));        
        btnCalculate.addActionListener(new ActionListener() {

            @Override // get text to calculate when user clicks button
            public void actionPerformed(ActionEvent e) {
                double size = Double.parseDouble(tfUsrInput.getText()); // get input text
                
                // if input for size is negative
                if (size < 0) {                     
                    JOptionPane.showMessageDialog(contentPane, "Did you mean " + (int)(-1*size) + " inches?");                    
                    size = -1 * size; // size must be positive                              
                }
                
                // calculating serving result
                double servings = Math.pow((size / 8.0), 2);
                lblServingsResult.setText(String.format("A %.0f inch pizza will serve %.2f people.", size, servings));
            }
        });

        // set fourth grid for servings result
        lblServingsResult = new JLabel("");
        lblServingsResult.setFont(new Font("Arial", Font.BOLD, 11));
        lblServingsResult.setHorizontalAlignment(SwingConstants.CENTER);

        // add GUI components to grid
        contentPane.add(lblTitle); // 1st grid
        contentPane.add(inputPanel); //2nd grid
        inputPanel.add(lblUsrInstruction);
        inputPanel.add(tfUsrInput);
        contentPane.add(btnCalculate); // 3rd grid
        contentPane.add(lblServingsResult); // 4th grid
    }

    public static void main(String args[]) {

        PizzaServingsCalculator PSCalculatorFrame = new PizzaServingsCalculator();

        // set up contents in frame
        PSCalculatorFrame.setTitle("Pizza Serving Calculator");
        PSCalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PSCalculatorFrame.setVisible(true);
        PSCalculatorFrame.setSize(350, 300);
    }
}
