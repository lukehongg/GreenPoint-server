package com.greenpoint.server.level.model;

import com.greenpoint.server.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE level SET deleted = true Where id = ?")
public class Level extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Customer customer;

    private String name;

}
