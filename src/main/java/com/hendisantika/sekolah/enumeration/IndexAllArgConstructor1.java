package com.hendisantika.sekolah.enumeration;

import com.hendisantika.sekolah.repository.FilesRepository;
import com.hendisantika.sekolah.repository.KategoriRepository;
import com.hendisantika.sekolah.repository.KomentarRepository;
import com.hendisantika.sekolah.repository.SiswaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class IndexAllArgConstructor1 {
    private FilesRepository filesRepository;
    private SiswaRepository siswaRepository;
    private KategoriRepository kategoriRepository;
    private KomentarRepository komentarRepository;
}
