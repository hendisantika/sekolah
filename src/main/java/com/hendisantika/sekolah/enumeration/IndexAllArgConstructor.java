package com.hendisantika.sekolah.enumeration;

import com.hendisantika.sekolah.repository.AgendaRepository;
import com.hendisantika.sekolah.repository.GuruRepository;
import com.hendisantika.sekolah.repository.PengumumanRepository;
import com.hendisantika.sekolah.repository.TulisanRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class IndexAllArgConstructor {
    private final TulisanRepository tulisanRepository;
    private final PengumumanRepository pengumumanRepository;
    private final AgendaRepository agendaRepository;
    private final GuruRepository guruRepository;
}
