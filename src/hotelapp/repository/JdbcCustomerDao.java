package hotelapp.repository;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import hotelapp.domain.Customer;
import hotelapp.domain.Room;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcCustomerDao implements CustomerDao {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    
    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
    	return namedJdbcTemplate;
    }
    
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
    	this.namedJdbcTemplate = namedJdbcTemplate;
    }
	
	public List<Customer> getCustomerList() {
		logger.info("Getting customers!");
		List<Customer> customers = namedJdbcTemplate.query(
				"select customer_id, last_name, first_name, email, phone_number from customers",
				new CustomerMapper());
		return customers;
	}
	
	public void addCustomer (Customer customer) {
		logger.info("Adding customer: " + customer.getId());
		int count = namedJdbcTemplate.update(
				"insert into customers (last_name, first_name, email, phone_number) "
				+ "values (:lastName, :firstName, :email, :phoneNumber)",
				new MapSqlParameterSource().addValue("lastName", customer.getLastName())
				.addValue("firstName", customer.getFirstName())
				.addValue("email", customer.getEmail())
				.addValue("phoneNumber", customer.getPhoneNumber()));
		logger.info("Rows affected: " + count);
	}
	
    private static class CustomerMapper implements RowMapper<Customer> {

        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getString("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            return customer;
        }

    }

}
