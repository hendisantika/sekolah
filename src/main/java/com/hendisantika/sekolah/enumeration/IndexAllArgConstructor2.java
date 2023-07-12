package com.hendisantika.sekolah.enumeration;

import com.hendisantika.sekolah.repository.GaleriRepository;
import com.hendisantika.sekolah.repository.PengunjungRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class IndexAllArgConstructor2 {
    private GaleriRepository galeriRepository;
    private PengunjungRepository pengunjungRepository;

}
