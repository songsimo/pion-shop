package com.example.pion.product.dao;

import com.example.pion.product.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTempDao {

    @Insert("""
            <script>
                INSERT INTO product(name, price)
                VALUES(
                    #{name, jdbcType=VARCHAR},
                    #{price}
                )
            </script>       \s
            """)
    public void save(Product product);
}
