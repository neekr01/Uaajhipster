package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class QuoteMapperTest {

    private QuoteMapper quoteMapper;

    @BeforeEach
    public void setUp() {
        quoteMapper = new QuoteMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id2";
        assertThat(quoteMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(quoteMapper.fromId(null)).isNull();
    }
}
