package com.sha.courseserver.model;


import com.datastax.driver.core.DataType;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;


@Data
@Table("summary")
public class Summary implements Serializable {

    @PrimaryKeyColumn(name="course_id", type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID courseId;

    @CassandraType(type = DataType.Name.COUNTER)
    @Column("hit_count")
    private Long hitCount;

}
