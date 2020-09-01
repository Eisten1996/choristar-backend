package pe.com.choristar.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Claim")
public class Claim {
    @Id
    private String id;

    private Date dateClaim;
    private TypeClaim typeClaim;
    private ObjectId user;
    private String stateClaim;

    public Claim(Date dateClaim, TypeClaim typeClaim, ObjectId user, String stateClaim) {
        this.dateClaim = dateClaim;
        this.typeClaim = typeClaim;
        this.user = user;
        this.stateClaim = stateClaim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateClaim() {
        return dateClaim;
    }

    public void setDateClaim(Date dateClaim) {
        this.dateClaim = dateClaim;
    }

    public TypeClaim getTypeClaim() {
        return typeClaim;
    }

    public void setTypeClaim(TypeClaim typeClaim) {
        this.typeClaim = typeClaim;
    }

    public ObjectId getUser() {
        return user;
    }

    public void setUser(ObjectId user) {
        this.user = user;
    }

    public String getStateClaim() {
        return stateClaim;
    }

    public void setStateClaim(String stateClaim) {
        this.stateClaim = stateClaim;
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
