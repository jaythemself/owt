//package com.owt.owtbackend.models;
//
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Entity;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//public class site extends abstractEntity{
//
//    @NotBlank(message = "Location name is required.")
//    private String siteName;
//
//    @NotBlank(message = "Street address of location is required.")
//    @Size(min = 1, max = 50)
//    private String siteAddress;
//
//    @NotBlank(message = "City the site is located in is required.")
//    private String siteCity;
//
//    @NotBlank(message = "State the site is located in is required.")
//    private String siteState;
//
//    @Size(min= 5, message= "Must be a valid zipcode. Please use XXXXX or XXXXX-XXXX format.")
//    private String siteZip;
//
//    private boolean AccessibilityCheckOne;
//    private boolean AccessibilityCheckTwo;
//
//
//
//    public String getSiteName() {
//        return siteName;
//    }
//
//    public void setSiteName(String siteName) {
//        this.siteName = siteName;
//    }
//
//    public String getSiteAddress() {
//        return siteAddress;
//    }
//
//    public void setSiteAddress(String siteAddress) {
//        this.siteAddress = siteAddress;
//    }
//
//    public String getSiteCity() {
//        return siteCity;
//    }
//
//    public void setSiteCity(String siteCity) {
//        this.siteCity = siteCity;
//    }
//
//    // keep doing this for state, zip, accessibility booleans.
//    //     public String getSite??() {
//    //        return site??;
//    //    }
//    //
//    //    public void setSite??(String site??) {
//    //        this.site?? = site??;
//    //    }
//    // OR
//    //    public boolean isAccessibilityCheckName() {
//    //    return accessibilityCheckName;
//    //    }
//    //
//    //    public void setAccessibilityCheckName(boolean accessibilityCheckName) {
//    //        this.accessibilityCheckName = accessibilityCheckName;
//    //    }
//
//// double check Overrides for boolean portion and things like multiple booleans tripped = wheelchair accessible
//    }
//}