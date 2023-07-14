package com.hendisantika.sekolah.record.constructor;

import com.hendisantika.sekolah.repository.*;
import org.springframework.stereotype.Component;

@Component
public record ConstructorIndex(
        TulisanRepository tulisanRepository,
        PengumumanRepository pengumumanRepository,
        AgendaRepository agendaRepository,
        GuruRepository guruRepository,
        FilesRepository filesRepository,
        SiswaRepository siswaRepository,
        KategoriRepository kategoriRepository,
        KomentarRepository komentarRepository,
        GaleriRepository galeriRepository,
        PengunjungRepository pengunjungRepository) {
}
