import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HospitalGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400, 450);
        frame.setTitle("Hospital Management System");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Display Label (like calculator screen)
       JTextArea display = new JTextArea();
display.setLineWrap(true);
display.setWrapStyleWord(true);

JScrollPane scroll = new JScrollPane(display);
scroll.setBounds(20, 10, 350, 60);   // smaller height
frame.add(scroll);

        // Input Fields
       JLabel l1 = new JLabel("Enter ID:");
l1.setBounds(30, 80, 100, 25);   // was 50 → now 80
frame.add(l1);

JTextField tf1 = new JTextField();
tf1.setBounds(120, 80, 150, 25);
frame.add(tf1);

JLabel l2 = new JLabel("Enter Name:");
l2.setBounds(30, 110, 100, 25);  // was 80 → now 110
frame.add(l2);

JTextField tf2 = new JTextField();
tf2.setBounds(120, 110, 150, 25);
frame.add(tf2);


        // Buttons (same style as calculator)
        JButton addDoctor = new JButton("Add Doctor");
        addDoctor.setBounds(100, 150, 180, 30);
        frame.add(addDoctor);

        JButton addPatient = new JButton("Add Patient");
        addPatient.setBounds(100, 190, 180, 30);
        frame.add(addPatient);

        JButton viewDoctor = new JButton("View Doctors");
        viewDoctor.setBounds(100, 230, 180, 30);
        frame.add(viewDoctor);

        JButton viewPatient = new JButton("View Patients");
        viewPatient.setBounds(100, 270, 180, 30);
        frame.add(viewPatient);

        JButton clear = new JButton("Clear");
        clear.setBounds(100, 310, 180, 30);
        frame.add(clear);

        // Data Storage
        ArrayList<String> doctors = new ArrayList<>();
        ArrayList<String> patients = new ArrayList<>();

        // Add Doctor
        addDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = tf1.getText();
                String name = tf2.getText();

                if(id.isEmpty() || name.isEmpty()){
                    display.setText("Enter ID & Name!");
                } else {
                    doctors.add("ID: " + id + " Name: " + name);
                    display.setText("Doctor Added!");
                }
            }
        });

        // Add Patient
        addPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = tf1.getText();
                String name = tf2.getText();

                if(id.isEmpty() || name.isEmpty()){
                    display.setText("Enter ID & Name!");
                } else {
                    patients.add("ID: " + id + " Name: " + name);
                    display.setText("Patient Added!");
                }
            }
        });

        // View Doctors
        viewDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(doctors.isEmpty()){
                    display.setText("No Doctors Found!");
                } else {
                  String result = "";
for(String d : doctors){
    result += d + "\n";
}
display.setText(result);
                }
            }
        });

        // View Patients
        viewPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(patients.isEmpty()){
                    display.setText("No Patients Found!");
                } else {
                    String result = "";
for(String p : patients){
    result += p + "\n";
}
display.setText(result);
                }
            }
        });

        // Clear Fields
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                display.setText("");
            }
        });

        frame.setVisible(true);
    }
}
