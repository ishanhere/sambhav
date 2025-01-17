package com.sambhav.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int productid;
	
	@Column(name = "productname",nullable = false)
	private String productname;
	
	@Column(name = "description",nullable = false,length = 5000)
	private String description;
	
	@Column(name = "qty",nullable = false)
	private int qty;
	
	@Column(name = "price",nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid",nullable = false)
	private Category categoryid;
	
	@ManyToOne
	@JoinColumn(name = "userid",nullable = false)
	private User userid;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "isactive",nullable = false,columnDefinition = "boolean default true")
	private boolean status;
	
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = Transaction.class)
	private List<Product> Productbuyers;
	
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = ReportProduct.class)
	private List<Product> Productreports;
	
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = RequestProduct.class)
	private List<Product> Productrequests;
	
}
