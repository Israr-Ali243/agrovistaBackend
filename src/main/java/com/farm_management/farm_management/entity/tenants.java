package com.farm_management.farm_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class tenants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private String tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @Column(name = "subscription_plan")
    private String subscriptionPlan;
    @Column(name = "created_at")
    private Date createdAt;
}
