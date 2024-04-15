package com.hendisantika.sekolah;

import com.hendisantika.sekolah.entity.Guru;
import com.hendisantika.sekolah.repository.GuruRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers")
class SekolahApplicationTests {
    @Autowired
    private GuruRepository guruRepository;

    @BeforeEach
    void init() {
        guruRepository.deleteAll();
    }

    @Test
    void shouldCreateOnePerson() {
        final var guru = guruRepository.saveAll(List.of(new Guru("212", "Itadori Yuji", "L", "Tokyo", LocalDate.now(), "Dukun",
                "photo", "photoBase64", "filename", new byte[(int) "Itadori Yuji".length()]))
        );
        assertEquals(1, guru.size());
        final var person = guru.get(0);
        assertEquals("Itadori Yuji", person.getNama());
        assertEquals("212", person.getNip());
    }

}
