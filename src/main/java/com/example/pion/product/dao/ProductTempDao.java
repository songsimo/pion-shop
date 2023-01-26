package com.example.pion.product.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.pion.product.domain.Product;

@Mapper
public interface ProductTempDao {
	
	@Insert("""
	<script>
			Insert INTO product(name, price)
			VALUES(
				#{name},
				#{price}
			)
	</script>		
	""")
	public void save(Product product);
}
