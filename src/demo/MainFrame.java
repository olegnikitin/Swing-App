package demo;

import demo.person.Person;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainFrame extends JFrame {
    
    private final List<Person> persons = Arrays.asList(
            new Person("Oleg", new Date(725587200000L)),    //29 Dec 1992 00:00:00 GMT
            new Person("John", new Date(946684800000L)),    //01 Jan 2000 00:00:00 GMT
            new Person("Jonnny", new Date(694224000000L)),  //01 Jan 1992 00:00:00 GMT
            new Person("Olga", new Date(978307200000L)));   //01 Jan 2001 00:00:00 GMT
    private final List<String> personsDateOfBirth = new ArrayList<>();

    private final DateParserAdapter parser = new DateParserAdapter("yyyy");

    public MainFrame() {
        initComponents();//should be first. it is generated by NetBeans
        setPersonsDataToTable();
        createListForPersonDateOfBirths();
        addListenersForTextFieldsToSearchRows(nameTextField, dateTextField);
    }    
    
    public static void main(String args[]) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }    
    
    private void setPersonsDataToTable() {
        DefaultTableModel model = (DefaultTableModel)personTable.getModel();
        model.addRow(new Object[]{persons.get(0).getName(), persons.get(0).getDateOfBirth()});
        model.addRow(new Object[]{persons.get(1).getName(), persons.get(1).getDateOfBirth()});
        model.addRow(new Object[]{persons.get(2).getName(), persons.get(2).getDateOfBirth()});
        model.addRow(new Object[]{persons.get(3).getName(), persons.get(3).getDateOfBirth()});
    }

    private void createListForPersonDateOfBirths() {
        for(Person person : persons) {
            personsDateOfBirth.add(parser.dateAsString(person.getDateOfBirth()));
        }
    }

    private void addListenersForTextFieldsToSearchRows(JTextField... fields) {
        for(JTextField field : fields) {
            field.getDocument().addDocumentListener(getListenerToSearch(field));
        }
    }
    
    private void searchPerson(JTextField field) {
        personTable.clearSelection();
        personTable.addColumnSelectionInterval(0, 1);
        String textValue = field.getText().toLowerCase();
        if(field == dateTextField) {//add routes for textFields
            searchPersonByDate(textValue);
        } else {
            searchPersonByName(textValue);
        }
    }

    private void searchPersonByName(String name) {
        for (int i = 0; i < persons.size(); i++) {
            if(persons.get(i).getName().toLowerCase().startsWith(name)) {
                personTable.addRowSelectionInterval(i, i);
            }
        }
    }

    private void searchPersonByDate(String date) {
        for (int i = 0; i < personsDateOfBirth.size(); i++) {
            if(personsDateOfBirth.get(i).startsWith(date)) {
                personTable.addRowSelectionInterval(i, i);
            }
        }
    }

    private DocumentListener getListenerToSearch(JTextField field) {
        return new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchPerson(field);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!field.getText().equals("")) {
                    searchPerson(field);
                } else {
                    personTable.clearSelection();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchPerson(field);
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPersonTable = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        nameTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        searchByNameLabel = new javax.swing.JLabel();
        searchByDateOfBirthLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPersonTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        personTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date of birth"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        personTable.setColumnSelectionAllowed(true);
        personTable.getTableHeader().setReorderingAllowed(false);
        panelPersonTable.setViewportView(personTable);
        personTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (personTable.getColumnModel().getColumnCount() > 0) {
            personTable.getColumnModel().getColumn(0).setResizable(false);
            personTable.getColumnModel().getColumn(1).setResizable(false);
        }

        searchByNameLabel.setText("Search by name");

        searchByDateOfBirthLabel.setText("Search by date of birth");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPersonTable, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchByNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTextField)
                    .addComponent(searchByDateOfBirthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchByNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(searchByDateOfBirthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPersonTable, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JScrollPane panelPersonTable;
    private javax.swing.JTable personTable;
    private javax.swing.JLabel searchByDateOfBirthLabel;
    private javax.swing.JLabel searchByNameLabel;
    // End of variables declaration//GEN-END:variables
}
