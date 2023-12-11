import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessGymApp extends JFrame implements ActionListener {

    private JButton checkInButton;
    private JButton viewScheduleButton;
    private JButton trackProgressButton;
    private JTextField usernameTextField;

    private JTable scheduleTable;

    // Sample schedule data (replace this with your actual data)
    private Object[][] scheduleData = {
            {"Monday", "Cardio", "6:00 AM"},
            {"Tuesday", "Strength Training", "5:30 PM"},
            {"Wednesday", "Yoga", "7:00 AM"},
            // Add more rows as needed
    };

    private String[] scheduleColumns = {"Day", "Activity", "Time"};

    public FitnessGymApp() {
        // Set up the JFrame
        setTitle("Fitness Gym App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        checkInButton = new JButton("Check In");
        viewScheduleButton = new JButton("View Schedule");
        trackProgressButton = new JButton("Track Progress");

        // Create text field for entering username
        usernameTextField = new JTextField(15);

        // Add action listeners to buttons
        checkInButton.addActionListener(this);
        viewScheduleButton.addActionListener(this);
        trackProgressButton.addActionListener(this);

        // Create a panel to hold the buttons and text field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(new JLabel("Username:"));
        buttonPanel.add(usernameTextField);
        buttonPanel.add(checkInButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(trackProgressButton);

        // Create a table to display the schedule
        scheduleTable = new JTable(scheduleData, scheduleColumns);

        // Add the components to the content pane
        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(new JScrollPane(scheduleTable), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkInButton) {

            if (!(secureCheckIn().isEmpty())) {
                JOptionPane.showMessageDialog(this, "Welcome, " + "!\nChecked In!");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a username before checking in.");
            }
        } else if (e.getSource() == viewScheduleButton) {
            // Display the schedule table
            JOptionPane.showMessageDialog(this, new JScrollPane(scheduleTable),
                    "Gym Schedule", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == trackProgressButton) {
            JOptionPane.showMessageDialog(this, "Achievements");
        }
    }

    String secureCheckIn() {
        return usernameTextField.getText();
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FitnessGymApp app = new FitnessGymApp();
            app.setVisible(true);
        });
    }
}
