package com.hendisantika.sekolah.controller.constructor;

import com.hendisantika.sekolah.repository.*;
import java.util.Objects;
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
    public ConstructorIndex {
        Objects.requireNonNull(tulisanRepository);
        Objects.requireNonNull(pengumumanRepository);
        Objects.requireNonNull(agendaRepository);
        Objects.requireNonNull(guruRepository);
        Objects.requireNonNull(filesRepository);
        Objects.requireNonNull(siswaRepository);
        Objects.requireNonNull(kategoriRepository);
        Objects.requireNonNull(komentarRepository);
        Objects.requireNonNull(galeriRepository);
        Objects.requireNonNull(pengunjungRepository);
    }
}
