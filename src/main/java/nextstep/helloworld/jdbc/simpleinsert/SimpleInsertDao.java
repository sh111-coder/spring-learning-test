package nextstep.helloworld.jdbc.simpleinsert;

import java.util.HashMap;
import java.util.Map;

import nextstep.helloworld.jdbc.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SimpleInsertDao {
    private SimpleJdbcInsert insertActor;

    public SimpleInsertDao(DataSource dataSource) {
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    /**
     * Map +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithMap(Customer customer) {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("first_name", customer.getFirstName());
        params.put("last_name", customer.getLastName());
        int id = insertActor.executeAndReturnKey(params).intValue();
        return new Customer(id, customer.getFirstName(), customer.getLastName());
    }

    /**
     * SqlParameterSource +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithBeanPropertySqlParameterSource(Customer customer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(customer);
        int id = insertActor.executeAndReturnKey(params).intValue();
        return new Customer(id, customer.getFirstName(), customer.getLastName());
    }
}
