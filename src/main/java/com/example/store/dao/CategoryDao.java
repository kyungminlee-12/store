package com.example.store.dao;

import com.example.store.dto.response.ProductResponseDto;
import com.example.store.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 정책 검색
    /*
    public List<ProductResponseDto.CategoryRes> getCategoryList(Long id){
        String getHistoryQuery = "select history from category where category_id = "+id+" ;";

        //String history=jdbcTemplateObject.queryForObject(getHistoryQuery, )


        return this.jdbcTemplate.query(getCatagoryListQuery,
                (rs, rowNum) -> new ProductResponseDto.CategoryRes(
                        //rs.getLong("category_id"),
                        // rs.getLong("product_id"),
                        rs.getBoolean("dictionary"),
                        rs.getBoolean("fantasy"),
                        rs.getBoolean("history"),
                        rs.getBoolean("horror"),
                        rs.getBoolean("humor"),
                        rs.getBoolean("journal")
                ));
    }

     */

    public ProductResponseDto.CategoryRes selectById(Long id) {
        List<ProductResponseDto.CategoryRes> results=jdbcTemplate.query(
                "select * from category where category_id = ?",
                new RowMapper<ProductResponseDto.CategoryRes>() {
                    @Override
                    public ProductResponseDto.CategoryRes mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ProductResponseDto.CategoryRes res=new ProductResponseDto.CategoryRes(
                                rs.getBoolean("dictionary"),
                                rs.getBoolean("fantasy"),
                                rs.getBoolean("history"),
                                rs.getBoolean("horror"),
                                rs.getBoolean("humor"),
                                rs.getBoolean("journal"));
                                // res.setId(rs.getLom)
                        return res;
                    }
                }, id);
        return results.isEmpty() ? null : results.get(0);
    }

}
