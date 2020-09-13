package pe.com.choristar.models;

public class TypeClaim {
    private String claim;

    public TypeClaim(String claim) {
        this.claim = claim;
    }

    public TypeClaim() {
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }
}
