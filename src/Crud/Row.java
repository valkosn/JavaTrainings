package crud;

import java.util.Objects;

/**
 * @author Orest Lozynskyy
 * @since 28-Mar-16
 */
public class Row {
  private String id;
  private String productName;
  private String price;
  private String quantity;

  private static final String PATTERN = "%-8.8s%-30.30s%-8.8s%-4.4s";

  public Row(String source) {
    int i = 0;
    this.id = source.substring(i, i+=8).trim();
    this.productName = source.substring(i, i+=30).trim();
    this.price = source.substring(i, i+=8).trim();
    this.quantity = source.substring(i).trim();
  }

  public Row(String id, String productName, String price, String quantity) {
    this.id = id == null ? null : id.trim();
    this.productName = productName.trim();
    this.price = price.trim();
    this.quantity = quantity.trim();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return String.format(PATTERN, id, productName, price, quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (this == obj) return true;
    if (obj instanceof Row)
    {
      Row that = (Row) obj;
      if (!this.getId().equals(that.getId()))                   return false;
      if (!this.getProductName().equals(that.getProductName())) return false;
      if (!this.getPrice().equals(that.getPrice()))             return false;
      if (!this.getQuantity().equals(that.getQuantity()))       return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Row row = new Row("Шорты пляжные синие           159.00  12");
    System.out.println(row);
  }
}
