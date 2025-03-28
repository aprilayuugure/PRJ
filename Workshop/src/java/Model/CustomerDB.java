
package Model;

import java.sql.*;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDB implements DatabaseInfo{
    public static Connection getConnect()
    {
        try 
        {
            Class.forName(DRIVERNAME);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error loading driver" + e);
        }
        
        try
        {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }
        
        return null;
    }
    
    public static Customer getCustomerByEmail(String email)
    {
        Customer c = null;
        
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT CustomerID, FirstName, LastName, Email, Password, Address, Phone, RegistrationDate FROM Customers WHERE Email = ?");
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String password = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                Date registration_date = rs.getDate(8);
                
                c = new Customer(id, first_name, last_name, email, password, address, phone, registration_date);
            }
            con.close();
            
            return c;
        }
        catch (Exception ex)
        {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static int newCustomer(Customer c)
    {
        int id = -1;
        
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Customers(CustomerID, FirstName, LastName, Email, Password, Address, Phone, RegistrationDate) output inserted.id values(?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, c.getFirstName());
            stmt.setString(2, c.getLastName());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getPassword());
            stmt.setString(5, c.getAddress());
            stmt.setString(6, c.getPhone());
            stmt.setDate(7, c.getRegistrationDate());
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                id = rs.getInt(1);
            }
            con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public static Customer update(Customer c)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE Customers SET FirstName = ?, LastName = ?");
            stmt.setString(1, c.getFirstName());
            stmt.setString(2, c.getLastName());
            
            int rc = stmt.executeUpdate();
            
            con.close(); return c;
        }
        catch (Exception ex)
        {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid data");
        }
    }
    
    public static int delete(int id)
    {
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Customers WHERE CustomerID = ?");
            stmt.setInt(1, id);
            
            int rc = stmt.executeUpdate();
            
            con.close(); return rc;
        }
        catch (Exception ex)
        {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static ArrayList<Customer> search(Predicate<Customer> p)
    {
        ArrayList<Customer> list_all = listAll();
        
        ArrayList<Customer> a = new ArrayList<Customer>();
        
        for (Customer c : list_all)
        if (p.test(c)) a.add(c);
        
        return a;
    }
    
    public static ArrayList<Customer> listAll() 
    {
        ArrayList<Customer> list = new ArrayList<Customer>();
        
        try (Connection con = getConnect())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT CustomerID, FirstName, LastName, Email, Password, Address, Phone, RegistrationDate FROM Customers");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8)));
            }
            
            con.close(); return list;
        }
        catch (Exception ex)
        {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void main(String[] a){     
       
    }
}
