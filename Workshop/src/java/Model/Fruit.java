package Model;

import java.io.Serializable;


public class Fruit implements Serializable {
   private int productId;
    private String productName;
    private String description;
    private double price;
    private String productImage;

    public Fruit(int productId, String productName, String description, double price, String productImage) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
    }

    // Getter methods for product properties
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
  
    public String getProductImage() {
        return productImage;
    }
    
    public Fruit(Fruit s){
        this(s.productId,s.productName,s.description,s.price,s.productImage);
    }
    public Fruit(int id){
        this(FruitDB.getFruit(id));
    }

    public int addNew(){
        return FruitDB.newFruit(this);
    }

    public Fruit update(){
        return FruitDB.update(this);
    }
    
    public int delete(){
        return FruitDB.delete(this.productId);
    }

    @Override
    public String toString() {
        return "Fruit{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", price=" + price + ", productImage=" + productImage + '}';
    }
    
    
}
