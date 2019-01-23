package com.company;

public class OvernightParcel extends Parcel {
    private boolean isSignatureRequired;

    public OvernightParcel(String id, double weight, boolean isSignatureRequired) {
        super(id, weight);
        this.isSignatureRequired = isSignatureRequired;
    }

    public boolean isSignatureRequired() {
        return isSignatureRequired;
    }

    public void setSignatureRequired(boolean signatureRequired) {
        isSignatureRequired = signatureRequired;
    }


    @Override
    public String toString() {
        return super.toString() + "\nSignature Required: " + isSignatureRequired;
    }
}
