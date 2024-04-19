import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Main extends JFrame {
    private JTextField idField, nameField, ageField, cityField;

    public Main() {
        setTitle("Add Product");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("City:"));
        cityField = new JTextField();
        panel.add(cityField);

        JButton addButton = new JButton("Add");
        JButton readButton = new JButton("Read");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
        panel.add(addButton);
        panel.add(readButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        add(panel);
        setVisible(true);
    }

    private void addUser() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("users");
            MongoCollection<Document> collection = database.getCollection("user");

            String id = idField.getText();
            String name = nameField.getText();
            double age = Double.parseDouble(ageField.getText());
            String city = cityField.getText();

            Document document = new Document()
                    .append("name", name)
                    .append("age", age)
                    .append("city", city);

            collection.insertOne(document);
            JOptionPane.showMessageDialog(this, "Product added successfully!");
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readUser() {
        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("users");
            MongoCollection<Document> collection = database.getCollection("user");

            String id = idField.getText();
            Document document = collection.find(new Document("_id", new ObjectId(id))).first();
            if (document != null) {
                nameField.setText(document.getString("name"));
                ageField.setText(String.valueOf(document.getDouble("age")));
                cityField.setText(document.getString("city"));
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUser() {
        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("users");
            MongoCollection<Document> collection = database.getCollection("user");

            String id = idField.getText();
            Document document = collection.find(new Document("_id", new ObjectId(id))).first();
            if (document != null) {
                String name = nameField.getText();
                double age = Double.parseDouble(ageField.getText());
                String city = cityField.getText();

                Document newDocument = new Document()
                        .append("name", name)
                        .append("age", age)
                        .append("city", city);

                collection.updateOne(document, new Document("$set", newDocument));
                JOptionPane.showMessageDialog(this, "User updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteUser() {
        try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("users");
            MongoCollection<Document> collection = database.getCollection("user");

            String id = idField.getText();
            Document document = collection.find(new Document("_id", new ObjectId(id))).first();
            if (document != null) {
                collection.deleteOne(document);
                JOptionPane.showMessageDialog(this, "User deleted successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        cityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}

