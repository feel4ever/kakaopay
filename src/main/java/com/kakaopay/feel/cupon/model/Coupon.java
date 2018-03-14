package com.kakaopay.feel.cupon.model;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name="coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String email;

    @Column(name="coupon_no", unique=true)
    private String couponNo;

    @Column(name="crated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Coupon(){}

    public Coupon(String email, String couponNo, Date createdAt) {
        this.email = email;
        this.couponNo = couponNo;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", couponNo='" + couponNo + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
