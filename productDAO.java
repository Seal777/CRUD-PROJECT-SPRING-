package codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class productDAO {
	
 @Autowired
 private JdbcTemplate jdbcTemplate;
 
 
 
 
 public productDAO(JdbcTemplate jdbcTemplate) {
	
	this.jdbcTemplate = jdbcTemplate;
}

public List<product> list()
 {
	String sql="SELECT * from PRODUCT";
 List<product> listproduct =  jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(product.class));
	
	 return listproduct;
 }
 
 public void save(product p)
 {
	 SimpleJdbcInsert insertactor=new SimpleJdbcInsert(jdbcTemplate);
	 insertactor.withTableName("PRODUCT").usingColumns("ID","QUANTITY","NAME");
	 BeanPropertySqlParameterSource param= new BeanPropertySqlParameterSource(p); 
	 insertactor.execute(param);
 }
 
 public product get(int id)
 {
	 String sql="SELECT * FROM PRODUCT WHERE id=?";
	 Object[] args= {id};
	 product pro =jdbcTemplate.queryForObject(sql,args,
			 BeanPropertyRowMapper.newInstance(product.class));

			 return pro;
 }
 
 public void update(product p)
 {
	 String sql="UPDATE PRODUCT SET quantity=:quantity,name=:name WHERE id=:id";
	 BeanPropertySqlParameterSource param=new BeanPropertySqlParameterSource(p);
	 NamedParameterJdbcTemplate template=new NamedParameterJdbcTemplate(jdbcTemplate);
	 
	 template.update(sql,param);
	 
 }
 
 public void delete(int id)
 {
	 String sql="DELETE FROM PRODUCT WHERE id= ?";
	 jdbcTemplate.update(sql,id);
 }
 
 public List<product> list1()
 {
	String sql="select * from PRODUCT order by quantity desc FETCH FIRST 2 ROWS ONLY";
 List<product> listproduct1 =  jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(product.class));
	
	 return listproduct1;
 }
 
 
 

}
