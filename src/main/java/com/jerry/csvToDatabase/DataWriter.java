package com.jerry.csvToDatabase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataWriter {
    public static void saveDataToDatabase(List<Data> dataList) throws IOException, SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query =
                    "INSERT INTO food_data (no, food_code, food_name, food_lc, food_dc, serve_size, unit, kcal, water, protein, fat, carbohydrate, total_sugar, sodium, source_from, agency) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            for (Data data : dataList) {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, data.getNo());
                pstmt.setString(2, data.getFoodCode());
                pstmt.setString(3, data.getFoodName());
                pstmt.setString(4, data.getFoodLC());
                pstmt.setString(5, data.getFoodDC());
                pstmt.setString(6, data.getServeSize());
                pstmt.setString(7, data.getUnit());
                pstmt.setString(8, data.getKcal());
                pstmt.setString(9, data.getWater());
                pstmt.setString(10, data.getProtein());
                pstmt.setString(11, data.getFat());
                pstmt.setString(12, data.getCarbohydrate());
                pstmt.setString(13, data.getTotalSugar());
                pstmt.setString(14, data.getSodium());
                pstmt.setString(15, data.getSourceFrom());
                pstmt.setString(16, data.getAgency());

                pstmt.executeUpdate();
                pstmt.close();
            }
        }
    }
}
