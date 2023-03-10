package br.com.ntt.jpa.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/createTable")
    public String createTable(@RequestBody String tableData) throws JSONException {

        // Controller para criar uma nova pessoa via JSON no Postman

        // A informação no JSON deve constar no seguinte formato:
        // {"tableName": "Table", "columns": ["col1", "col2", "col3"]}

        JSONObject tableJson = new JSONObject(tableData);
        String tableName = tableJson.getString("tableName");
        JSONArray columns = tableJson.getJSONArray("columns");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(tableName);
        queryBuilder.append(" (");

        for (int i = 0; i < columns.length(); i++) {
            String column = columns.getString(i);
            queryBuilder.append(column);
            queryBuilder.append(" varchar(255)");

            if (i != columns.length() - 1) {
                queryBuilder.append(", ");
            }
        }

        queryBuilder.append(")");

        jdbcTemplate.execute(queryBuilder.toString());

        return "Table created successfully";
    }
}
