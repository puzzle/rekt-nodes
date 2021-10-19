package ch.puzzle.ln.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Instant;
import java.util.List;

@Entity
public class AliveNode extends PanacheEntity {

    @Column(length = 255, unique = false, nullable = true)
    String email;
    @Column(length = 128, unique = true, nullable = false)
    String nodeId;
    @Column(nullable = false)
    Instant registrationDate;

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

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static List<AliveNode> findByNodeId(String nodeId){
        return AliveNode.list("nodeId", nodeId);
    }
}
