package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ProductBean;

public class ProductDAO extends DAO{
	public ProductBean search(int id) throws Exception{
		ProductBean p = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from products where id=? and del_flag = 0");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			p = new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			p.setText(rs.getString("text"));
			p.setImage(rs.getString("image"));
			p.setDel_flag(rs.getInt("del_flag"));
		}

		st.close();
		con.close();
		return p;
	}

	public List<ProductBean> selectAll() throws Exception{
		ProductBean p = null;
		List<ProductBean> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from products where del_flag = 0 order by id asc");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			p = new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			p.setText(rs.getString("text"));
			p.setImage(rs.getString("image"));
			p.setDel_flag(rs.getInt("del_flag"));
			list.add(p);
		}

		st.close();
		con.close();
		return list;
	}

	public int insert(ProductBean product) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("insert into products (name, price, stock, text, image) values(?, ?, ?, ?, ?);");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setInt(3, product.getStock());
		st.setString(4, product.getText());
		st.setString(5, product.getImage());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	public int update(ProductBean product) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("update products set name=?, price=?, stock=?, text=?, image=? where id=?");


		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setInt(3, product.getStock());
		st.setString(4, product.getText());
		st.setString(5, product.getImage());
		st.setInt(6, product.getId());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	public int delete(int id) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("update products set del_flag=1 where id=?");
		st.setInt(1, id);

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}



}