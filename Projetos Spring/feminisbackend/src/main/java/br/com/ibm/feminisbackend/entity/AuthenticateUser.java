package br.com.ibm.feminisbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authenticate_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String Password;
}
