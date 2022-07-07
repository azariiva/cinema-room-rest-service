package cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cinema-room")
public class CinemaRoomConfig {
    private int totalRows;
    private int totalColumns;

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    @Override
    public String toString() {
        return "CinemaRoomConfig{" +
                "totalRows=" + totalRows +
                ", totalColumns=" + totalColumns +
                '}';
    }
}
