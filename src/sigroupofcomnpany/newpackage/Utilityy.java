
package sigroupofcomnpany.newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sigroupofcomnpany.DataBaseConnection;

public class Utilityy {
     public static void showErrorDialog(Set<String> messages) {
       String errors = "<html><body color='red'>" + String.join("<br>", messages) + "</body></html>";

        JOptionPane.showMessageDialog(null, errors);
   }
    public static void showSuccessDialog(String messages) {

       JOptionPane.showMessageDialog(null, messages);
    }

   public static void showSingleErrorDialog(String messages) {
       String html = "<html><body><h3 style='color:red;'>"+messages+"</h3></body></html>";
       JOptionPane.showMessageDialog(null, html);
    }

    public static void removeAllRowFromTable(DefaultTableModel model) {
        if (model != null) {
            int rows = model.getRowCount();
            for (int row = rows - 1; row >= 0; row--) {
                model.removeRow(row);
            }
        } else {
            showSingleErrorDialog("TableModel empty not allowed.");
        }

    }

    public static void addPopUPMenu(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int code = (int) table.getValueAt(row, 0);
                boolean isDeleted = delete(code);
                if(isDeleted){
                    model.removeRow(row);
                }
                
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }
    
    private static boolean delete(int id){
        boolean flag =true;
        try {
            Connection conn = DataBaseConnection.connect();
            PreparedStatement pst = conn.prepareStatement("delete from buyerorder where code=?");
            pst.setInt(1, id);
            int rs = pst.executeUpdate();
            if(rs > 0){
                showSingleErrorDialog("Deleted successfully");
            }else{
                flag = false;
                showSingleErrorDialog("Deleted failed!");
            }
        } catch (SQLException ex) {
             flag = false;
            Logger.getLogger(Utilityy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    
}
