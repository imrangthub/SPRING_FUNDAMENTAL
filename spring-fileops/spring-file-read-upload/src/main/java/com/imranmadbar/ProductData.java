package com.imranmadbar;

public class ProductData {
	
    private String productCode;
    private String description;
    private boolean isActive;
    private String partnerName;
    private String partnerProductCode;

    public ProductData() {
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public String getPartnerName() {
        return this.partnerName;
    }

    public String getPartnerProductCode() {
        return this.partnerProductCode;
    }

    public void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public void setPartnerName(final String partnerName) {
        this.partnerName = partnerName;
    }

    public void setPartnerProductCode(final String partnerProductCode) {
        this.partnerProductCode = partnerProductCode;
    }

	@Override
	public String toString() {
		return "ProductData [productCode=" + productCode + ", description=" + description + ", isActive=" + isActive
				+ ", partnerName=" + partnerName + ", partnerProductCode=" + partnerProductCode + "]";
	}
    
    
    

}
