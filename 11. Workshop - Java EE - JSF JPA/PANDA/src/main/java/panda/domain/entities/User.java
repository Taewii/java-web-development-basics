package panda.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import panda.domain.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Email
    @Column(nullable = false)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Package> packages = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Receipt> receipts = new ArrayList<>();

    public void addPackage(Package packet) {
        packages.add(packet);
        packet.setRecipient(this);
    }

    public void removePackage(Package packet) {
        packages.remove(packet);
        packet.setRecipient(null);
    }

    public void addReceipt(Receipt receipt) {
        this.receipts.add(receipt);
        receipt.setRecipient(this);
    }

    public void removeReceipt(Receipt receipt) {
        this.receipts.remove(receipt);
        receipt.setRecipient(null);
    }
}
