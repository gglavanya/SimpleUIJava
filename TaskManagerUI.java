
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManagerUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerUI().createUI());
    }

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(listModel);
    private JTextField inputField = new JTextField();

    private void createUI() {
        JFrame frame = new JFrame("Simple Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputField, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Task");
        topPanel.add(addButton, BorderLayout.EAST);

        // Center list
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        JButton removeButton = new JButton("Remove Selected");
        bottomPanel.add(removeButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                inputField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                listModel.remove(selected);
            }
        });

        frame.setVisible(true);
    }
}
