package ch.puzzle.ln.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Instant;
import java.util.List;

@Entity
public class RektNode extends PanacheEntity {

    @Column(length = 255, unique = false, nullable = true)
    String email;
    @Column(length = 128, unique = true, nullable = false)
    String nodeId;
    @Column(length = 128, unique = true, nullable = false)
    String signature;
    @Column(nullable = false)
    Instant registrationDate;
    @Column(nullable = true)
    Instant rektDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Instant getRektDate() {
        return rektDate;
    }

    public void setRektDate(Instant rektDate) {
        this.rektDate = rektDate;
    }

    public static List<RektNode> findByNodeId(String nodeId){
        return RektNode.list("nodeId", nodeId);
    }
}
