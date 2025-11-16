import java.awt.*;
import javax.swing.*;

public class OpeningGUIState implements State {

    @Override
    public JPanel getPanel(GUIContext context) {

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Warehouse Login System", JLabel.CENTER);
        panel.add(label);
        
        //Client Login
        JButton clientBtn = new JButton("Client Login");
        clientBtn.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("Enter Client ID:");
            try {
                int id = Integer.parseInt(idStr);
                context.setClientID(id);
                context.setState(new ClientMenuGUIState());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid ID!");
            }
        });

        //Clerk Login
        JButton clerkBtn = new JButton("Clerk Login");
        clerkBtn.addActionListener(e -> context.setState(new ClerkMenuGUIState()));
        panel.add(clerkBtn);

        //manager Login
        JButton managerBtn = new JButton("Manager Login");
        managerBtn.addActionListener(e -> context.setState(new ManagerMenuGUIState()));
        panel.add(managerBtn);

        panel.add(clientBtn);

        return panel;
    }
}
