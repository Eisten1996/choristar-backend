package pe.com.choristar.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Request")
public class Request {
    @Id
    private String id;

    private Date dateRequest;
    private TypeRequest typeRequest;
    private ObjectId user;
    private String stateRequest;

    public Request() {
    }

    public Request(Date dateRequest, TypeRequest typeRequest, ObjectId user, String stateRequest) {
        this.dateRequest = dateRequest;
        this.typeRequest = typeRequest;
        this.user = user;
        this.stateRequest = stateRequest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public TypeRequest getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(TypeRequest typeRequest) {
        this.typeRequest = typeRequest;
    }

    public ObjectId getUser() {
        return user;
    }

    public void setUser(ObjectId user) {
        this.user = user;
    }

    public String getStateRequest() {
        return stateRequest;
    }

    public void setStateRequest(String stateRequest) {
        this.stateRequest = stateRequest;
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