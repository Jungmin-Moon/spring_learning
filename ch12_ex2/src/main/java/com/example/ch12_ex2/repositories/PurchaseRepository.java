package com.example.ch12_ex2.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ch12_ex2.model.Purchase;

@Repository
public class PurchaseRepository {
	
	private final JdbcTemplate jdbc;
	
	public PurchaseRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public void storePurchase(Purchase purchase) {
		String sql = "INSERT into purchase VALUES (DEFAULT, ?, ?)";
		
		jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
	}
	
	public List<Purchase> findAllPurchases() {
		//this would normally return a ResultSet
		String sql = "SELECT * FROM purchase";
		
		//This transforms that result set into a row mapper
		RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(r.getInt("id"));
			rowObject.setProduct(r.getString("product"));
			rowObject.setPrice(r.getBigDecimal("price"));
			return rowObject;
		};
		
		return jdbc.query(sql, purchaseRowMapper);
	}
}
