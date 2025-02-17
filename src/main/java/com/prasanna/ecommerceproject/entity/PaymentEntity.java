package com.prasanna.ecommerceproject.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(nullable = false)
    private String paymentMethod; // CREDIT_CARD, PAYPAL, UPI, etc.

    @Column(nullable = false)
    private String status; // SUCCESS, PENDING, FAILED

    @Column(nullable = false, unique = true)
    private String transaction_id; // ✅ Unique transaction identifier from the payment gateway

    @CreationTimestamp
    private LocalDateTime createdAt;

	public PaymentEntity() {
		super();
	}

	public PaymentEntity(Long id, OrderEntity order, String paymentMethod, String status, String transaction_id,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.transaction_id = transaction_id;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // Getters and Setters
    
}

