package org.example.Utilities;

import lombok.Data;

@Data
public class ProductData {
    private String productName;
    private int productPrice;
    private int productQty;

    public void setProductPrice(String price) {
        this.productPrice = Integer.parseInt(price
                .replace("Rp", "")
                .replace(".", "")
                .trim());
    }
}
