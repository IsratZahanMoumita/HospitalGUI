import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class Patient {
    int id;
    String name;
    int age;
    String disease;
    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}
class Doctor {
    int id;
    String name;
    String specialization;
    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}
class Appointment {
    int pid;
    int did;
    String date;
    Appointment(int pid, int did, String date) {
        this.pid = pid;
        this.did = did;
        this.date = date;
    }
}

public class HospitalGUI extends JFrame {
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Appointment> appointments = new ArrayList<>();
    DefaultTableModel model;
    public HospitalGUI() {
        setTitle("Hospital Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField diseaseField = new JTextField();
        JTextField specField = new JTextField();
        JTextField dateField = new JTextField();
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Disease:"));
        panel.add(diseaseField);
        panel.add(new JLabel("Specialization:"));
        panel.add(specField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        add(panel, BorderLayout.NORTH);
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        JButton addPatient = new JButton("Add Patient");
        JButton addDoctor = new JButton("Add Doctor");
        JButton bookApp = new JButton("Book Appointment");
        JButton viewPatient = new JButton("View Patients");
        JButton viewDoctor = new JButton("View Doctors");
        JButton viewApp = new JButton("View Appointments");
        btnPanel.add(addPatient);
        btnPanel.add(addDoctor);
        btnPanel.add(bookApp);
        btnPanel.add(viewPatient);
        btnPanel.add(viewDoctor);
        btnPanel.add(viewApp);
        add(btnPanel, BorderLayout.SOUTH);
        addPatient.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String disease = diseaseField.getText();

            patients.add(new Patient(id, name, age, disease));
            JOptionPane.showMessageDialog(this, "Patient Added!");
        });
        addDoctor.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String spec = specField.getText();

            doctors.add(new Doctor(id, name, spec));
            JOptionPane.showMessageDialog(this, "Doctor Added!");
        });
        bookApp.addActionListener(e -> {
            int pid = Integer.parseInt(idField.getText());
            int did = Integer.parseInt(ageField.getText()); // reuse field
            String date = dateField.getText();

            appointments.add(new Appointment(pid, did, date));
            JOptionPane.showMessageDialog(this, "Appointment Booked!");
        });
        viewPatient.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Age", "Disease"});

            for (Patient p : patients) {
                model.addRow(new Object[]{p.id, p.name, p.age, p.disease});
            }
        });
        viewDoctor.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Specialization"});

            for (Doctor d : doctors) {
                model.addRow(new Object[]{d.id, d.name, d.specialization});
            }
        });
        viewApp.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnIdentifiers(new String[]{"Patient ID", "Doctor ID", "Date"});

            for (Appointment a : appointments) {
                model.addRow(new Object[]{a.pid, a.did, a.date});
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new HospitalGUI();
    }
